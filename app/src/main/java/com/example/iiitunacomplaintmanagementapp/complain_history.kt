package com.example.iiitunacomplaintmanagementapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.iiitunacomplaintmanagementapp.databinding.ActivityComplainHistoryBinding

class complain_history : AppCompatActivity() {

    private lateinit var binding: ActivityComplainHistoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComplainHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button6.setOnClickListener {
            startActivity(Intent(this, history_hostel::class.java))
        }
        binding.button7.setOnClickListener {
            startActivity(Intent(this,history_mess::class.java))
        }
    }

}