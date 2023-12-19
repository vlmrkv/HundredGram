package com.mrkv.hundredgram.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mrkv.hundredgram.R

class MainActivity : AppCompatActivity() {

    lateinit var bottomNav: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(ProfileFragment(this))

        bottomNav = findViewById(R.id.bottom_nav)
        bottomNav.setOnClickListener { view ->
            when (view.id) {
                R.id.tape -> {
                    loadFragment(TapeFragment())
                }
                R.id.take_photo -> {
                    loadFragment(CameraFragment())
                }
                R.id.profile -> {
                    loadFragment(ProfileFragment(this))
                }

            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container_view, fragment)
        transaction.commit()
    }
}