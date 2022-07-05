package com.exsample.androidsecuringkeysndkbuild

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    var serverKey = BuildConfig.SERVER_KEY
    var smsKey = BuildConfig.SMS_KEY

    init {
        System.loadLibrary("keys")
    }


    external fun getPublicKey(): String?
    external fun getPrivateKey(): String?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", serverKey)
        Log.d("MainActivity", smsKey)


        Log.d("MainActivity", getPublicKey().toString())
        Log.d("MainActivity", getPrivateKey().toString())

    }
}