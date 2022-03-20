package com.example.mvvmaacsamplekt

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class ProfileViewModel(application: Application):AndroidViewModel(application) {
    val data = MutableLiveData<MutableList<ProfileData>>()
    init {

    }

    fun add(){
        data.value?.add(ProfileData(name="강아지",age=22))
        Log.d("TAG", "add: ${data.value?.size}")
    }
}