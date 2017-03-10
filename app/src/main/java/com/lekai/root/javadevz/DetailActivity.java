package com.lekai.root.javadevz;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class DetailActivity extends AppCompatActivity {

    AppCompatTextView gitUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatTextView gitLogin;
        AppCompatTextView gitUrl;

        gitLogin = (AppCompatTextView) findViewById(R.id.gitName);
        gitUrl = (AppCompatTextView) findViewById(R.id.gitUrl);
//        gitUser = (AppCompatTextView) findViewById(R.id)

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle bundle = getIntent().getExtras();
        String uname  = bundle.getString("username");
//        gitLogin.setText(uname);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
