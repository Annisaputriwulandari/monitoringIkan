package com.bagicode.smartfarm

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bagicode.smartfarm.buttomnavigation.fragments.HomeFragment
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.utils.ColorTemplate
import com.google.firebase.database.*

class KadarPhActivity : AppCompatActivity() {

    private lateinit var database : DatabaseReference
    private var TAG: String = "KadarPhAirActivity"

    private var dataList = ArrayList<tabel>()
    private var txt = ArrayList<TextView>(3)

    lateinit var linelist:ArrayList<Entry>
    lateinit var lineDataSet: LineDataSet
    lateinit var lineData: LineData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kadar_ph)

        val btnBackPh : ImageView = findViewById(R.id.btn_back_ph)!!

        btnBackPh.setOnClickListener {
            val intent = Intent (this, HomeFragment::class.java)
            startActivity(intent)
        }

        val waktuTextSatu : TextView = findViewById(R.id.ph1)
        val phTextSatu : TextView = findViewById(R.id.ph2)
        val keteranganTextSatu : TextView = findViewById(R.id.ph3)

        val waktuTextDua : TextView = findViewById(R.id.ph4)
        val phTextDua : TextView = findViewById(R.id.ph5)
        val keteranganTextDua : TextView = findViewById(R.id.ph6)

        val waktuTextTiga : TextView = findViewById(R.id.ph7)
        val phTextTiga : TextView = findViewById(R.id.ph8)
        val keteranganTextTiga : TextView = findViewById(R.id.ph9)

        val waktuTextEmpat : TextView = findViewById(R.id.ph10)
        val phTextEmpat : TextView = findViewById(R.id.ph11)
        val keteranganTextEmpat : TextView = findViewById(R.id.ph12)

        val waktuTextLima : TextView = findViewById(R.id.ph13)
        val phTextLima : TextView = findViewById(R.id.ph14)
        val keteranganTextLima : TextView = findViewById(R.id.ph15)

        database = FirebaseDatabase.getInstance().getReference("Data")
        database.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot){

//                val waktuDataSatu = snapshot.child("ph/1/waktu").value
//                waktuTextSatu.text = waktuDataSatu.toString()
                val phDataSatu = snapshot.child("ph/1/ph").value
                phTextSatu.text= phDataSatu.toString()
                val keteranganDataSatu = snapshot.child("ph/1/keterangan").value
                keteranganTextSatu.text= keteranganDataSatu.toString()

//                  val waktuDataDua = snapshot.child("waktu/dua").value
//                  waktuTextDua.text = waktuDataDua.toString()
                val phDataDua = snapshot.child("ph/2/ph").value
                phTextDua.text= phDataDua.toString()
                val keteranganDataDua = snapshot.child("ph/2/keterangan").value
                keteranganTextDua.text= keteranganDataDua.toString()

//                  val waktuDataTiga = snapshot.child("waktu/tiga").value
//                  waktuTextTiga.text = waktuDataTiga.toString()
                val phDataTiga = snapshot.child("ph/3/ph").value
                phTextTiga.text= phDataTiga.toString()
                val keteranganDataTiga = snapshot.child("ph/3/keterangan").value
                keteranganTextTiga.text= keteranganDataTiga.toString()

//                  val waktuDataEmpat = snapshot.child("waktu/empat").value
//                  waktuTextEmpat.text = waktuDataEmpat.toString()
                val phDataEmpat = snapshot.child("ph/4/ph").value
                phTextEmpat.text= phDataEmpat.toString()
                val keteranganDataEmpat = snapshot.child("ph/4/keterangan").value
                keteranganTextEmpat.text= keteranganDataEmpat.toString()

//                  val waktuDataLima = snapshot.child("waktu/lima").value
//                  waktuTextLima.text = waktuDataLima.toString()
                val phDataLima = snapshot.child("ph/5/ph").value
                phTextLima.text= phDataLima.toString()
                val keteranganDataLima = snapshot.child("ph/5/keterangan").value
                keteranganTextLima. text= keteranganDataLima.toString()

            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        val line_chart: LineChart = findViewById(R.id.line_chart)

        linelist= ArrayList()
        linelist.add(Entry(10f, 100f))
        linelist.add(Entry(20f, 300f))
        linelist.add(Entry(30f, 200f))
        linelist.add(Entry(40f, 500f))
        linelist.add(Entry(50f, 600f))
        linelist.add(Entry(50f, 900f))

        lineDataSet= LineDataSet(linelist, "Count")
        lineData= LineData(lineDataSet)
        line_chart.data=lineData
        lineDataSet.color = Color.BLACK
        lineDataSet.setColors(*ColorTemplate.JOYFUL_COLORS)
        lineDataSet.valueTextColor= Color.BLUE
        lineDataSet.valueTextSize= 20f
        lineDataSet.setDrawFilled(true)
    }
    private fun getData(){
    }
}