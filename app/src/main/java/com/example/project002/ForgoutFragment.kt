package com.example.project002

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.project002.databinding.FragmentForgoutBinding
import com.example.project002.databinding.FragmentLoginBinding

class ForgoutFragment : Fragment() {

    private var _binding: FragmentForgoutBinding? = null
    private val binding: FragmentForgoutBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentForgoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        binding.fragmentForgoutButton.setOnClickListener {
            if (!binding.forgoutEmail.text.toString().isValidEmail()) {
                binding.forgoutEmailLayout.error = getString(R.string.email_error)
            } else {
                binding.forgoutEmailLayout.error = null
            }
        }

        binding.fragmentForgoutLabel2.setOnClickListener {
            findNavController().navigate(R.id.action_forgoutFragment_to_signUpFragment)
        }
    }

}