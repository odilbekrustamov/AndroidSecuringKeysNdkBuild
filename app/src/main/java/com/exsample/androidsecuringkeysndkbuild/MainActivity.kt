package com.exsample.androidsecuringkeysndkbuild

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_pattern.adapter.PostAdapter
import com.example.mvvm_pattern.model.Post
import com.example.mvvm_pattern.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    var serverKey = BuildConfig.SERVER_KEY
    var smsKey = BuildConfig.SMS_KEY

    init {
        System.loadLibrary("keys")
    }
    private lateinit var recyclerView: RecyclerView
    lateinit var viewModel: MainViewModel

    external fun getPublicKey(): String?
    external fun getPrivateKey(): String?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", serverKey)
        Log.d("MainActivity", smsKey)


        Log.d("MainActivity", getPublicKey().toString())
        Log.d("MainActivity", getPrivateKey().toString())
        initViews()
    }

    private fun initViews() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setLayoutManager(GridLayoutManager(this, 1))

        viewModel.apiPostList().observe(this, Observer {
            refreshAdapter(it)
        })
    }

    fun refreshAdapter(posters: ArrayList<Post>) {
        val adapter = PostAdapter(this, posters)
        recyclerView.setAdapter(adapter)
    }
}