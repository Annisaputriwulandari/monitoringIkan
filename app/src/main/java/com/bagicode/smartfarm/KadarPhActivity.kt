package com.bagicode.smartfarm

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

class KadarPhActivity : AppCompatActivity() {
    //deklarasi khusus untuk database pada layout ini
    private lateinit var database : DatabaseReference
    private var TAG: String = "KadarPhAirActivity"
    //deklarasi untuk membuat diagram
    private var dataList = ArrayList<tabel>()
    private var txt = ArrayList<TextView>(3)
    private lateinit var lineChart: LineChart

    lateinit var linelist:ArrayList<Entry>
    lateinit var lineDataSet: LineDataSet
    lateinit var lineData: LineData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kadar_ph)
        //membuat id untuk imageView. id didapat dari layout xml
        val btnBackPh : ImageView = findViewById(R.id.btn_back_ph)!!
        //melakukan perpindahan/kembali ke halaman utama ketika di klik
        btnBackPh.setOnClickListener {
            val intent = Intent (this, HomeActivity::class.java)
            startActivity(intent)
        }
        // membuat id untuk textview/ tabel. id didapat dari layout xml.
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

        val waktuTextEnam : TextView = findViewById(R.id.ph16)
        val phTextEnam : TextView = findViewById(R.id.ph17)
        val keteranganTextEnam : TextView = findViewById(R.id.ph18)

        // link untuk menyambungkan ke firebase
        database = FirebaseDatabase.getInstance("https://monitoringikan-8373e-default-rtdb.firebaseio.com/").getReference("Data")
        database.addValueEventListener(object : ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot){
                //untuk mengambil data child untuk tabel baris 1 kolom 1 dari firebase
                val waktuDataSatu = snapshot.child("all_ph/1/waktu").value as Long
                //mengubah angka dari raspberry pi menjadi bentuk hari dan tanggal
                val convertmillisSatu = getDateFromMilliseconds(waktuDataSatu, "hh")
                waktuTextSatu.text = getDateFromMilliseconds(waktuDataSatu, "dd/MM/yyyy hh:mm")
                val phDataSatu = snapshot.child("all_ph/1/PH").value as Double
                phTextSatu.text= phDataSatu.toString()
                val keteranganDataSatu = snapshot.child("all_ph/1/keterangan").value
                keteranganTextSatu.text= keteranganDataSatu.toString()

                val waktuDataDua = snapshot.child("all_ph/2/waktu").value as Long
                val convertmillisDua = getDateFromMilliseconds(waktuDataDua, "hh")
                waktuTextDua.text = getDateFromMilliseconds(waktuDataDua, "dd/MM/yyyy hh:mm")
                val phDataDua = snapshot.child("all_ph/2/PH").value as Double
                phTextDua.text= phDataDua.toString()
                val keteranganDataDua = snapshot.child("all_ph/2/keterangan").value
                keteranganTextDua.text= keteranganDataDua.toString()

                val waktuDataTiga = snapshot.child("all_ph/3/waktu").value as Long
                val convertmillisTiga = getDateFromMilliseconds(waktuDataTiga, "hh")
                waktuTextTiga.text = getDateFromMilliseconds(waktuDataTiga, "dd/MM/yyyy hh:mm")
                val phDataTiga = snapshot.child("all_ph/3/PH").value as Double
                phTextTiga.text= phDataTiga.toString()
                val keteranganDataTiga = snapshot.child("all_ph/3/keterangan").value
                keteranganTextTiga.text= keteranganDataTiga.toString()

                val waktuDataEmpat = snapshot.child("all_ph/4/waktu").value as Long
                val convertmillisEmpat = getDateFromMilliseconds(waktuDataEmpat, "hh")
                waktuTextEmpat.text = getDateFromMilliseconds(waktuDataEmpat, "dd/MM/yyyy hh:mm")
                val phDataEmpat = snapshot.child("all_ph/4/PH").value as Double
                phTextEmpat.text= phDataEmpat.toString()
                val keteranganDataEmpat = snapshot.child("all_ph/4/keterangan").value
                keteranganTextEmpat.text= keteranganDataEmpat.toString()

                val waktuDataLima = snapshot.child("all_ph/5/waktu").value as Long
                val convertmillisLima = getDateFromMilliseconds(waktuDataLima, "hh")
                waktuTextLima.text = getDateFromMilliseconds(waktuDataLima, "dd/MM/yyyy hh:mm")
                val phDataLima = snapshot.child("all_ph/5/PH").value as Double
                phTextLima.text= phDataLima.toString()
                val keteranganDataLima = snapshot.child("all_ph/5/keterangan").value
                keteranganTextLima.text= keteranganDataLima.toString()

                val waktuDataEnam = snapshot.child("all_ph/6/waktu").value as Long
                val convertmillisEnam = getDateFromMilliseconds(waktuDataEnam, "hh")
                waktuTextEnam.text = getDateFromMilliseconds(waktuDataEnam, "dd/MM/yyyy hh:mm")
                val phDataEnam = snapshot.child("all_ph/6/PH").value as Double
                phTextEnam.text= phDataEnam.toString()
                val keteranganDataEnam = snapshot.child("all_ph/6/keterangan").value
                keteranganTextEnam.text= keteranganDataEnam.toString()

                //untuk memasukkan data ke diagram garis
                linelist= ArrayList()
                linelist.add(Entry(convertmillisSatu.toFloat(), phDataSatu.toFloat()))
                linelist.add(Entry(convertmillisDua.toFloat(), phDataDua.toFloat()))
                linelist.add(Entry(convertmillisTiga.toFloat(), phDataTiga.toFloat()))
                linelist.add(Entry(convertmillisEmpat.toFloat(), phDataEmpat.toFloat()))
                linelist.add(Entry(convertmillisLima.toFloat(), phDataLima.toFloat()))
                linelist.add(Entry(convertmillisEnam.toFloat(), phDataEnam.toFloat()))

                chartData(linelist)

            }
            override fun onCancelled(error: DatabaseError) {
                Log.d(TAG, error.message)
            }
        })
    }

    private fun chartData(linelist : ArrayList<Entry>){
        val line_chart: LineChart = findViewById(R.id.line_chart)
        //membuat diagram garis
        lineDataSet= LineDataSet(linelist, "Count")
        lineData= LineData(lineDataSet)
        line_chart.data=lineData
        lineDataSet.color = Color.BLACK
//        lineDataSet.setColors(*ColorTemplate.JOYFUL_COLORS)
        lineDataSet.valueTextColor= Color.BLUE
        lineDataSet.valueTextSize= 20f
        lineDataSet.setDrawFilled(true)
    }
    //mengkonversi milisecond dari raspberry pi ke waktu
    private fun getDateFromMilliseconds(millis: Long, dateFormat: String): String {
        val formatter = SimpleDateFormat(dateFormat, Locale.getDefault())
        val calendar = Calendar.getInstance()

        calendar.timeInMillis = millis
        return formatter.format(calendar.time)
    }

    private fun getData(){
    }
}