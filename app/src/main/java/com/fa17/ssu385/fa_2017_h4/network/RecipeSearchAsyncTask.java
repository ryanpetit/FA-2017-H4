package com.fa17.ssu385.fa_2017_h4.network;

import android.os.AsyncTask;

import com.fa17.ssu385.fa_2017_h4.models.RecipeModel;
import com.fa17.ssu385.fa_2017_h4.utilities.RecipeParser;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;


public class RecipeSearchAsyncTask extends AsyncTask<String, String, RecipeModel> {

    private String baseApiUrl = "http://api.yummly.com/v1/api/recipes";
    private String apiKey = "ec3e34e0bb6801670dbd3dbd02ce7608";
    private String appId = "4911b643";

    private RecipeCallbackListener recipeCallbackListener;

    @Override
    protected RecipeModel doInBackground(String... params) {
        String searchParams = params[0];
        OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse(baseApiUrl).newBuilder();
        urlBuilder.addQueryParameter("_app_key", apiKey);
        urlBuilder.addQueryParameter("_app_id", appId);
        urlBuilder.addQueryParameter("your_search_parameters", searchParams);
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder().url(url).build();
        Response response = null;
        try {
            response = client.newCall(request).execute();

            if (response != null) {
                return RecipeParser.recipeFromJson(response.body().string());
            }
        } catch (IOException e) {
            // ...
        }
        return null;
    }
    @Override
    protected void onPostExecute(RecipeModel recipeModel) {
        super.onPostExecute(recipeModel);


    }

    public void setRecipeCallbackListener(RecipeCallbackListener recipeCallbackListener) {
        this.recipeCallbackListener = recipeCallbackListener;
    }}


