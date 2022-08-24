package com.bagicode.smartfarm.buttomnavigation.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bagicode.smartfarm.History
import com.bagicode.smartfarm.HistoryAdapter
import com.bagicode.smartfarm.R
import com.google.firebase.database.*

class HistoryFragment : Fragment() {

    private lateinit var database : DatabaseReference
    private lateinit var adapter: HistoryAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var historyArrayList: ArrayList<History>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        dataInitialize()
        val layoutManager = LinearLayoutManager(requireContext())

        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)

        historyArrayList = arrayListOf()
        getHistory()
//        Log.d("historyFragment", "hello")
    }

    private fun getHistory() {
        database = FirebaseDatabase.getInstance("https://monitoringikan-8373e-default-rtdb.firebaseio.com/").getReference("Data/history")
        database.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                for (getdataSnapshot in snapshot.children){
                    var riwayat = getdataSnapshot.getValue(History::class.java)
                    historyArrayList.add(riwayat!!)
                    historyArrayList.reverse()

                }
                val rv_history : RecyclerView? = view?.findViewById(R.id.recycler_view)
                rv_history?.adapter = HistoryAdapter(historyArrayList)

            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("historyFragment", error.message)

            }

        })
    }

}