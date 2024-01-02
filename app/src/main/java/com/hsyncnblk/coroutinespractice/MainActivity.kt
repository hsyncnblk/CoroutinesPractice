package com.hsyncnblk.coroutinespractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.hsyncnblk.coroutinespractice.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private  var counter: Int =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCount.setOnClickListener {
            binding.tvCount.text = counter++.toString()
        }

        binding.btnDownload.setOnClickListener {

            CoroutineScope(Dispatchers.IO).launch {
                //eğer CoroutineScope kullanmasak indirme işlemi sırasında sayac butonuna tıklarsak uygulama çöker

                for (i in 1 .. 100000){
                    Log.i("TAG", "Downloading $i in ${Thread.currentThread().name}")
                }

            }


        }


    }
}