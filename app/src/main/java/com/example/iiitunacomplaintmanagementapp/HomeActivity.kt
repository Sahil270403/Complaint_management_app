package com.example.iiitunacomplaintmanagementapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.iiitunacomplaintmanagementapp.daos.UserDao
import com.example.iiitunacomplaintmanagementapp.databinding.ActivityHomeBinding
import com.example.iiitunacomplaintmanagementapp.models.User
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        val email = intent.getStringExtra("email")
        val dispalyName = intent.getStringExtra("name")
        val image = intent.getStringExtra("imager")
            val user = User(email.toString(), dispalyName.toString(), image.toString())
        val userDao = UserDao()
        userDao.addUser(user)


        binding.gsignoutButton.setOnClickListener {
            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()

            val googleSignInClient = GoogleSignIn.getClient(this , gso)
            googleSignInClient.signOut()

            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        binding.complaintbutn.setOnClickListener {
            startActivity(Intent(this,complain_history::class.java))
        }

        binding.comupdatetbtn.setOnClickListener {
            startActivity(Intent(this, complain_updates::class.java))
        }

        binding.regiscompbtn.setOnClickListener {
            startActivity(Intent(this, register_compliants::class.java))
        }

        binding.helpbtn.setOnClickListener {
            startActivity(Intent(this, help::class.java))
        }

        binding.aboutbtn.setOnClickListener {
            startActivity(Intent(this, iiituna::class.java))
        }
    }

}