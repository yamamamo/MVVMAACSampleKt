package com.example.mvvmaacsamplekt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

import androidx.lifecycle.ViewModelProviders

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmaacsamplekt.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding //view binding
    private lateinit var profileAdapter: ProfileAdapter

    private val model: MainViewModel by viewModels()
    private val profileModel: ProfileViewModel by viewModels()
    private val data = MutableLiveData<MutableList<ProfileData>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = model
        binding.profileViewModel = profileModel
//        profileModel = ViewModelProviders.of(this).get(ProfileViewModel::class.java)
        binding.activity = this@MainActivity

        setRcv()

//        setObserv()
    }

    //버튼 이벤트
    fun btnClick(view: View) {
        Toast.makeText(this, "Button Click", Toast.LENGTH_SHORT).show()
        setObserv()
//        profileAdapter.data.add(ProfileData(name = "강아지", age = 22))
//        profileAdapter.notifyDataSetChanged()
    }

    //리사이클러뷰
    fun setRcv() {
        binding.mainRcv.layoutManager = LinearLayoutManager(this)
        profileAdapter = ProfileAdapter(this, profileModel.data)
        binding.mainRcv.adapter = profileAdapter
        profileAdapter.data.value = mutableListOf(
            ProfileData(name = "Kang", age = 26),
            ProfileData(name = "Kim", age = 25)
        )
//        profileAdapter.notifyDataSetChanged()

        val dataObserver: Observer<MutableList<ProfileData>> =
            Observer { livedata ->
                data.value = livedata
//                profileAdapter.notifyDataSetChanged()
            }


//        viewmodel.liveData.observe(this, dataObserver)
        profileModel.data.observe(this, Observer<MutableList<ProfileData>>{profileData ->
            profileAdapter.setContacts(profileData)
        })
    }

    //observable
    fun setObserv() {
        var item: ObservableData = ObservableData()
        item.site = "Naver"
        binding.site = item
//        runOnUiThread(Runnable {
//            run {
//                item.site = "Google"
//            }
//        })
        Handler().postDelayed(Runnable {
            run {
                item.site = "Google"
            }
        }, 3000)
    }

}