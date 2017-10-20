package com.fa17.ssu385.fa_2017_h4.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.fa17.ssu385.fa_2017_h4.R;
import com.fa17.ssu385.fa_2017_h4.models.RecipeModel;
import com.fa17.ssu385.fa_2017_h4.network.RecipeCallbackListener;
import com.fa17.ssu385.fa_2017_h4.network.RecipeSearchAsyncTask;

public class SearchActivity extends AppCompatActivity {

    private TextView recipeName;
    private ImageView recipeThumbnail;
    private EditText searchEditText;
    private Button searchButton;
    private RecipeCallbackListener recipeCallbackListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        recipeName = (TextView)findViewById(R.id.recipe_name);
        recipeThumbnail = (ImageView)findViewById(R.id.recipe_thumbnail);
        searchEditText = (EditText) findViewById(R.id.search_edit_text);
        searchButton = (Button)findViewById(R.id.my_search_button);

        searchButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                recipeCallbackListener = new RecipeCallbackListener() {
                    @Override
                    public void onRecipeCallback(RecipeModel recipeModel) {
                        recipeName.setText(recipeModel.getRecipeName());
                    }
                };
                RecipeSearchAsyncTask task = new RecipeSearchAsyncTask();
                task.setRecipeCallbackListener(recipeCallbackListener);
                task.execute(searchEditText.getText().toString());
            }

        });

    }
}
