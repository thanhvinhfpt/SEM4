package com.keysoft.maithanhvinh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ListFeedBackActivity extends AppCompatActivity {
    AppDatabase db;
    List<FeedBack> listFeedback = new ArrayList<>();
    FeedBackAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_feed_back);
        showList();

    }

    @Override
    protected void onResume() {
        super.onResume();
        showList();
    }

    private void showList() {
        db = AppDatabase.getAppDatabase(this);

        //get all data
        getData();

        //Adapter
        adapter = new FeedBackAdapter(this, listFeedback);

        //layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        //Recycle view
        RecyclerView rvItem = findViewById(R.id.rvFeedback);
        rvItem.setLayoutManager(layoutManager);
        rvItem.setAdapter(adapter);
    }

    private void getData() {
        listFeedback = db.feedBackDao().listFeedBack();
    }
}