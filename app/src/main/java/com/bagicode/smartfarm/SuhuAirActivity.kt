package com.bagicode.smartfarm

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatViewInflater
import androidx.core.content.ContentProviderCompat.requireContext
import com.bagicode.smartfarm.buttomnavigation.fragments.HomeFragment
import com.github.mikephil.charting.charts.Chart
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

    private lateinit var database : DatabaseReference
    private var TAG: String = "SuhuAirActivity"

    private var dataList = ArrayList<tabel>()
    private var txt = ArrayList<TextView>(3)
    private lateinit var lineChart: LineChart

    lateinit var linelist: ArrayList<Entry>
    lateinit var lineDataSet: LineDataSet
    lateinit var lineData: LineData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suhu_air)

        val btnBackSuhu : ImageView = findViewById(R.id.btn_back_suhu)!!

        btnBackSuhu.setOnClickListener {
            val intent = Intent (this, HomeFragment::class.java)
            startActivity(intent)
        }

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

        database = FirebaseDatabase.getInstance().getReference("Data")
        database.addValueEventListener(object : ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {

//                if (snapshot.exists()){
//                    for (i in 0 until 3){
//                        var suhu = snapshot.child("suhu/1/")
//                        var tabel = suhu.getValue(tabel::class.java)
//                        Log.d(TAG, tabel?.waktu.toString())
//                        var id = resources.getIdentifier("kolom"+(i+1), "id", packageName)
//                        txt.add(findViewById<View>(id) as TextView)
//                        txt[i].setText(suhu.value.toString())
//                    }

//                    Log.d(TAG, snapshot.child("suhu").childrenCount.toString())
//                    Log.d(TAG, snapshot.child("suhu/1").toString())

//                        var tabel = getdataSnapshot.getValue(tabel::class.java)
//                        Log.d(TAG, tabel.tiga.toString())

//                        var barisSatu : TableRow = findViewById(R.id.baris_satu)
//                        Log.d(TAG, tabel?.satu.toString())
//                        var text : Int = barisSatu.id
//
//
//                        for (i in 0 until 3){
//                            var id = resources.getIdentifier("kolom"+(i+1), "id", packageName)
//                            txt.add(findViewById<View>(id) as TextView)
//                            txt[i].setText(tabel?.1)
//                        }

//                    val waktuDataSatu = snapshot.child("suhu/1/waktu").value
//                    waktuTextSatu.text = getDateFromMilliseconds(1656646800640L, "dd/MM/yyyy hh:mm")

                if(snapshot.exists()) {
                    val suhuDataSatu = snapshot.child("suhu/1/suhu").value
                    suhuTextSatu.text= suhuDataSatu.toString()
                    val keteranganDataSatu = snapshot.child("suhu/1/keterangan").value
                    keteranganTextSatu.text= keteranganDataSatu.toString()

//                    val waktuDataDua = snapshot.child("waktu/dua").value
//                    waktuTextDua.text = getDateFromMilliseconds(1656646440062L, "dd/MM/yyyy hh:mm")
                    val suhuDataDua = snapshot.child("suhu/2/suhu").value
                    suhuTextDua.text= suhuDataDua.toString()
                    val keteranganDataDua = snapshot.child("suhu/2/keterangan").value
                    keteranganTextDua.text= keteranganDataDua.toString()

//                    val waktuDataTiga = snapshot.child("waktu/tiga").value
//                    waktuTextTiga.text = getDateFromMilliseconds(1656646500574L, "dd/MM/yyyy hh:mm")
                    val suhuDataTiga = snapshot.child("suhu/3/suhu").value
                    suhuTextTiga.text= suhuDataTiga.toString()
                    val keteranganDataTiga = snapshot.child("suhu/3/keterangan").value
                    keteranganTextTiga.text= keteranganDataTiga.toString()

//                    val waktuDataEmpat = snapshot.child("waktu/empat").value
//                    waktuTextEmpat.text = getDateFromMilliseconds(1656644700606L, "dd/MM/yyyy hh:mm")
                    val suhuDataEmpat = snapshot.child("suhu/4/suhu").value
                    suhuTextEmpat.text= suhuDataEmpat.toString()
                    val keteranganDataEmpat = snapshot.child("suhu/4/keterangan").value
                    keteranganTextEmpat.text= keteranganDataEmpat.toString()

//                    val waktuDataLima = snapshot.child("waktu/lima").value
//                    waktuTextLima.text = getDateFromMilliseconds(1656644340542L, "dd/MM/yyyy hh:mm")
                    val suhuDataLima = snapshot.child("suhu/5/suhu").value
                    suhuTextLima.text= suhuDataLima.toString()
                    val keteranganDataLima = snapshot.child("suhu/5/keterangan").value
                    keteranganTextLima. text= keteranganDataLima.toString()
                }

            }

            override fun onCancelled(error: DatabaseError) {
                Log.d(TAG, error.message)
            }
        })


        database.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                linelist= ArrayList()
                linelist.add(Entry(10f, 300f))
                linelist.add(Entry(20f, 400f))
                linelist.add(Entry(30f, 500f))
                linelist.add(Entry(40f, 600f))
                linelist.add(Entry(50f, 700f))

                chartData(linelist)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d(TAG, error.message)
            }

        })
    }

    private fun chartData(linelist: ArrayList<Entry>) {
        lineChart = findViewById(R.id.line_chart)

        lineDataSet= LineDataSet(linelist, "Count")
        lineData= LineData(lineDataSet)
        lineChart.data=lineData
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
}
