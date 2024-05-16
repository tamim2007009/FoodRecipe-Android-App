package com.example.foodapp;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;//error

public class RecyclerViewAdapterUITest {


    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testRecyclerViewItemClick() {
        // Assuming the RecyclerView has an id of 'recyclerView'
        onView(withId(R.id.recyclerView_id))
                .perform(actionOnItemAtPosition(0, click()));

        // Check if the new activity is opened by verifying if a view with an expected text is displayed
        onView(withId(R.id.recipe_text)).check(matches(withText("Expected Recipe Name")));
    }


}
