package com.bagicode.smartfarm.buttomnavigation.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import com.bagicode.smartfarm.AboutActivity
import com.bagicode.smartfarm.HelpActivity
import com.bagicode.smartfarm.R
import com.bagicode.smartfarm.SuhuAirActivity

class HelpFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_help, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //membuat id untuk RelativeLayout. id didapat dari layout xml
        val btnAbout : Button = requireView().findViewById(R.id.btn_about)
        //melakukan perpindahan ke halaman utama ketika di klik
        btnAbout.setOnClickListener {
            val intent = Intent(requireContext(), AboutActivity::class.java)
            startActivity(intent)
        }
        //membuat id untuk RelativeLayout. id didapat dari layout xml
        val btnHelp : Button = requireView().findViewById(R.id.btn_help)
        //melakukan perpindahan ke halaman utama ketika di klik
        btnHelp.setOnClickListener {
            val intent = Intent (requireContext(), HelpActivity::class.java)
            startActivity(intent)
        }
    }

}