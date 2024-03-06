package com.palash.places_api

import android.app.Application
import com.google.android.libraries.places.api.Places
import com.palash.places_api.utils.Constants.GOOGLE_MAPS_API_KEY
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Initialize Places API
        Places.initialize(applicationContext, GOOGLE_MAPS_API_KEY)
        /*if (!Places.isInitialized()) {
            Places.initialize(applicationContext, GOOGLE_MAPS_API_KEY)
        }*/
    }
}