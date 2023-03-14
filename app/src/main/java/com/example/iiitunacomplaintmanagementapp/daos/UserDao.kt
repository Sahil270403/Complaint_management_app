package com.example.iiitunacomplaintmanagementapp.daos

import com.example.iiitunacomplaintmanagementapp.models.User
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UserDao {
    private val db  = FirebaseFirestore.getInstance()
    private val usersCollection = db.collection("users")

    fun addUser(user:User?) {
        user?.let {
            GlobalScope.launch {
                usersCollection.document(user.email).set(it)
            }
        }
    }
}

