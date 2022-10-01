package com.example.project002.ul.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project002.interfaces.OnServiceClickListener
import com.example.project002.R
import com.example.project002.data.models.DoctorModel
import com.example.project002.data.models.ServiceModel
import com.example.project002.data.viewmodels.HomeViewModel
import com.example.project002.databinding.FragmentSpecialistBinding
import com.example.project002.interfaces.OnDoctorClickListener
import com.example.project002.ul.adapters.DoctorAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class SpecialistFragment : Fragment() {

    private var _binding:FragmentSpecialistBinding? =null
    private val binding: FragmentSpecialistBinding get() = _binding!!
    private val args: SpecialistFragmentArgs by navArgs()
    private lateinit var doctorAdapter: DoctorAdapter
    private val homeViewModel: HomeViewModel by sharedViewModel()
    private lateinit var categories: MutableList<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentSpecialistBinding.inflate(inflater,container, false)

        return binding.root
    }

    override fun onStart() {
        super.onStart()

        if (args.search) {
            homeViewModel.getSpecialists(null)
            binding.specialistFragmentSearch.visibility = View.VISIBLE
            binding.specialistTittleList.visibility = View.GONE
            binding.specialistTittle.text = getString(R.string.specialist_fragment_title)
            binding.specialistSubtittle.text = getString(R.string.specialist_fragment_subtitle)
        }else{
            binding.specialistFragmentSearch.visibility = View.GONE
            binding.specialistTittleList.visibility = View.VISIBLE
            binding.specialistTittle.text = args.name
            homeViewModel.getSpecialists(args.name)
            binding.specialistSubtittle.text = args.description
        }
        doctorAdapter = DoctorAdapter(mutableListOf())
        doctorAdapter.listener = object : OnDoctorClickListener{
            override fun  onClick(item: DoctorModel){
                homeViewModel.selectedDoctor(item)
                findNavController().navigate(R.id.action_specialistFragment_to_specialistDetailFragment)
            }
        }
        binding.specialistFragment.apply {
            adapter=doctorAdapter
            layoutManager=LinearLayoutManager(requireContext())
        }
        observeViewModels()
    }
    private fun observeViewModels(){
        homeViewModel.doctors.observe(viewLifecycleOwner, Observer {
            doctorAdapter.changeDataSet(it)
        })
        homeViewModel.services.observe(viewLifecycleOwner, Observer {
            categories = mutableListOf(
                "Todos"
            )
            it.forEach {
                categories.add(it.title)
            }
            binding.specialistFragmentSearchAutocomplete.setAdapter(
                ArrayAdapter(requireContext(),android.R.layout.simple_dropdown_item_1line, categories))
            binding.specialistFragmentSearchAutocomplete.setOnItemClickListener { parent, view, position, id ->
                var category = categories[position]
                if (category != "Todos")
                    homeViewModel.getSpecialists(category)

                else
                    homeViewModel.getSpecialists(null)
//            doctorAdapter.changeDataSet(doctorList)

            }
        })
    }

}