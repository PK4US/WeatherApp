package com.pk4us.weatherapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pk4us.weatherapp.databinding.ActivityMainBinding
import com.pk4us.weatherapp.fragment.MainFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.placeHolder,MainFragment.newInstance()).commit()
    }
}