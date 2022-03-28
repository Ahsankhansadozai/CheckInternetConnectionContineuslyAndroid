package com.example.checkinternetconnectioncontineuslyandroid

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.checkinternetconnectioncontineuslyandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val networkConnection = NetworkConnection(applicationContext)
        networkConnection.observe(this) { isConnected ->
            if (isConnected) {
                binding.networkConnected.hView.visibility = View.VISIBLE
                binding.networkError.hView.visibility = View.GONE

            } else {

                binding.networkConnected.hView.visibility = View.GONE
                binding.networkError.hView.visibility = View.VISIBLE

            }

        }
    }
}