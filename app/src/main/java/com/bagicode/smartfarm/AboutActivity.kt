package com.bagicode.smartfarm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bagicode.smartfarm.buttomnavigation.fragments.HelpFragment
import com.bagicode.smartfarm.buttomnavigation.fragments.HomeFragment

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        //membuat id untuk imageView. id didapat dari layout xml
        val btnBackAbout : ImageView = findViewById(R.id.btn_back_about)!!
        //melakukan perpindahan/kembali ke halaman utama ketika di klik
        btnBackAbout.setOnClickListener {
            val intent = Intent (this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}