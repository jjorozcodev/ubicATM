package com.soyjj.ubicatm.Fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

import com.soyjj.ubicatm.R


class MapsFragment : Fragment(), OnMapReadyCallback {

    lateinit var mapFragment : SupportMapFragment
    lateinit var googleMap : GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        (activity!!.supportFragmentManager.findFragmentById(com.soyjj.ubicatm.R.id.maps) as SupportMapFragment?)?.let {
            it.getMapAsync(OnMapReadyCallback {
                googleMap = it
                val uca = LatLng(12.12,-86.27)
                googleMap.addMarker(MarkerOptions().position(uca).title("UCA"))
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(uca, 15f))

            })
        }
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onMapReady(p0: GoogleMap) {
        googleMap = p0
        val uca = LatLng(12.12,-86.27)
        googleMap.addMarker(MarkerOptions().position(uca).title("UCA"))
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(uca, 15f))

    }
}
