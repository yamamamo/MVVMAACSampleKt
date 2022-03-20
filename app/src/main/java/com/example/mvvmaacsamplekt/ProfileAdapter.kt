package com.example.mvvmaacsamplekt

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmaacsamplekt.databinding.RcvListItemBinding

class ProfileAdapter(private val context: Context) :
    RecyclerView.Adapter<ProfileAdapter.ProfileVH>() {

    var data = listOf<ProfileData>()

    //데이터 바인딩을 사용해서 기존 ViewHolder에 view를 보내주는 것이 아닌 바인딩 클래스를 보내줘야 한다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileAdapter.ProfileVH {
        val binding = RcvListItemBinding.inflate(
            LayoutInflater.from(context), parent, false)

        return ProfileVH(binding)
    }

    override fun onBindViewHolder(holder: ProfileAdapter.ProfileVH, position: Int) {
        holder.onBind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ProfileVH(val binding: RcvListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ProfileData) { //기존과 다르게 view 를 받는 것이 아닌 바인딩된 클래스를 받는다.
            binding.user = data
        }
    }
}


