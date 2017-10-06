package com.fa17.ssu385.fa_2017_h4.utilities;


import com.fa17.ssu385.fa_2017_h4.models.RecipeModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RecipeParser {
    public static final RecipeModel recipeFromJson(String jsonString) {
        RecipeModel model = null;
        try {
            JSONObject response = new JSONObject(jsonString);
            JSONArray matches = response.getJSONArray("matches");
            JSONObject recipe = matches.getJSONObject(0);
            //matches or response?
            JSONArray smallImageUrls = recipe.getJSONArray("smallImageUrls");

            model = new RecipeModel();
            model.setRecipeName(recipe.getString("recipeName"));
            model.setRecipeImageUrl(smallImageUrls.getString(0));
            String myString = smallImageUrls.getString(0);
        } catch (JSONException e) {
            // do something useful with exception
        }
        return model;
    }
}
