package com.example.mvvmaacsamplekt

import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt

class User {

    //ObservalbeField는 박싱 및 언박싱을 방지하기 때문에 val로 설정해주어야 한다.
    val firstName = ObservableField<String>()
    val lastName = ObservableField<String>()
    val age = ObservableInt()
}