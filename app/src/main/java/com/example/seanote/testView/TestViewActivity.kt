package com.example.seanote.testView

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.seanote.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class TestViewActivity : AppCompatActivity() {

    private lateinit var bottomNavView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_test)
        bottomNavView = findViewById(R.id.bottom_nav_bar)
        initBottomNavView()
        bottomNavView.selectedItemId = R.id.test_menu_1
    }

    private fun initBottomNavView() {
        bottomNavView.setOnItemSelectedListener { itemMenu ->
            when (itemMenu.itemId) {
                R.id.test_menu_1 -> {
                    transferToFragment(TestTextColorIconFragment.newInstance())
                    true
                }
                R.id.test_menu_2 -> {
                    true
                }
                R.id.test_menu_3 -> {
                    true
                }
                else -> false
            }
        }
    }

    private fun transferToFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}