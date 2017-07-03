package com.example.jd.praticalround;

import android.app.ProgressDialog;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.jd.praticalround.Model.Contact;
import com.example.jd.praticalround.Retrofit.ApiClient;
import com.example.jd.praticalround.Retrofit.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecycleAdapter recycleAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<Contact> contactList;
    private ApiInterface apiInterface;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }
    private void initViews(){
        pd = new ProgressDialog(this);
        pd.setMessage("Fetching Data...");
        pd.setCancelable(false);
        pd.show();
        recyclerView=(RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.smoothScrollToPosition(0);

        loadJSON();
    }

    private void loadJSON() {
        apiInterface =ApiClient.getRetrofit().create(ApiInterface.class);
        //call the api
        Call<List<Contact>> call=apiInterface.getContact();
        //handle the result

        call.enqueue(new Callback<List<Contact>>() {
            @Override
            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
                contactList =response.body();
                recycleAdapter =new RecycleAdapter(contactList,getApplicationContext());
                recyclerView.setAdapter(recycleAdapter);
                pd.hide();

            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error Fetching Data!", Toast.LENGTH_SHORT).show();
                pd.hide();

            }
        });

    }

}
