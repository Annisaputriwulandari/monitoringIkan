package com.bagicode.smartfarm

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.bagicode.smartfarm.buttomnavigation.fragments.HomeFragment
import com.google.firebase.database.*

class JumlahIkanActivity : AppCompatActivity() {
    //deklarasi khusus untuk database pada layout ini
    private lateinit var database : DatabaseReference
    private var TAG: String = "JumlahIkanActivity"

    @RequiresApi(Build.VERSION_CODES.O)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jumlah_ikan)
        //membuat id untuk imageView. id didapat dari layout xml
        val btnBackIkan : ImageView = findViewById(R.id.btn_back_ikan)!!
        //melakukan perpindahan/kembali ke halaman utama ketika di klik
        btnBackIkan.setOnClickListener {
            val intent = Intent (this, HomeActivity::class.java)
            startActivity(intent)
        }

        webViewSetup()
        //membuat kolom jumlah ikan menggunakan id yang berada pada layout xml.
        val jmlIkan : TextView = findViewById(R.id.jmlIkan)
        // link untuk menyambungkan ke firebase
        database = FirebaseDatabase.getInstance("https://monitoringikan-8373e-default-rtdb.firebaseio.com/").getReference("Data")
        database.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                //untuk mengambil data child dari firebase
                if(snapshot.exists()) {
                    val jmlIkanData = snapshot.child("all_fish/fish").value
                    jmlIkan.text = jmlIkanData.toString()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                //untuk mengetahui letak error
                Log.d(TAG, error.message)
            }
        })
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun webViewSetup(){
        //membuat tampilan webView
        val wb_webView : WebView = findViewById(R.id.wb_webView)
        wb_webView.webChromeClient = WebChromeClient()
        // untuk membuat tampilan mode desktop
        val webSetting = wb_webView.settings

        val newUA = "Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.0.4) Gecko/20100101 Firefox/4.0"
        webSetting.userAgentString = newUA
        webSetting.loadWithOverviewMode = true
        //menambahkan ip url untuk live stream video
        wb_webView.loadUrl("http://192.168.167.67:5000/")
    }
}