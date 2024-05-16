package com.example.foodapp;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class RecipesTest extends TestCase {



    private Recipes recipe;

    @Before
    public void setUp() {
        recipe = new Recipes(
                "Pasta",
                "Pasta, Tomato Sauce, Garlic",
                "Cooking Instructions",
                "Boil pasta. Heat sauce. Mix together.",
                R.drawable.chicken_roll // Assume R.drawable.pasta_thumbnail is an int constant representing a drawable resource.
        );
    }

    @Test
    public void testGetRecipeName() {
        assertEquals("Pasta", recipe.getRecipeName());
    }

    @Test
    public void testGetRecipeIngredients() {
        assertEquals("Pasta, Tomato Sauce, Garlic", recipe.getRecipeIngredients());
    }

    @Test
    public void testGetRecipeMethodTitle() {
        assertEquals("Cooking Instructions", recipe.getRecipeMethodTitle());
    }

    @Test
    public void testGetRecipe() {
        assertEquals("Boil pasta. Heat sauce. Mix together.", recipe.getRecipe());
    }

    @Test
    public void testGetThumbnail() {
        assertEquals(R.drawable.chicken_roll, recipe.getThumbnail());
    }


    @Test
    public void testGetters() {
        // Arrange
        String name = "Spaghetti Carbonara";
        String ingredients = "Spaghetti, eggs, pancetta, Parmesan cheese, black pepper";
        String methodTitle = "Instructions";
        String recipe = "1. Cook spaghetti until al dente. 2. In a separate pan, cook pancetta until crispy...";
        int thumbnail = 12345;

        Recipes recipes = new Recipes(name, ingredients, methodTitle, recipe, thumbnail);


        String retrievedName = recipes.getRecipeName();
        String retrievedIngredients = recipes.getRecipeIngredients();
        String retrievedMethodTitle = recipes.getRecipeMethodTitle();
        String retrievedRecipe = recipes.getRecipe();
        int retrievedThumbnail = recipes.getThumbnail();

        assertEquals(name, retrievedName);
        assertEquals(ingredients, retrievedIngredients);
        assertEquals(methodTitle, retrievedMethodTitle);
        assertEquals(recipe, retrievedRecipe);
        assertEquals(thumbnail, retrievedThumbnail);

    }


}