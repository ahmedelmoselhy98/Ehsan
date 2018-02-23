package com.e.k.m.a.ehsan.association;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.e.k.m.a.ehsan.R;

public class DonorsRecyclerView extends AppCompatActivity {


    RecyclerView associationRecyclerView;
    DonorsRecyclerViewAdapter associationRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donors_recycler_view);
        associationRecyclerView = findViewById(R.id.association_recyclerview);
        associationRecyclerViewAdapter = new DonorsRecyclerViewAdapter(this,15);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        associationRecyclerView.setLayoutManager(layoutManager);
        associationRecyclerView.setHasFixedSize(true);
        associationRecyclerView.setAdapter(associationRecyclerViewAdapter);
    }

}
