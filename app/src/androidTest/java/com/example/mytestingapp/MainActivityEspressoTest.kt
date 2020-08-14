package com.example.mytestingapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityEspressoTest {
    private val dummyVolume = "504.0"
    private val dummyCircumference = "100.0"
    private val dummySurfaceArea = "396.0"
    private val dummyLength = "12.0"
    private val dummyWidth = "7.0"
    private val dummyHeight = "6.0"
    private val emptyInput = ""
    private val fieldEmpty = "This field cannot be empty"

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun assertGetCircumference() {
        onView(withId(R.id.width)).perform(typeText(dummyWidth), closeSoftKeyboard())
        onView(withId(R.id.length)).perform(typeText(dummyLength), closeSoftKeyboard())
        onView(withId(R.id.height)).perform(typeText(dummyHeight), closeSoftKeyboard())

        onView(withId(R.id.save)).check(matches(isDisplayed()))
        onView(withId(R.id.save)).perform(click())

        onView(withId(R.id.circumference)).check(matches(isDisplayed()))
        onView(withId(R.id.circumference)).perform(click())

        onView(withId(R.id.result)).check(matches(isDisplayed()))
        onView(withId(R.id.result)).check(matches(withText(dummyCircumference)))
    }

    @Test
    fun assertGetSurfaceArea() {
        onView(withId(R.id.width)).perform(typeText(dummyWidth), closeSoftKeyboard())
        onView(withId(R.id.length)).perform(typeText(dummyLength), closeSoftKeyboard())
        onView(withId(R.id.height)).perform(typeText(dummyHeight), closeSoftKeyboard())

        onView(withId(R.id.save)).check(matches(isDisplayed()))
        onView(withId(R.id.save)).perform(click())

        onView(withId(R.id.surface)).check(matches(isDisplayed()))
        onView(withId(R.id.surface)).perform(click())

        onView(withId(R.id.result)).check(matches(isDisplayed()))
        onView(withId(R.id.result)).check(matches(withText(dummySurfaceArea)))
    }

    @Test
    fun assertGetVolume() {
        onView(withId(R.id.width)).perform(typeText(dummyWidth), closeSoftKeyboard())
        onView(withId(R.id.length)).perform(typeText(dummyLength), closeSoftKeyboard())
        onView(withId(R.id.height)).perform(typeText(dummyHeight), closeSoftKeyboard())

        onView(withId(R.id.save)).check(matches(isDisplayed()))
        onView(withId(R.id.save)).perform(click())

        onView(withId(R.id.volume)).check(matches(isDisplayed()))
        onView(withId(R.id.volume)).perform(click())

        onView(withId(R.id.result)).check(matches(isDisplayed()))
        onView(withId(R.id.result)).check(matches(withText(dummyVolume)))
    }

    @Test
    fun assertEmptyInput() {
        //length empty field check
        onView(withId(R.id.length)).perform(typeText(emptyInput), closeSoftKeyboard())

        onView(withId(R.id.save)).check(matches(isDisplayed()))
        onView(withId(R.id.save)).perform(click())

        onView(withId(R.id.length)).check(matches(hasErrorText(fieldEmpty)))
        onView(withId(R.id.length)).perform(typeText(dummyLength), closeSoftKeyboard())

        //width empty field check
        onView(withId(R.id.width)).perform(typeText(emptyInput), closeSoftKeyboard())

        onView(withId(R.id.save)).check(matches(isDisplayed()))
        onView(withId(R.id.save)).perform(click())

        onView(withId(R.id.width)).check(matches(hasErrorText(fieldEmpty)))
        onView(withId(R.id.width)).perform(typeText(dummyWidth), closeSoftKeyboard())

        //height empty field check
        onView(withId(R.id.height)).perform(typeText(emptyInput), closeSoftKeyboard())

        onView(withId(R.id.save)).check(matches(isDisplayed()))
        onView(withId(R.id.save)).perform(click())

        onView(withId(R.id.height)).check(matches(hasErrorText(fieldEmpty)))
        onView(withId(R.id.height)).perform(typeText(dummyHeight), closeSoftKeyboard())

        //click save
        onView(withId(R.id.save)).check(matches(isDisplayed()))
        onView(withId(R.id.save)).perform(click())
    }
}