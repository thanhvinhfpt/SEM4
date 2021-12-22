package com.keysoft.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private List<Item> listItem = new ArrayList<>();
    ItemAdapter adapter;
    TextView tvIconPhrase, tvTempHanoi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvIconPhrase = findViewById(R.id.tvIconPhrase);
        tvTempHanoi = findViewById(R.id.tvTempHanoi);
        // get data;
        getDatas();

        //Adapter
        adapter = new ItemAdapter(this, listItem);

        //layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        //Recycle view
        RecyclerView rvItem = findViewById(R.id.rvItem);
        rvItem.setLayoutManager(layoutManager);
        rvItem.setAdapter(adapter);

    }

    private void getDatas() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dataservice.accuweather.com/forecasts/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiManager service = retrofit.create(ApiManager.class);
        service.getData().enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                listItem = response.body();
                tvIconPhrase.setText(listItem.get(0).getIconPhrase());
                tvTempHanoi.setText(listItem.get(0).getTemperature().getValue() + "");
                adapter.reloadData(listItem);
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {

            }

        });
    }
}