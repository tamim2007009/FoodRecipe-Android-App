package com.example.foodapp;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Intent;

import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class RecipeActivityTest {

    private Intent intent;

    @Before
    public void setUp() {
        intent = new Intent(ApplicationProvider.getApplicationContext(), RecipeActivity.class);
        intent.putExtra("RecipeName", "Pasta");
        intent.putExtra("RecipeIngredients", "Pasta, Tomato Sauce, Garlic");
        intent.putExtra("RecipeMethodTitle", "Cooking Instructions");
        intent.putExtra("Recipe", "Boil pasta. Heat sauce. Mix together.");
    }

    @Test
    public void testRecipeDetailsDisplayed() {
        try (ActivityScenario<RecipeActivity> scenario = ActivityScenario.launch(intent)) {
            onView(withId(R.id.text_recipe)).check(matches(withText("Pasta")));
            onView(withId(R.id.ingredients)).check(matches(withText("Pasta, Tomato Sauce, Garlic")));
            onView(withId(R.id.method)).check(matches(withText("Cooking Instructions")));
            onView(withId(R.id.recipe)).check(matches(withText("Boil pasta. Heat sauce. Mix together.")));
        }
    }
}
