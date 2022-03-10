package com.kotlinservice

import android.app.Service
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import android.os.IBinder
import android.util.Log
import android.widget.Toast
class MyService : Service() {

    lateinit var receiver : WifiStateReceiver

    override fun onCreate() {
        super.onCreate()

        receiver = WifiStateReceiver()

        val intentFilter = IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION)
        registerReceiver(receiver, intentFilter)
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        onTaskRemoved(intent)
        return START_STICKY
    }
    override fun onBind(intent: Intent): IBinder? {
        // TODO: Return the communication channel to the service.
        throw UnsupportedOperationException("Not yet implemented")
    }
    override fun onTaskRemoved(rootIntent: Intent) {
        //Log.e("Service", "Running")
        val restartServiceIntent = Intent(applicationContext, this.javaClass)
        restartServiceIntent.setPackage(packageName)
        startService(restartServiceIntent)
        super.onTaskRemoved(rootIntent)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }
}