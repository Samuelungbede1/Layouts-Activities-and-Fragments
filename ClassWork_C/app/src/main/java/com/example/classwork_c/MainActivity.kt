package com.example.classwork_c

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val next= findViewById<Button>(R.id.button_Next)
        var etCountryName= findViewById<EditText>(R.id.etCountry)


        //setting the onclick listener
        next.setOnClickListener {
            var nameOfCountry= etCountryName.text.toString()


            //Logic to check for the length of the country name
            if(nameOfCountry.length<11){
                etCountryName.error="Country Name must be greater than 11 characters"
                return@setOnClickListener
            }

            // passing the country name to another activitiy
           val intent= Intent(this, MainActivityB::class.java)
            intent.putExtra("country name", nameOfCountry)
            startActivity(intent)
        }
    }
}