package com.example.mp3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mp3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().replace(R.id.mainactivity,MusicList()).commit()
    }
}