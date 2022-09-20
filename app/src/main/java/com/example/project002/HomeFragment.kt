package com.example.project002

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project002.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding:FragmentHomeBinding? =null
    private val binding: FragmentHomeBinding get() = _binding!!
    private lateinit var serviceAdapter: ServiceAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentHomeBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        serviceAdapter= ServiceAdapter(
            listOf(
                ServiceModel(
                    "1","General","Los mejores especialistas en Medicina General",
                    R.drawable.ico_general.toString()
                ),
                ServiceModel(
                    "2","Especialidades","Los mejores medicos Especialistas",
                    R.drawable.ico_especialidades.toString()
                ),
                ServiceModel(
                    "3","Odontologia","Los mejores especialistas en Odontologia",
                    R.drawable.ico_odontologia.toString()
                ),
                ServiceModel(
                    "4","Dermatologia","Los mejores especialistas en Dermatologia",
                    R.drawable.ico_dermatologia.toString()
                )
            )
        )

        binding.homeFragmentRecycler.apply {
            adapter=serviceAdapter
            layoutManager=LinearLayoutManager(requireContext())
        }
    }
}