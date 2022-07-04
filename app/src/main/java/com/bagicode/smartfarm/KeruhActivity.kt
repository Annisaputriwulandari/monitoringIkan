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
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class KeruhActivity : AppCompatActivity() {

    private lateinit var database : DatabaseReference
    private var TAG: String = "KeruhActivity"

    private var dataList = ArrayList<tabel>()
    private var txt = ArrayList<TextView>(3)

    lateinit var linelist:ArrayList<Entry>
    lateinit var lineDataSet: LineDataSet
    lateinit var lineData: LineData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keruh)

        val btnBackKeruh : ImageView = findViewById(R.id.btn_back_keruh)!!

        btnBackKeruh.setOnClickListener {
            val intent = Intent (this, HomeFragment::class.java)
            startActivity(intent)
        }

        val waktuTextSatu : TextView = findViewById(R.id.keruh1)
        val keruhTextSatu : TextView = findViewById(R.id.keruh2)
        val keteranganTextSatu : TextView = findViewById(R.id.keruh3)

        val waktuTextDua : TextView = findViewById(R.id.keruh4)
        val keruhTextDua : TextView = findViewById(R.id.keruh5)
        val keteranganTextDua : TextView = findViewById(R.id.keruh6)

        val waktuTextTiga : TextView = findViewById(R.id.keruh7)
        val keruhTextTiga : TextView = findViewById(R.id.keruh8)
        val keteranganTextTiga : TextView = findViewById(R.id.keruh9)

        val waktuTextEmpat : TextView = findViewById(R.id.keruh10)
        val keruhTextEmpat : TextView = findViewById(R.id.keruh11)
        val keteranganTextEmpat : TextView = findViewById(R.id.keruh12)

        val waktuTextLima : TextView = findViewById(R.id.keruh13)
        val keruhTextLima : TextView = findViewById(R.id.keruh14)
        val keteranganTextLima : TextView = findViewById(R.id.keruh15)

        database = FirebaseDatabase.getInstance().getReference("Data")
        database.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot){

                val waktuDataSatu = snapshot.child("kekeruhan/1/waktu").value
                waktuTextSatu.text = getDateFromMilliseconds(1656905520192L, "dd/MM/yyyy hh:mm")
                val keruhDataSatu = snapshot.child("kekeruhan/1/kekeruhan").value
                keruhTextSatu.text= keruhDataSatu.toString()
                val keteranganDataSatu = snapshot.child("kekeruhan/1/keterangan").value
                keteranganTextSatu.text= keteranganDataSatu.toString()

                val waktuDataDua = snapshot.child("kekeruhan/2/waktu").value
                waktuTextDua.text = getDateFromMilliseconds(1656905580639L, "dd/MM/yyyy hh:mm")
                val keruhDataDua = snapshot.child("kekeruhan/2/kekeruhan").value
                keruhTextDua.text= keruhDataDua.toString()
                val keteranganDataDua = snapshot.child("kekeruhan/2/keterangan").value
                keteranganTextDua.text= keteranganDataDua.toString()

                val waktuDataTiga = snapshot.child("kekeruhan/3/waktu").value
                waktuTextTiga.text = getDateFromMilliseconds(1656646500817L, "dd/MM/yyyy hh:mm")
                val keruhDataTiga = snapshot.child("kekeruhan/3/kekeruhan").value
                keruhTextTiga.text= keruhDataTiga.toString()
                val keteranganDataTiga = snapshot.child("kekeruhan/3/keterangan").value
                keteranganTextTiga.text= keteranganDataTiga.toString()

                val waktuDataEmpat = snapshot.child("kekeruhan/4/waktu").value
                waktuTextEmpat.text = getDateFromMilliseconds(1656905700192L, "dd/MM/yyyy hh:mm")
                val keruhDataEmpat = snapshot.child("kekeruhan/4/kekeruhan").value
                keruhTextEmpat.text= keruhDataEmpat.toString()
                val keteranganDataEmpat = snapshot.child("kekeruhan/4/keterangan").value
                keteranganTextEmpat.text= keteranganDataEmpat.toString()

                val waktuDataLima = snapshot.child("kekeruhan/5/waktu").value
                waktuTextLima.text = getDateFromMilliseconds(1656905760576L, "dd/MM/yyyy hh:mm")
                val keruhDataLima = snapshot.child("kekeruhan/5/kekeruhan").value
                keruhTextLima.text= keruhDataLima.toString()
                val keteranganDataLima = snapshot.child("kekeruhan/5/keterangan").value
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

    private fun getDateFromMilliseconds(millis: Long, dateFormat: String): String {
        val formatter = SimpleDateFormat(dateFormat, Locale.getDefault())
        val calendar = Calendar.getInstance()

        calendar.timeInMillis = millis
        return formatter.format(calendar.time)
    }

    private fun getData(){
    }
}