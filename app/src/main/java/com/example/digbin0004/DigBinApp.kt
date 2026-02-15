package com.example.digbin0004

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DigBinApp : Application() {

    override fun onCreate() {
        super.onCreate()
        //Log.d("DigBinApp", "onCreate: ")
    }
}