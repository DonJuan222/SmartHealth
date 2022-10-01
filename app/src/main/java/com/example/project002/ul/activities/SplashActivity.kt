package com.example.project002.ul.activities

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.project002.data.AppDatabase
import com.example.project002.data.datasources.MemoryDataSource
import com.example.project002.data.viewmodels.LoginViewModel
import com.example.project002.databinding.ActivitySplashBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    private val db: AppDatabase by inject<AppDatabase>()
    private val memoryDataSource:MemoryDataSource by inject()
    private val scope= CoroutineScope(newSingleThreadContext("splash"))
    private val loginViewModel:LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
//        scope.launch {
//            if (db.doctorDao().count() == 0){
//                db.doctorDao().insertAll(memoryDataSource.getSpecialist(null))
//            }
//            if (db.serviceDao().count() == 0){
//                db.serviceDao().insertAll(memoryDataSource.getServices())
//            }
//        }
        binding.splashAnimation.playAnimation()

        binding.splashAnimation.addAnimatorListener(object: Animator.AnimatorListener{
            override fun onAnimationStart(animation: Animator?) {

            }

            override fun onAnimationEnd(animation: Animator?) {

                loginViewModel.currentUser()
//                val intent=Intent(applicationContext, LoginActivity::class.java)
//                startActivity(intent)
//                finish()
            }

            override fun onAnimationCancel(animation: Animator?) {

            }

            override fun onAnimationRepeat(animation: Animator?) {

            }

        })
        observeViewModels()
    }
    private fun observeViewModels(){
        loginViewModel.user.observe(this, Observer {
            var intent = Intent(applicationContext, LoginActivity::class.java)
            if (it != null){
                intent = Intent(applicationContext, HomeActivity::class.java)
            }
            startActivity(intent)
            finish()
        })

    }
}