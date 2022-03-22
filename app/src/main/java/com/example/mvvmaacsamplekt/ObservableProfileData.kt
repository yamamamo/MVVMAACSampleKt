package com.example.mvvmaacsamplekt

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

/**  테스트용
 *
 *   사용안합니다.
 *
 * */
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