package com.kotlinservice

import android.content.BroadcastReceiver
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import android.os.Build
import android.widget.Button
import android.widget.Switch
import android.widget.Toast
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {

    lateinit var wifiManager: WifiManager

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "KotlinApp"
        startForegroundService(Intent(baseContext, MyService::class.java))

        wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
    }
}