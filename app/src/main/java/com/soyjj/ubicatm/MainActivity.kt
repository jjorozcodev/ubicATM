package com.soyjj.ubicatm

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.soyjj.ubicatm.Adapters.ATMadapter
import com.soyjj.ubicatm.Fragments.AtmsFragment
import com.soyjj.ubicatm.Fragments.MapsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val manager = supportFragmentManager

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                createFragment(AtmsFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                createFragment(MapsFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createFragment(AtmsFragment())

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    fun createFragment(fragmento : Fragment){
        val transac = manager.beginTransaction()
        transac.replace(R.id.contenedorFragments, fragmento)
//        transac.addToBackStack(null)
        transac.commit()
    }
}
