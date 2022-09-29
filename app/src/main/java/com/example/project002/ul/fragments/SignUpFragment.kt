package com.example.project002.ul.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.project002.R
import com.example.project002.databinding.FragmentSignUpBinding
import com.example.project002.isValidEmail
import com.example.project002.isValidPassword

class SignUpFragment : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding: FragmentSignUpBinding get() = _binding!!

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
    }
}