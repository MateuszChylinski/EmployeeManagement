package com.example.employeemanagement


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class AddNewEmployeeTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun addNewEmployeeTest() {
        val floatingActionButton = onView(
            allOf(
                withId(R.id.manage_add_employee),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.nav_container),
                        0
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        floatingActionButton.perform(click())

        val appCompatEditText = onView(
            allOf(
                withId(R.id.employee_name),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.nav_container),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText.perform(replaceText("Filip"), closeSoftKeyboard())

        val appCompatEditText2 = onView(
            allOf(
                withId(R.id.employee_surname),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.nav_container),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatEditText2.perform(replaceText("Wandzio"), closeSoftKeyboard())

        val appCompatEditText3 = onView(
            allOf(
                withId(R.id.employee_age),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.nav_container),
                        0
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        appCompatEditText3.perform(replaceText("22"), closeSoftKeyboard())

        val appCompatEditText4 = onView(
            allOf(
                withId(R.id.employee_workplace),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.nav_container),
                        0
                    ),
                    4
                ),
                isDisplayed()
            )
        )
        appCompatEditText4.perform(replaceText("InMyRoomSoft"), closeSoftKeyboard())

        val appCompatEditText5 = onView(
            allOf(
                withId(R.id.employee_salary),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.nav_container),
                        0
                    ),
                    5
                ),
                isDisplayed()
            )
        )
        appCompatEditText5.perform(replaceText("0"), closeSoftKeyboard())

        val floatingActionButton2 = onView(
            allOf(
                withId(R.id.add_new_employee),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.nav_container),
                        0
                    ),
                    6
                ),
                isDisplayed()
            )
        )
        floatingActionButton2.perform(click())
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}