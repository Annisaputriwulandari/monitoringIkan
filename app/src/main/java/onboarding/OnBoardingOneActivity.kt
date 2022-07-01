package onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.bagicode.smartfarm.NotificationHelper
import com.bagicode.smartfarm.R

class OnBoardingOneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding_one)

        val btn_next_one : Button = findViewById(R.id.btn_next_one)
        val btn_skip_one : Button = findViewById(R.id.btn_skip_one)

        btn_next_one.setOnClickListener {
            NotificationHelper(this).createNotification()
            var intent = Intent(this@OnBoardingOneActivity, OnBoardingTwoActivity::class.java)
            startActivity(intent)
        }

        btn_skip_one.setOnClickListener {
            var intent = Intent(this@OnBoardingOneActivity, OnBoardingFourActivity::class.java)
            startActivity(intent)
        }
    }
}