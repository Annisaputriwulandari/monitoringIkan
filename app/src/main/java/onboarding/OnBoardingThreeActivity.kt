package onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.bagicode.smartfarm.HomeActivity
import com.bagicode.smartfarm.R

class OnBoardingThreeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding_three)

        val btn_next_three : Button = findViewById(R.id.btn_next_three)
        val btn_skip_three : Button = findViewById(R.id.btn_skip_three)

        btn_next_three.setOnClickListener {
            var intent = Intent(this@OnBoardingThreeActivity, OnBoardingFourActivity::class.java)
            startActivity(intent)
        }

        btn_skip_three.setOnClickListener {
            var intent = Intent(this@OnBoardingThreeActivity, OnBoardingFourActivity::class.java)
            startActivity(intent)
        }
    }
}