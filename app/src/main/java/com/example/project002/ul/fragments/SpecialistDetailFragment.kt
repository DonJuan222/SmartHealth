package com.example.project002.ul.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.project002.R
import com.example.project002.data.viewmodels.HomeViewModel
import com.example.project002.databinding.FragmentSpecialistBinding
import com.example.project002.databinding.FragmentSpecialistDetailBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class SpecialistDetailFragment : Fragment() {

    private var _binding: FragmentSpecialistDetailBinding? = null
    private val binding: FragmentSpecialistDetailBinding get() = _binding!!
    private val homeViewModel:HomeViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSpecialistDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        observeViewModel()
    }
    private fun observeViewModel(){
        homeViewModel.doctor.observe(viewLifecycleOwner, Observer {
//            binding.
        })
    }
}