package com.example.pod_ass

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.ImageView


class MainActivity : AppCompatActivity() {

    var isImageVisible= false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var image = findViewById<ImageView>(R.id.image_View)
        var button = findViewById<Button>(R.id.toggle_button)



        if(savedInstanceState!=null){
            isImageVisible=savedInstanceState.getBoolean("key")


            if (isImageVisible) {
                image.visibility = View.INVISIBLE
                button.text = "Show Image"
            } else {
                image.visibility = View.VISIBLE
                button.text = "Hide Image"
            }

        }


        button.setOnClickListener {
            if (isImageVisible) {
                image.visibility = View.VISIBLE
                button.text = "Hide image"
                isImageVisible=false
            } else {
                image.visibility = View.INVISIBLE
                button.text = "Show Image"
                isImageVisible=true
            }
        }

        }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
         outState.putBoolean("key", isImageVisible)

    }
}
