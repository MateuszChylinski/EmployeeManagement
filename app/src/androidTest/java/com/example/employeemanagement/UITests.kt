package com.example.employeemanagement


import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class UITests {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun uITests() {
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
                withId(R.id.add_employee_name),
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
        appCompatEditText.perform(replaceText("Mateusz"), closeSoftKeyboard())

        val appCompatEditText2 = onView(
            allOf(
                withId(R.id.add_employee_surname),
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
        appCompatEditText2.perform(replaceText("Chylinski"), closeSoftKeyboard())

        val appCompatEditText3 = onView(
            allOf(
                withId(R.id.add_employee_age),
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
        appCompatEditText3.perform(replaceText("26"), closeSoftKeyboard())

        val appCompatEditText4 = onView(
            allOf(
                withId(R.id.add_employee_workplace),
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
        appCompatEditText4.perform(replaceText("Developer"), closeSoftKeyboard())

        val appCompatEditText5 = onView(
            allOf(
                withId(R.id.add_employee_salary),
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
        appCompatEditText5.perform(replaceText("12312"), closeSoftKeyboard())

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

        val floatingActionButton3 = onView(
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
        floatingActionButton3.perform(click())

        val appCompatEditText6 = onView(
            allOf(
                withId(R.id.add_employee_name),
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
        appCompatEditText6.perform(replaceText("Filip"), closeSoftKeyboard())

        val appCompatEditText7 = onView(
            allOf(
                withId(R.id.add_employee_surname),
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
        appCompatEditText7.perform(replaceText("Wandzio"), closeSoftKeyboard())

        val appCompatEditText8 = onView(
            allOf(
                withId(R.id.add_employee_age),
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
        appCompatEditText8.perform(replaceText("22"), closeSoftKeyboard())

        val appCompatEditText9 = onView(
            allOf(
                withId(R.id.add_employee_workplace),
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
        appCompatEditText9.perform(replaceText("Developer"), closeSoftKeyboard())

        val appCompatEditText10 = onView(
            allOf(
                withId(R.id.add_employee_salary),
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
        appCompatEditText10.perform(replaceText("12312"), closeSoftKeyboard())

        val floatingActionButton4 = onView(
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
        floatingActionButton4.perform(click())

        val recyclerView = onView(
            allOf(
                withId(R.id.manage_rv),
                childAtPosition(
                    withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                    1
                )
            )
        )
        recyclerView.perform(actionOnItemAtPosition<ViewHolder>(0, click()))

        val appCompatEditText11 = onView(
            allOf(
                withId(R.id.update_employee_salary), withText("12312.0"),
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
        appCompatEditText11.perform(replaceText("32132"))

        val appCompatEditText12 = onView(
            allOf(
                withId(R.id.update_employee_salary), withText("32132"),
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
        appCompatEditText12.perform(closeSoftKeyboard())

        val appCompatEditText13 = onView(
            allOf(
                withId(R.id.update_employee_salary), withText("32132"),
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
        appCompatEditText13.perform(pressImeActionButton())

        val floatingActionButton5 = onView(
            allOf(
                withId(R.id.update_employee_finish),
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
        floatingActionButton5.perform(click())

        val floatingActionButton6 = onView(
            allOf(
                withId(R.id.manage_delete_all),
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
        floatingActionButton6.perform(click())
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
