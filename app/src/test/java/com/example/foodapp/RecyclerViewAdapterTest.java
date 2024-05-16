package com.example.foodapp;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
public class RecyclerViewAdapterTest {

    @Mock
    Context mockContext;

    private RecyclerViewAdapter adapter;
    private List<Recipes> recipeList;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        // Initialize a sample recipe list
        recipeList = new ArrayList<>();
        recipeList.add(new Recipes("Pasta", "Pasta, Tomato Sauce, Garlic", "Cooking Instructions", "Boil pasta. Heat sauce. " +
                "Mix together.", R.drawable.chicken_roll));

        // Initialize the adapter with mock context and sample data
        adapter = new RecyclerViewAdapter(mockContext, recipeList);
    }

    @Test
    public void getItemCount_shouldReturnCorrectItemCount() {
        // Verify the item count
        assertEquals(1, adapter.getItemCount());
    }

    @Test
    public void onCreateViewHolder_shouldInflateViewHolder() {
        // Create a ViewGroup (RecyclerView) to pass as the parent
        ViewGroup parent = new RecyclerView(RuntimeEnvironment.getApplication());
        RecyclerViewAdapter.MyHolder holder = adapter.onCreateViewHolder(parent, 0);

        // Verify the view holder item view is visible
        assertEquals(View.VISIBLE, holder.itemView.getVisibility());
    }

    @Test
    public void onBindViewHolder_shouldBindDataCorrectly() {
        // Create a ViewGroup (RecyclerView) to pass as the parent
        ViewGroup parent = new RecyclerView(RuntimeEnvironment.getApplication());
        RecyclerViewAdapter.MyHolder holder = adapter.onCreateViewHolder(parent, 0);
        adapter.onBindViewHolder(holder, 0);

        // Verify that the correct data is bound to the view holder
        assertEquals("Pasta", ((TextView) holder.itemView.findViewById(R.id.recipe_text)).getText().toString());
    }

    @Test
    public void cardView_onClick_shouldStartRecipeActivity() {
        // Create a ViewGroup (RecyclerView) to pass as the parent
        ViewGroup parent = new RecyclerView(RuntimeEnvironment.getApplication());
        RecyclerViewAdapter.MyHolder holder = adapter.onCreateViewHolder(parent, 0);
        adapter.onBindViewHolder(holder, 0);

        // Perform click on the card view
        holder.itemView.findViewById(R.id.cardview_id).performClick();

        // Create an expected intent
        Intent expectedIntent = new Intent(mockContext, RecipeActivity.class);
        expectedIntent.putExtra("RecipeName", "Pasta");
        expectedIntent.putExtra("RecipeIngredients", "Pasta, Tomato Sauce, Garlic");
        expectedIntent.putExtra("RecipeMethodTitle", "Cooking Instructions");
        expectedIntent.putExtra("Recipe", "Boil pasta. Heat sauce. Mix together.");
        expectedIntent.putExtra("Thumbnail", R.drawable.chicken_roll);

        // Verify that startActivity was called with the expected intent
        verify(mockContext).startActivity(expectedIntent);
    }
}
