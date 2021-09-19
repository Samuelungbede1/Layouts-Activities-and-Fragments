package com.example.weektwosecondimplementation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    //Initialising some field variables
    var isFragLoaded= true
    val fragmentManager= supportFragmentManager



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val addFragments= findViewById<Button>(R.id.button_Add)

        val remFragment= findViewById<Button>(R.id.button_Remove)

        // logic to change fragment
        addFragments.setOnClickListener{
            if (isFragLoaded){
                showSecondFragment()
            } else{
                showFirstFragment()
            }
        }

              //This will remove the latest fragment when the back button is pressed
            remFragment.setOnClickListener{
                onBackPressed()
            }

    }

       //This function will show the first fragment
    fun showFirstFragment(){
        val transaction= fragmentManager.beginTransaction()
        val fragment= FirstFragment()

           //This will add, commit, replace fragment at the back stack
        transaction.replace(R.id.container,fragment)

        transaction.addToBackStack(null)
        transaction.commit()
        isFragLoaded=true

    }


    //This function will show the second fragment
    fun showSecondFragment(){
        val transaction= fragmentManager.beginTransaction()
        val fragment= SecondFragment()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
        isFragLoaded=false
    }

     //when the back key is pressed the last fragment is deleted or on the last fragment the app closes
    override fun onBackPressed() {
        val fragment: Fragment?=fragmentManager.findFragmentById(R.id.container)
        if(fragment!=null){
            val transaction= fragmentManager.beginTransaction()
            transaction.remove(fragment)
            transaction.commit()
        }

        super.onBackPressed()
    }



}