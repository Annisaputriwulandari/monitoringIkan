package onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.bagicode.smartfarm.HomeActivity
import com.bagicode.smartfarm.R

class OnBoardingFourActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding_four)

        val btn_skip_four : Button = findViewById(R.id.btn_skip_four)

        btn_skip_four.setOnClickListener {
            var intent = Intent(this@OnBoardingFourActivity, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}