package com.example.myapplication3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myModel: TestModel
    private lateinit var textBox: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 우선 바인딩할 데이터 초기화
        myModel = ViewModelProvider(this).get(TestModel::class.java)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        textBox = binding.vmText
        // 데이터 바인딩 진행
        binding.vm = myModel
        binding.lifecycleOwner = this
    }

    fun onSubmited(v: View) {
        val intent = Intent(this, SubActivity::class.java)
        val text = textBox.text.toString()
        intent.putExtra("text", text)
        startActivity(intent)
    }
}