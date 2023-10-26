package kr.ac.kumoh.s20180074.cw03lotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kr.ac.kumoh.s20180074.cw03lotto.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("OnCreate", "called")
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.creation.setOnClickListener{
            mainBinding.number1.text = Random.nextInt(1, 46).toString()
            mainBinding.number2.text = Random.nextInt(1, 46).toString()
            mainBinding.number3.text = Random.nextInt(1, 46).toString()
            mainBinding.number4.text = Random.nextInt(1, 46).toString()
            mainBinding.number5.text = Random.nextInt(1, 46).toString()
            mainBinding.number6.text = Random.nextInt(1, 46).toString()
        }
    }
}