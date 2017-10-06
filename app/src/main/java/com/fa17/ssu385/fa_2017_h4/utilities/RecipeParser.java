package com.fa17.ssu385.fa_2017_h4.utilities;


import com.fa17.ssu385.fa_2017_h4.models.RecipeModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RecipeParser {
    public static final RecipeModel recipeFromJson(String jsonString) {
        RecipeModel model = null;
        try {
            // -- Deserializing JSON --
            // take character string of JSON response and make into JSON string assigned to response
            JSONObject response = new JSONObject(jsonString);
            // looks within JSON object (response) for an array called "matches" and assign to matches
            JSONArray matches = response.getJSONArray("matches");
            // grab object at index 0 within matches array, assign it to recipe
            JSONObject recipe = matches.getJSONObject(0);

            model = new RecipeModel();
            // looks within the recipe object to find the value in the object recipeName and sets the name
            model.setRecipeName(recipe.getString("recipeName"));

            JSONArray recipeImageUrl = recipe.getJSONArray("smallImageUrls");
            model.setRecipeImageUrl(recipeImageUrl.getString(0));

        } catch (JSONException e) {
            // do something useful with exception
        }
        return model;
    }
}

// to get "smallImageUrls", need to create new JSON array, grab string at index 0