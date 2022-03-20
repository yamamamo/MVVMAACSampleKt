package com.example.mvvmaacsamplekt

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData


/** ViewModel 안에 LiveData 가 있는 구조
 *
 * */
class MainViewModel( application: Application) : AndroidViewModel(application) {
    // ViewModel()을 상속받을 경우
    // class MainViewModel():ViewModel(){}

    //LiveData
    //값이 변경되는 경우 MutableLiveData로 선언한다.
    //LiveData 객체의 값이 변경될 경우에는 MutableLiveData<T>()으로 선언
    var count = MutableLiveData<Int>()

    init {
        count.value = 0
    }

    fun increase(){
        count.value = count.value?.plus(1)
    }

    fun decrease(){
        count.value = count.value?.minus(1)
    }

}