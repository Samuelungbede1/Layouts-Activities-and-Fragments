package com.example.classwork_c

import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*


import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test



class MainActivityTest {

  lateinit var stringToBetyped_One : String
    lateinit var stringToBetyped_Two : String


    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)


    @Before
    fun validInput() {
        stringToBetyped_One = "Uzbekiztan"
        stringToBetyped_Two = "Turkmeniztan"


    }



    @Test
    fun changeText_nextActivity() {
        // Type text and then press the button.
        onView(withId(R.id.etCountry))
            .perform(typeText(stringToBetyped_One), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.button_Next)).perform(click())
        onView(withId(R.id.etCountry))
            .perform(clearText())


        onView(withId(R.id.etCountry))
            .perform(typeText(stringToBetyped_Two), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.button_Next)).perform(click())

        // Check that the text was changed.
        onView(withId(R.id.textView))
            .check(matches(withText(stringToBetyped_Two)))
    }

}