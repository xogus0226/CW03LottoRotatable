package kr.ac.kumoh.s20180074.cw03lotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kr.ac.kumoh.s20180074.cw03lotto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var main: ActivityMainBinding
    private lateinit var model : LottoViewModel
    private lateinit var txtNum : Array<TextView>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        main = ActivityMainBinding.inflate(layoutInflater)
        setContentView(main.root)

        // ViewModelProvider로만 ViewModel 객체 생성을 할 수 있어서
        model = ViewModelProvider(this)[LottoViewModel::class.java]
        txtNum = arrayOf(main.number1, main.number2, main.number3, main.number4, main.number5, main.number6)

        setTxtNum()

        model.numbers.observe(this, Observer{
            Log.i("Observer !!!", "Detect !!")
            setTxtNum()
        })

        main.creation.setOnClickListener{
            // view model의 로또번호들 섞기
            model.generate()
        }
    }
    fun setTxtNum(){
        txtNum.forEachIndexed { index, textView ->  textView.text = model.numbers.value!![index].toString()}
    }
}