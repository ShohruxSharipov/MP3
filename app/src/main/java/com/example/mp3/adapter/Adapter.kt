package com.example.mp3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mp3.databinding.MusicBinding
import com.example.mp3.music.MP3

class Adapter(val list: List<MP3>,val mus:Click) : RecyclerView.Adapter<Adapter.MyHolder>() {
    class MyHolder(binding: MusicBinding) : RecyclerView.ViewHolder(binding.root){
        val name = binding.musicname
        val music = binding.root
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(MusicBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.name.text = list[position].name
        holder.music.setOnClickListener { mus.onClick(position) }
    }

    interface Click{
        fun onClick(music : Int)
    }
}