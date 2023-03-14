package com.example.iiitunacomplaintmanagementapp

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.iiitunacomplaintmanagementapp.daos.MessDao

class register_mess : AppCompatActivity() {

    private lateinit var messDao: MessDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_mess)
        messDao = MessDao()
    }

    fun MessSubBtn(view: View) {
        val editText = findViewById<EditText>(R.id.messComplaint)
        val input = editText.text.toString().trim()

        val editText1 = findViewById<EditText>(R.id.nameMessReg)
        val nameRegHostel = editText1.text.toString().trim()

        val editText2 = findViewById<EditText>(R.id.nameMess)
        val messReg = editText2.text.toString().trim()

        messDao.user = nameRegHostel
        messDao.mess = messReg

        if(input.isNotEmpty()){
            messDao.addMess(input)
            Toast.makeText(this, "Complaint Registered", Toast.LENGTH_SHORT).show()
            finish()
        }

    }
}