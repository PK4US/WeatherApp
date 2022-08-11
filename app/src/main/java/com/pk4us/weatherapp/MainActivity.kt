package com.pk4us.weatherapp

import android.app.DownloadManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.pk4us.weatherapp.databinding.ActivityMainBinding
import org.json.JSONObject

const val API_KEY = "3442427ab7b944acb4892702221108"
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bGet.setOnClickListener {
            getResult("London")
        }
    }
    private fun getResult(name:String){
        val url = "https://api.weatherapi.com/v1/current.json?key=$API_KEY&q=$name&aqi=no"
        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest (
            Request.Method.GET,
            url,
            {response ->
                val obj = JSONObject(response)
                val temp = obj.getJSONObject("current")
                Log.d("MyLog","Response: ${temp.getString("temp_c")}")
                binding.tvTemp.text = temp.getString("temp_c")
            },
            { Log.d("MyLog","Error: $it")})

        queue.add(stringRequest)
    }
}