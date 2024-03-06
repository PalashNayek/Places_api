package com.palash.places_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.android.gms.common.api.Status
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener
import com.palash.places_api.utils.Constants.GOOGLE_MAPS_API_KEY

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dummyText = findViewById<TextView>(R.id.dummyText)
        /*if (!Places.isInitialized()) {
            Places.initialize(applicationContext, GOOGLE_MAPS_API_KEY)
        }*/

        val autocompleteSupportFragment =
            (supportFragmentManager.findFragmentById(R.id.fragment) as AutocompleteSupportFragment).setPlaceFields(
                listOf(
                    Place.Field.LAT_LNG,
                    Place.Field.NAME
                )
            )

        autocompleteSupportFragment.setOnPlaceSelectedListener(object : PlaceSelectionListener {
            override fun onError(p0: Status) {
                Log.d("Error", p0.statusMessage.toString())
            }

            override fun onPlaceSelected(p0: Place) {
                try {
                    if (p0.latLng != null) {
                        dummyText.text=p0.latLng!!.toString()
                        val latLng = p0.latLng!!.toString()
                        val name = p0.address!!.toString()
                        Log.d("Place-details-latLng", latLng)
                        Log.d("Place-details-name", name)


                    }
                }catch (e: Exception){
                    e.toString()
                }
            }

        })
    }
}