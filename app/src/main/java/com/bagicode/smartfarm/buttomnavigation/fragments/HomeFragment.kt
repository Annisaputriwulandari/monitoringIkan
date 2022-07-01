package com.bagicode.smartfarm.buttomnavigation.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import com.bagicode.smartfarm.*

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val btnSuhu : RelativeLayout = requireView().findViewById(R.id.btn_suhu)

        btnSuhu.setOnClickListener {
            val intent = Intent (requireContext(), SuhuAirActivity::class.java)
            startActivity(intent)
        }
        val btnPh : RelativeLayout = view?.findViewById(R.id.btn_ph)!!

        btnPh.setOnClickListener {
            val intent = Intent (requireContext(), KadarPhActivity::class.java)
            startActivity(intent)
        }
        val btnKeruh : RelativeLayout = view?.findViewById(R.id.btn_keruh)!!

        btnKeruh.setOnClickListener {
            val intent = Intent (requireContext(), KeruhActivity::class.java)
            startActivity(intent)
        }
        val btnJumlah : RelativeLayout = view?.findViewById(R.id.btn_jumlah)!!

        btnJumlah.setOnClickListener {
            val intent = Intent (requireContext(), JumlahIkanActivity::class.java)
            startActivity(intent)
        }
    }

}