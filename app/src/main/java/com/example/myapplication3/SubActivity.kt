package com.example.myapplication3

import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication3.databinding.ActivitySubBinding

class SubActivity: AppCompatActivity() {
    private lateinit var subBinding: ActivitySubBinding
    private lateinit var textSub: TextView
    private lateinit var myModel: TestModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 바인딩할 데이터 초기화
        myModel = ViewModelProvider(this).get(TestModel::class.java)

        // 바인딩 작업
        subBinding = DataBindingUtil.setContentView(this, R.layout.activity_sub)
        subBinding.vm = myModel
        subBinding.lifecycleOwner = this
        textSub = subBinding.textView

        // 메인으로부터 데이터를 받아와 textSUb에 저장
        textSub.text = intent.getStringExtra("text").toString()

        // 트리거 메소드 작성
        val textObserver = Observer<String> {
            it -> textSub.text = it
        }

        // 이벤트 연결
        myModel.text.observe(this, textObserver)
    }

    fun onFinish(v: View) {
        Toast.makeText(this, "Sub 페이지의 데이터가 삭제됩니다!", Toast.LENGTH_SHORT).show()
        finish()
    }
}