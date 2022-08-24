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
        //membuat id untuk RelativeLayout. id didapat dari layout xml
        val btnSuhu : RelativeLayout = requireView().findViewById(R.id.btn_suhu)
        //melakukan perpindahan ke halaman utama ketika di klik
        btnSuhu.setOnClickListener {
            val intent = Intent (requireContext(), SuhuAirActivity::class.java)
            startActivity(intent)
        }
        //membuat id untuk RelativeLayout. id didapat dari layout xml
        val btnPh : RelativeLayout = view?.findViewById(R.id.btn_ph)!!
        //melakukan perpindahan ke halaman utama ketika di klik
        btnPh.setOnClickListener {
            val intent = Intent (requireContext(), KadarPhActivity::class.java)
            startActivity(intent)
        }
        //membuat id untuk RelativeLayout. id didapat dari layout xml
        val btnKeruh : RelativeLayout = view?.findViewById(R.id.btn_keruh)!!
        //melakukan perpindahan ke halaman utama ketika di klik
        btnKeruh.setOnClickListener {
            val intent = Intent (requireContext(), KeruhActivity::class.java)
            startActivity(intent)
        }
        //membuat id untuk RelativeLayout. id didapat dari layout xml
        val btnJumlah : RelativeLayout = view?.findViewById(R.id.btn_jumlah)!!
        //melakukan perpindahan ke halaman utama ketika di klik
        btnJumlah.setOnClickListener {
            val intent = Intent (requireContext(), JumlahIkanActivity::class.java)
            startActivity(intent)
        }
    }

}