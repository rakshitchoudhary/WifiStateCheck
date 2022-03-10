package com.kotlinservice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import android.widget.Toast

class WifiStateReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        when (intent!!.getIntExtra(
            WifiManager.EXTRA_WIFI_STATE,
            WifiManager.WIFI_STATE_UNKNOWN)) {
            WifiManager.WIFI_STATE_ENABLED -> {
                Toast.makeText(context, "Wifi is On", Toast.LENGTH_SHORT).show()
            }
            WifiManager.WIFI_STATE_DISABLED -> {
                Toast.makeText(context, "Wifi is Off", Toast.LENGTH_SHORT).show()
            }
        }
    }
}