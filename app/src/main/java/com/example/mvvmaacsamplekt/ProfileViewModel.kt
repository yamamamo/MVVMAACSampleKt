package com.example.mvvmaacsamplekt

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
/**
 *   리사이클러뷰 뷰모델
 *
 * */
class ProfileViewModel(application: Application):AndroidViewModel(application) {
    val data = MutableLiveData<MutableList<ProfileData>>()

    init {
        data.value = mutableListOf(
//            ProfileData(name = "Kang", age = 26),
//            ProfileData(name = "Kim", age = 25)
        )
    }
   /**List 같은 타입은 call by reference로 값을 참조하기 때문에
    *
    * getValue에서 만든 data와 data가 같은 주소값을 참조하고 있어서,
    *
    * 임시로 만든 data의 값이 변하면 똑같이 mData의 값을 변경할 수 있습니다.
    *
    * 그래서 this.value = this.value를 하면 이전에
    *
    * .add()를 통해 변경된 값이 data에 적용이 되어있기 때문에
    *
    * 최신 값 그대로 setValue()를 통해서 observe를 호출 할수 있습니다.
    * */
    fun <T> MutableLiveData<T>.notifyObserver() { this.value = this.value }

    //리사이클러뷰 아이템 추가
    fun add(){
        data.value?.add(ProfileData(name="강아지",age=22))
//        Log.d("TAG", "add: ${data.value?.size}")
        data.notifyObserver()
    }
}