package com.bagicode.smartfarm

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.utils.ColorTemplate
import com.google.firebase.database.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class SuhuAirActivity : AppCompatActivity() {
    //deklarasi khusus untuk database pada layout ini
    private lateinit var database : DatabaseReference
    private var TAG: String = "SuhuAirActivity"
    //deklarasi untuk membuat diagram
    private var dataList = ArrayList<tabel>()
    private var txt = ArrayList<TextView>(3)
    private lateinit var lineChart: LineChart

    lateinit var linelist: ArrayList<Entry>
    lateinit var lineDataSet: LineDataSet
    lateinit var lineData: LineData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suhu_air)
        //membuat id untuk imageView. id didapat dari layout xml
        val btnBackSuhu : ImageView = findViewById(R.id.btn_back_suhu)!!
        //melakukan perpindahan/kembali ke halaman utama ketika di klik
        btnBackSuhu.setOnClickListener {
            val intent = Intent (this, HomeActivity::class.java)
            startActivity(intent)
        }
        // membuat id untuk textview/ tabel. id didapat dari layout xml.
        val waktuTextSatu : TextView = findViewById(R.id.suhu1)
        val suhuTextSatu : TextView = findViewById(R.id.suhu2)
        val keteranganTextSatu : TextView = findViewById(R.id.suhu3)

        val waktuTextDua : TextView = findViewById(R.id.suhu4)
        val suhuTextDua : TextView = findViewById(R.id.suhu5)
        val keteranganTextDua : TextView = findViewById(R.id.suhu6)

        val waktuTextTiga : TextView = findViewById(R.id.suhu7)
        val suhuTextTiga : TextView = findViewById(R.id.suhu8)
        val keteranganTextTiga : TextView = findViewById(R.id.suhu9)

        val waktuTextEmpat : TextView = findViewById(R.id.suhu10)
        val suhuTextEmpat : TextView = findViewById(R.id.suhu11)
        val keteranganTextEmpat : TextView = findViewById(R.id.suhu12)

        val waktuTextLima : TextView = findViewById(R.id.suhu13)
        val suhuTextLima : TextView = findViewById(R.id.suhu14)
        val keteranganTextLima : TextView = findViewById(R.id.suhu15)

        val waktuTextEnam : TextView = findViewById(R.id.suhu16)
        val suhuTextEnam : TextView = findViewById(R.id.suhu17)
        val keteranganTextEnam : TextView = findViewById(R.id.suhu18)
        // link untuk menyambungkan ke firebase
        database = FirebaseDatabase.getInstance("https://monitoringikan-8373e-default-rtdb.firebaseio.com/").getReference("Data")
        database.addValueEventListener(object : ValueEventListener{

                override fun onDataChange(snapshot: DataSnapshot) {
                        //untuk mengambil data child untuk tabel baris 1 kolom 1 dari firebase
                        val waktuDataSatu = snapshot.child("all_suhu/1/waktu").value as Long
                        //mengubah angka dari raspberry pi menjadi bentuk hari dan tanggal
                        val convertmillisSatu = getDateFromMilliseconds(waktuDataSatu, "hh")
                        waktuTextSatu.text = getDateFromMilliseconds(waktuDataSatu, "dd/MM/yyyy hh:mm")
                        val suhuDataSatu = snapshot.child("all_suhu/1/temp").value as Double
                        suhuTextSatu.text= suhuDataSatu.toString()
                        val keteranganDataSatu = snapshot.child("all_suhu/1/keterangan").value
                        keteranganTextSatu.text= keteranganDataSatu.toString()

                    val waktuDataDua = snapshot.child("all_suhu/2/waktu").value as Long
                    val convertmillisDua = getDateFromMilliseconds(waktuDataDua, "hh")
                    waktuTextDua.text = getDateFromMilliseconds(waktuDataDua, "dd/MM/yyyy hh:mm")
                    val suhuDataDua = snapshot.child("all_suhu/2/temp").value as Double
                    suhuTextDua.text= suhuDataDua.toString()
                    val keteranganDataDua = snapshot.child("all_suhu/2/keterangan").value
                    keteranganTextDua.text= keteranganDataDua.toString()

                    val waktuDataTiga = snapshot.child("all_suhu/3/waktu").value as Long
                    val convertmillisTiga = getDateFromMilliseconds(waktuDataTiga, "hh")
                    waktuTextTiga.text = getDateFromMilliseconds(waktuDataTiga, "dd/MM/yyyy hh:mm")
                    val suhuDataTiga = snapshot.child("all_suhu/3/temp").value as Double
                    suhuTextTiga.text= suhuDataTiga.toString()
                    val keteranganDataTiga = snapshot.child("all_suhu/3/keterangan").value
                    keteranganTextTiga.text= keteranganDataTiga.toString()

                    val waktuDataEmpat = snapshot.child("all_suhu/4/waktu").value as Long
                    val convertmillisEmpat = getDateFromMilliseconds(waktuDataEmpat, "hh")
                    waktuTextEmpat.text = getDateFromMilliseconds(waktuDataEmpat, "dd/MM/yyyy hh:mm")
                    val suhuDataEmpat = snapshot.child("all_suhu/4/temp").value as Double
                    suhuTextEmpat.text= suhuDataEmpat.toString()
                    val keteranganDataEmpat = snapshot.child("all_suhu/4/keterangan").value
                    keteranganTextEmpat.text= keteranganDataEmpat.toString()

                    val waktuDataLima = snapshot.child("all_suhu/5/waktu").value as Long
                    val convertmillisLima = getDateFromMilliseconds(waktuDataLima, "hh")
                    waktuTextLima.text = getDateFromMilliseconds(waktuDataLima, "dd/MM/yyyy hh:mm")
                    val suhuDataLima = snapshot.child("all_suhu/5/temp").value as Double
                    suhuTextLima.text= suhuDataLima.toString()
                    val keteranganDataLima = snapshot.child("all_suhu/5/keterangan").value
                    keteranganTextLima. text= keteranganDataLima.toString()

                    val waktuDataEnam = snapshot.child("all_suhu/6/waktu").value as Long
                    val convertmillisEnam = getDateFromMilliseconds(waktuDataEnam, "hh")
                    waktuTextEnam.text = getDateFromMilliseconds(waktuDataEnam, "dd/MM/yyyy hh:mm")
                    val suhuDataEnam = snapshot.child("all_suhu/6/temp").value as Double
                    suhuTextEnam.text= suhuDataEnam.toString()
                    val keteranganDataEnam = snapshot.child("all_suhu/6/keterangan").value
                    keteranganTextEnam. text= keteranganDataEnam.toString()

                //untuk memasukkan data ke diagram garis
                linelist= ArrayList()
                linelist.add(Entry(convertmillisSatu.toFloat(), suhuDataSatu.toFloat()))
                linelist.add(Entry(convertmillisDua.toFloat(), suhuDataDua.toFloat()))
                linelist.add(Entry(convertmillisTiga.toFloat(), suhuDataTiga.toFloat()))
                linelist.add(Entry(convertmillisEmpat.toFloat(), suhuDataEmpat.toFloat()))
                linelist.add(Entry(convertmillisLima.toFloat(), suhuDataLima.toFloat()))
                linelist.add(Entry(convertmillisEnam.toFloat(), suhuDataEnam.toFloat()))

                chartData(linelist)

            }

            override fun onCancelled(error: DatabaseError) {
                Log.d(TAG, error.message)
            }
        })

    }

    private fun chartData(linelist: ArrayList<Entry>) {
        val line_chart: LineChart = findViewById(R.id.line_chart)
        //membuat diagram garis
        lineDataSet= LineDataSet(linelist, "Suhu")
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
