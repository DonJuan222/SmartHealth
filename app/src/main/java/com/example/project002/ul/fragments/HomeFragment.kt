package com.example.project002.ul.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project002.interfaces.OnServiceClickListener
import com.example.project002.R
import com.example.project002.ul.adapters.ServiceAdapter
import com.example.project002.data.models.ServiceModel
import com.example.project002.data.viewmodels.HomeViewModel
import com.example.project002.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class HomeFragment : Fragment() {

    private var _binding:FragmentHomeBinding? =null
    private val binding: FragmentHomeBinding get() = _binding!!
    private lateinit var serviceAdapter: ServiceAdapter
    private val homeViewModel: HomeViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentHomeBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        homeViewModel.getServices()
        serviceAdapter= ServiceAdapter(
            mutableListOf()
        )
        serviceAdapter.listener=object : OnServiceClickListener {
            override fun onClick(item: ServiceModel) {
                Log.d("Hola", item.title)
            }

        }
        binding.homeFragmentRecycler.apply {
            adapter=serviceAdapter
            layoutManager=LinearLayoutManager(requireContext())
        }
        observeViewModel()
    }
    private fun observeViewModel(){
        homeViewModel.services.observe(viewLifecycleOwner, Observer {
            serviceAdapter.changeDataSet(it)
        })
    }
}