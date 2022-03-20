package com.example.mvvmaacsamplekt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmaacsamplekt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding //view binding
    private lateinit var profileAdapter : ProfileAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.activity = this@MainActivity

        setRcv()
    }

    //버튼 이벤트
    fun btnClick(view : View){
        Toast.makeText(this,"Button Click",Toast.LENGTH_SHORT).show()
    }

    fun setRcv(){
        profileAdapter = ProfileAdapter(this)
        binding.mainRcv.layoutManager = LinearLayoutManager(this)
        binding.mainRcv.adapter = profileAdapter
        profileAdapter.data = listOf(
            ProfileData(name = "Kang", age = 26),
            ProfileData(name = "Kim", age = 25)
        )
//        profileAdapter.notifyDataSetChanged()
    }

}