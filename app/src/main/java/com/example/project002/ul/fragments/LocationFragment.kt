package com.example.project002.ul.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.project002.R
import com.example.project002.data.viewmodels.HomeViewModel
import com.example.project002.databinding.FragmentLocationBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class BlankFragment : Fragment(), OnMapReadyCallback {

    private var  _binding: FragmentLocationBinding? =null
    private val binding: FragmentLocationBinding get() =  _binding!!
    private lateinit var mMap:GoogleMap
    private val homeViewModel: HomeViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentLocationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val mapFragment:SupportMapFragment = childFragmentManager.findFragmentById(R.id.fragment_location_map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        observeViewModels()
    }

    override fun onMapReady(map: GoogleMap) {
        mMap = map
        mMap.uiSettings.isScrollGesturesEnabled = true
        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.uiSettings.isZoomGesturesEnabled = true
        mMap.uiSettings.isCompassEnabled = true
        mMap.mapType=GoogleMap.MAP_TYPE_SATELLITE
        this.homeViewModel.getInfo()
    }
    private fun observeViewModels(){
        this.homeViewModel.company.observe(viewLifecycleOwner, Observer {
        val  lating:LatLng=LatLng(it.lat, it.lng)
        mMap.addMarker(MarkerOptions().position(lating)
            .title(it.name))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lating, 12.0f))
        })
    }
}