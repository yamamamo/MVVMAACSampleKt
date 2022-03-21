package com.example.mvvmaacsamplekt

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class ProfileViewModel(application: Application):AndroidViewModel(application) {
    val data = MutableLiveData<MutableList<ProfileData>>()
    init {
        data.value = mutableListOf(
            ProfileData(name = "Kang", age = 26),
            ProfileData(name = "Kim", age = 25)
        )
    }

    fun add(){
        data.value?.add(ProfileData(name="강아지",age=22))
        Log.d("TAG", "add: ${data.value?.size}")
//        data.value?.removeAt(0)
    }
}