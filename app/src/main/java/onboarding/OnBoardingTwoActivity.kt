package onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.bagicode.smartfarm.R

class OnBoardingTwoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding_two)

        val btn_next_two : Button = findViewById(R.id.btn_next_two)
        val btn_skip_two : Button = findViewById(R.id.btn_skip_two)

        btn_next_two.setOnClickListener {
            var intent = Intent(this@OnBoardingTwoActivity, OnBoardingThreeActivity::class.java)
            startActivity(intent)
        }

        btn_skip_two.setOnClickListener {
            var intent = Intent(this@OnBoardingTwoActivity, OnBoardingFourActivity::class.java)
            startActivity(intent)
        }
    }
}