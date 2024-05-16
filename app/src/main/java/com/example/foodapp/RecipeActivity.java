package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RecipeActivity extends AppCompatActivity {

    private TextView mRecipeName;
    private TextView mRecipeIngredients;
    private TextView mRecipeMethodTitle;
    private TextView mRecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        mRecipeName = findViewById(R.id.text_recipe);
        mRecipeIngredients = findViewById(R.id.ingredients);
        mRecipeMethodTitle = findViewById(R.id.method);
        mRecipe = findViewById(R.id.recipe);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            String Title = extras.getString("RecipeName");
            String Ingredients = extras.getString("RecipeIngredients");
            String MethodTitle = extras.getString("RecipeMethodTitle");
            String Recipe = extras.getString("Recipe");

            mRecipeName.setText(Title);
            mRecipeIngredients.setText(Ingredients);
            mRecipeMethodTitle.setText(MethodTitle);
            mRecipe.setText(Recipe);
        }
    }
}
