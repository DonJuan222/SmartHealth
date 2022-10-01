package com.example.project002.ul.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.project002.R
import com.example.project002.data.viewmodels.LoginViewModel
import com.example.project002.databinding.FragmentSignUpBinding
import com.example.project002.isValidEmail
import com.example.project002.isValidPassword
import com.example.project002.ul.activities.HomeActivity
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignUpFragment : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding: FragmentSignUpBinding get() = _binding!!
    private val loginViewModel:LoginViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        binding.fragmentSignupButton.setOnClickListener {
            val id= binding.signupRadioGroup.checkedRadioButtonId
            val radioButton = requireActivity().findViewById(id) as RadioButton
            loginViewModel.signUp(
                binding.signupEmail.text.toString(),
                binding.signupPassword.text.toString(),
                binding.signupName.text.toString(),
                radioButton.text.toString()
            )
        }

        binding.fragmentSignupButton.setOnClickListener {
            if (!binding.signupEmail.text.toString().isValidEmail()) {
                binding.signupEmailLayout.error = getString(R.string.email_error2)
            } else {
                binding.signupEmailLayout.error = null
            }
            if (!binding.signupPassword.text.toString().isValidPassword()){
                binding.signupPasswordLayout.error=getString(R.string.password_error2)
            }else{
                binding.signupPasswordLayout.error=null
            }
        }

        binding.fragmentSignupLabel2.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_loginFragment2)
        }
        observeViewModels()
    }
    private fun observeViewModels(){
        loginViewModel.signUp.observe(viewLifecycleOwner, Observer {
            if (it){
               findNavController().navigate(R.id.action_signUpFragment_to_loginFragment2)
            }else{
                Snackbar.make(binding.root,getString(R.string.signup_error), Snackbar.LENGTH_LONG).show()

            }
        })
    }
}