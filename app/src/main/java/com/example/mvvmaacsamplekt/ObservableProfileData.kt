package com.example.mvvmaacsamplekt

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class ObservableProfileData : BaseObservable(){
    @get:Bindable
    var data : MutableList<ProfileData>
        get() {
            TODO()
        }
        set(value){
        data = value
        notifyPropertyChanged(BR.data)
    }
}