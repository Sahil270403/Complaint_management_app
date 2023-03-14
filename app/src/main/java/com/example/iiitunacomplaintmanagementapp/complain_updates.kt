package com.example.iiitunacomplaintmanagementapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.iiitunacomplaintmanagementapp.databinding.ActivityComplainUpdatesBinding
import com.example.iiitunacomplaintmanagementapp.databinding.ActivityRegisterCompliantsBinding

class complain_updates : AppCompatActivity() {

    private lateinit var binding: ActivityComplainUpdatesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComplainUpdatesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ComntUpdatehostelbtn.setOnClickListener {
            startActivity(Intent(this, updates_hostel::class.java))
        }
        binding.button9.setOnClickListener {
            startActivity(Intent(this,updates_mess::class.java))
        }
    }

}