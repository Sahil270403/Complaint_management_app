package com.example.iiitunacomplaintmanagementapp

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.iiitunacomplaintmanagementapp.daos.HostelDao


class register_hostel : AppCompatActivity() {

    private lateinit var hostelDao:HostelDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_hostel)

        hostelDao = HostelDao()

    }

    fun hostelSubBtn(view: View) {
        val editText = findViewById<EditText>(R.id.compRegHostel)
        val input = editText.text.toString().trim()

        val editText1 = findViewById<EditText>(R.id.nameMessReg)
        val nameRegHostel = editText1.text.toString().trim()

        val editText2 = findViewById<EditText>(R.id.hostelReg)
        val hostelReg = editText2.text.toString().trim()

        hostelDao.user = nameRegHostel
        hostelDao.hostel = hostelReg

        if(input.isNotEmpty()){
            hostelDao.addHostel(input)
            Toast.makeText(this, "Complaint Registered", Toast.LENGTH_SHORT).show()
            finish()
        }

    }
}