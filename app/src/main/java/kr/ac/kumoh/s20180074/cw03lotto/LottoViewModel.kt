package kr.ac.kumoh.s20180074.cw03lotto

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class LottoViewModel : ViewModel() {
    private var _numbers = IntArray(6) { 0 }
    val numbers get() = _numbers // private 변수 _numbers를 외부에서 읽기 위함

    fun generate(){
        // MutableLiveData 변수 _numbers에 저장할 newNumbers 생성하기
        val newNumbers = IntArray(6) { 0 }
        var num = 0
        for(i in newNumbers.indices){
            do {
                num = Random.nextInt(1, 46)
            } while(newNumbers.contains(num))

            newNumbers[i] = num
        }

        newNumbers.sort()

        // newNumbers를 _numbers에 저장하기
        _numbers = newNumbers
    }
}