package com.example.classwork

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var nextPage= findViewById<Button>(R.id.nextActivity)
        nextPage.setOnClickListener{
            val intent= Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        var showName =findViewById<TextView>(R.id.seeName)
        var editName =findViewById<TextView>(R.id.editText)

          var tap= findViewById<Button>(R.id.button2)
          tap.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            showName.text= editName.text





        }

    }
}