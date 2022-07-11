package com.example.seanote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toTestViewScreen()
    }

    private fun toTestViewScreen() {
        val intent = Intent(this, TestViewActivity::class.java)
        startActivity(intent)
    }
}