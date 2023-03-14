package com.example.iiitunacomplaintmanagementapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.iiitunacomplaintmanagementapp.models.Complaint_Hostel
import com.google.firebase.firestore.*

class updates_hostel : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var userArrayList: ArrayList<Complaint_Hostel>
    private lateinit var Hostel_Adapter : Hostel_Adapter
    private lateinit var db : FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_updates_hostel)


        recyclerView = findViewById(R.id.RecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        userArrayList = arrayListOf()

        Hostel_Adapter = Hostel_Adapter(userArrayList)

        recyclerView.adapter = Hostel_Adapter

        EventChangeListener()
    }

    private fun EventChangeListener() {

        db = FirebaseFirestore.getInstance()
        db.collection("Updates_Hostel").addSnapshotListener(object :
            EventListener<QuerySnapshot> {
            override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException?) {
                if (error != null){

                    Log.e("Firestore Error", error.message.toString())
                    return
                }

                for (dc : DocumentChange in value?.documentChanges!!){

                    if(dc.type == DocumentChange.Type.ADDED){

                        userArrayList.add(dc.document.toObject(Complaint_Hostel::class.java))
                        userArrayList.sortByDescending {
                            it.createdAt
                        }
                    }
                }

                Hostel_Adapter.notifyDataSetChanged()

            }

        })

    }
}