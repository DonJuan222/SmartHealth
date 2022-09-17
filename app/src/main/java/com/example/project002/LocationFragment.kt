package com.example.project002

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.project002.databinding.FragmentLocationBinding


class BlankFragment : Fragment() {

    private var  _binding: FragmentLocationBinding? =null
    private val binding: FragmentLocationBinding get() =  _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentLocationBinding.inflate(inflater, container, false)
        return binding.root
    }
}