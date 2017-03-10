package com.lekai.root.javadevz;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import retrofit2.converter.gson.GsonConverterFactory;


import com.lekai.root.javadevz.RetroFit.Item;
import com.lekai.root.javadevz.RetroFit.MyApiEndpointInterface;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;

import static com.lekai.root.javadevz.R.id.username;


public class MainActivity extends AppCompatActivity {
    private final static String API_KEY = "85489f7fdeb964a14917893c8b1d08235227f13f";


    RecyclerView recyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    MyAdapter mAdapter;
    String [] myUsername ;
    String apiKey = "85489f7fdeb964a14917893c8b1d08235227f13f";
    public static final String BASE_URL = "https://api.github.com/";

//    ImageView [] myPictures ;
//    LinearLay item = (LinearLayout) findViewById(R.id.eachItem);
    List<Item> users ;




////////////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView =  (RecyclerView) findViewById(R.id.my_recycler_view);


        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        users = new ArrayList<Item>();
        mAdapter = new MyAdapter(users,getBaseContext());
        recyclerView.setAdapter(mAdapter);

        Toast.makeText(getBaseContext(), "Welcome", Toast.LENGTH_SHORT).show();


        getUser();

    }
    private void getUser(){

        Retrofit retrofit;

        retrofit = new Retrofit.Builder()

                .baseUrl(BASE_URL)


                .addConverterFactory(GsonConverterFactory.create())

                .build();
        MyApiEndpointInterface apiService = retrofit.create(MyApiEndpointInterface.class);

        Call<List<Item>> call = apiService.getUsers();
        call.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                users.clear();
                users.addAll(response.body());
//                todos = populateTodos();
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                String TAG = "failed to connect";
                Log.e(TAG, t.getMessage());
                Toast.makeText(getBaseContext(), "An error occured: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
