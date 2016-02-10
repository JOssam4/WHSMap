package com.awesomeness.whsmap;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.awesomeness.whsmap.Databasefloor1;


public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            int queryNum = Integer.parseInt(query);
            Databasefloor1.putInDataBase();
            if (Databasefloor1.elements.containsKey(queryNum)){
                int[] coord = Databasefloor1.elements.get(queryNum);
            }

        }

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //fab.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        //                .setAction("Action", null).show();
        //    }
        //});
        //
    }
        @Override
        protected void onNewIntent(Intent intent){
            if (Intent.ACTION_SEARCH.equals(intent.getAction())){
                String query = intent.getStringExtra(SearchManager.QUERY);
                int queryNum = Integer.parseInt(query);

            }
        }

    }

