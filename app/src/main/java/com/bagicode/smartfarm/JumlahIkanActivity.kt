package com.bagicode.smartfarm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bagicode.smartfarm.buttomnavigation.fragments.HomeFragment

class JumlahIkanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jumlah_ikan)

        val btnBackIkan : ImageView = findViewById(R.id.btn_back_ikan)!!

        btnBackIkan.setOnClickListener {
            val intent = Intent (this, HomeFragment::class.java)
            startActivity(intent)
        }
    }
}