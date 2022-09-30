package com.example.project002.ul.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project002.interfaces.OnServiceClickListener
import com.example.project002.R
import com.example.project002.data.models.DoctorModel
import com.example.project002.data.models.ServiceModel
import com.example.project002.databinding.FragmentSpecialistBinding
import com.example.project002.interfaces.OnDoctorClickListener
import com.example.project002.ul.adapters.DoctorAdapter


class SpecialistFragment : Fragment() {

    private var _binding:FragmentSpecialistBinding? =null
    private val binding: FragmentSpecialistBinding get() = _binding!!
    private val args: SpecialistFragmentArgs by navArgs()
    private lateinit var doctorAdapter: DoctorAdapter
    private lateinit var doctorList: List<DoctorModel>
    private lateinit var originalList: List<DoctorModel>
    private lateinit var categories: List<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentSpecialistBinding.inflate(inflater,container, false)

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        categories = listOf(
            "Todos","Especialista","Dermatologia","Odontologia","General"
        )
        originalList = listOf(
            DoctorModel("1","Dr David Quintero", "Especialista","350+ pacientes", R.drawable.doc1.toString(),
                5.0, "Médicos con estudios avanzados y capacitación clínica en un área específica."),
            DoctorModel("2","Dr Juan Diego Polindara ", "Dermatologia","350+ pacientes", R.drawable.doc1.toString(),
                5.0, "Médicos con estudios avanzados y capacitación clínica en un área específica."),
            DoctorModel("3","Dr Lorena ", "Odontologia","350+ pacientes", R.drawable.doc1.toString(),
                5.0, "Médicos con estudios avanzados y capacitación clínica en un área específica."),
            DoctorModel("4","Dr Santiago", "General","350+ pacientes", R.drawable.doc1.toString(),
                5.0, "Médicos con estudios avanzados y capacitación clínica en un área específica.")

        )
        doctorList = listOf(
            DoctorModel("1","Dr David Quintero", "Especialista","350+ pacientes", R.drawable.doc1.toString(),
                5.0, "Médicos con estudios avanzados y capacitación clínica en un área específica."),
            DoctorModel("2","Dr Juan Diego Polindara ", "Dermatologia","350+ pacientes", R.drawable.doc1.toString(),
                5.0, "Médicos con estudios avanzados y capacitación clínica en un área específica."),
            DoctorModel("3","Dr Lorena ", "Odontologia","350+ pacientes", R.drawable.doc1.toString(),
                5.0, "Médicos con estudios avanzados y capacitación clínica en un área específica."),
            DoctorModel("4","Dr Santiago", "General","350+ pacientes", R.drawable.doc1.toString(),
                5.0, "Médicos con estudios avanzados y capacitación clínica en un área específica.")

        )
        if (args.search) {
            binding.specialistFragmentSearch.visibility = View.VISIBLE
            binding.specialistTittleList.visibility = View.GONE
            binding.specialistTittle.text = getString(R.string.specialist_fragment_title)
            binding.specialistSubtittle.text = getString(R.string.specialist_fragment_subtitle)
        }else{
            binding.specialistFragmentSearch.visibility = View.GONE
            binding.specialistTittleList.visibility = View.VISIBLE
            binding.specialistTittle.text = args.name
            doctorList = originalList.filter { x -> x.speciality == args.name }
            binding.specialistSubtittle.text = args.description
        }
        doctorAdapter = DoctorAdapter(doctorList)
        doctorAdapter.listener = object : OnDoctorClickListener{
            override fun  onClick(item: DoctorModel){
                Log.d("HOLA", item.name)
            }
        }

        binding.specialistFragmentSearchAutocomplete.setAdapter(
            ArrayAdapter(requireContext(),android.R.layout.simple_dropdown_item_1line, categories))
        binding.specialistFragmentSearchAutocomplete.setOnItemClickListener { parent, view, position, id ->
            var category = categories[position]
            if (category != "Todos")
                doctorList = originalList.filter { x -> x.speciality == category }
            else
                doctorList = originalList
            doctorAdapter.changeDataSet(doctorList)

        }
        binding.specialistFragment.apply {
            adapter=doctorAdapter
            layoutManager=LinearLayoutManager(requireContext())
        }
    }
}