package com.bagicode.smartfarm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bagicode.smartfarm.buttomnavigation.fragments.HelpFragment

class HelpActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)
        //membuat id untuk imageView. id didapat dari layout xml
        val btnBackHelp : ImageView = findViewById(R.id.btn_back_help)!!
        //melakukan perpindahan/kembali ke halaman utama ketika di klik
        btnBackHelp.setOnClickListener {
            val intent = Intent (this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}