package com.example.iiitunacomplaintmanagementapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.iiitunacomplaintmanagementapp.databinding.ActivityRegisterCompliantsBinding

class register_compliants : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterCompliantsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterCompliantsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button10.setOnClickListener {
            startActivity(Intent(this, register_hostel::class.java))
            finish()
        }
        binding.button11.setOnClickListener {
            startActivity(Intent(this,register_mess::class.java))
            finish()
        }
    }

}