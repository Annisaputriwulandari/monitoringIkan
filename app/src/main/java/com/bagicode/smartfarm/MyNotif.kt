package com.bagicode.smartfarm

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.google.firebase.database.*

class MyNotif : Service() {

    private val TAG: String = "Service"
    //deklarasi khusus untuk database pada layout ini
    private lateinit var database: DatabaseReference

    override fun onCreate() {
        super.onCreate()
        //mengambil firebase "data"
        database = FirebaseDatabase.getInstance().getReference("Data")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val dataListener = object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    //mengambil data child keterangan untuk notifikasi
                    val suhuDataSatu = getData(snapshot,"all_suhu", 1)
                    val suhuDataDua = getData(snapshot,"all_suhu", 2)
                    val suhuDataTiga = getData(snapshot,"all_suhu", 3)
                    val suhuDataEmpat = getData(snapshot,"all_suhu", 4)
                    val suhuDataLima = getData(snapshot,"all_suhu", 5)
                    val suhuDataEnam = getData(snapshot,"all_suhu", 6)

                    val phDataSatu = getData(snapshot, "all_ph", 1)
                    val phDataDua = getData(snapshot,"all_ph", 2)
                    val phDataTiga = getData(snapshot,"all_ph", 3)
                    val phDataEmpat = getData(snapshot,"all_ph", 4)
                    val phDataLima = getData(snapshot,"all_ph", 5)
                    val phDataEnam = getData(snapshot,"all_ph", 6)

                    val keruhDataSatu = getData(snapshot, "all_turbidity",1)
                    val keruhDataDua = getData(snapshot, "all_turbidity",2)
                    val keruhDataTiga = getData(snapshot, "all_turbidity",3)
                    val keruhDataEmpat = getData(snapshot, "all_turbidity",4)
                    val keruhDataLima = getData(snapshot, "all_turbidity",5)
                    val keruhDataEnam = getData(snapshot, "all_turbidity",6)

//                    showLog(suhuDataSatu.toString())
//                    showLog(suhuDataDua.toString())
//                    showLog(phDataSatu.toString())
                    //mengambil data keterangan jika suhu tidak sesuai
                    if(suhuDataSatu.toString() == "Tidak Sesuai" || suhuDataDua.toString() == "Tidak Sesuai" ||
                       suhuDataTiga.toString() == "Tidak Sesuai" || suhuDataEmpat.toString() == "Tidak Sesuai" ||
                       suhuDataLima.toString() == "Tidak Sesuai" || suhuDataEnam.toString() == "Tidak Sesuai"){
                        //membuat isi perintah notifikasi
                        NotificationHelper(applicationContext).createNotification(
                            "Suhu Air Tidak Sesuai",
                            "Harap Ganti Air ke Suhu Normal yaitu 22°C-30°C"
                        )
                    }
                    //mengambil data keterangan jika ph tidak sesuai
                    if(phDataSatu.toString() == "Tidak Sesuai" || phDataDua.toString() == "Tidak Sesuai" ||
                        phDataTiga.toString() == "Tidak Sesuai" || phDataEmpat.toString() == "Tidak Sesuai" ||
                        phDataLima.toString() == "Tidak Sesuai" || phDataEnam.toString() == "Tidak Sesuai"){
                        //membuat isi perintah notifikasi
                        NotificationHelper(applicationContext).createNotification(
                            "Kadar Ph Air Tidak Sesuai",
                            "Harap Ganti Air ke Ph Normal yaitu 5-8"
                        )
                    }
                    //mengambil data keterangan jika tingkat kekeruhan air keruh/tidak sesuai
                    if(keruhDataSatu.toString() == "Air Keruh" || keruhDataDua.toString() == "Air Keruh" ||
                        keruhDataTiga.toString() == "Air Keruh" || keruhDataEmpat.toString() == "Air Keruh" ||
                        keruhDataLima.toString() == "Air Keruh" || keruhDataEnam.toString() == "Air Keruh"){
                        //membuat isi perintah notifikasi
                        NotificationHelper(applicationContext).createNotification(
                            "Air Keruh",
                            "Harap Ganti Air atau Kuras Kolam"
                        )
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d(TAG, error.toString())
            }
        }

        database.addValueEventListener(dataListener)

        showLog("Service Running")

        return START_STICKY
    }

    private fun getData(snapshot: DataSnapshot, param: String, index: Int,): Any? {
        return snapshot.child("$param/$index/keterangan").value
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    fun showLog (message: String){
        Log.d(TAG, message)
    }
}