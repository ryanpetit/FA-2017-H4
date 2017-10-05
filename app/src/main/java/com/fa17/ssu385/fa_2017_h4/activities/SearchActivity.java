package com.fa17.ssu385.fa_2017_h4.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.fa17.ssu385.fa_2017_h4.R;
import com.fa17.ssu385.fa_2017_h4.network.RecipeSearchAsyncTask;

public class SearchActivity extends AppCompatActivity {

    private TextView recipeName;
    private ImageView recipeThumbnail;
    private EditText searchEditText;
    private Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

    }
}
