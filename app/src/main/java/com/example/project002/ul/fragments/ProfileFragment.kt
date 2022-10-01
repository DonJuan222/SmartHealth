package com.example.project002.ul.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.project002.data.viewmodels.LoginViewModel
import com.example.project002.databinding.FragmentProfileBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class ProfileFragment : Fragment() {

    private var _binding:FragmentProfileBinding?=null
    private val binding:FragmentProfileBinding get() = _binding!!
//    private val loginViewModel: LoginViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
    }



}