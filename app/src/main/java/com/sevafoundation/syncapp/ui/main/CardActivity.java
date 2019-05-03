package com.sevafoundation.syncapp.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sevafoundation.syncapp.R;
import com.sevafoundation.syncapp.data.adapters.CustomAdapter;

import java.util.ArrayList;
import java.util.List;

public class CardActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    //model object for our list data
    private List<String> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        loadRecyclerViewItem();
    }

    private void loadRecyclerViewItem() {
        //you can fetch the data from server or some apis
        //for this tutorial I am adding some dummy data directly
        for (int i = 1; i <= 5; i++) {

            list.add("Dummy Heading " + i);
        }

        adapter = new CustomAdapter(list, this);
        recyclerView.setAdapter(adapter);
    }
}
