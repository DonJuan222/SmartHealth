package com.example.project002

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.project002.databinding.FragmentProfileBinding


class ProfileFragment : DialogFragment() {

    private var _binding:FragmentProfileBinding?=null
    private val binding:FragmentProfileBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }


}