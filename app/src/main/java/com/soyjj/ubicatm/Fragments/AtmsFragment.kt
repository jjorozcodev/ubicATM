package com.soyjj.ubicatm.Fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.soyjj.ubicatm.Adapters.ATMadapter
import com.soyjj.ubicatm.R

class AtmsFragment : Fragment() {

    var v : View? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_atms, container, false)

        val adaptadorcito = ATMadapter(this!!.context!!)
        val miRv = v!!.findViewById(R.id.rvAtms) as RecyclerView
        miRv.layoutManager = LinearLayoutManager(this!!.context!!)

        miRv.adapter=adaptadorcito
        return v
    }

}
