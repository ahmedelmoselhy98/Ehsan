package com.e.k.m.a.ehsan.association;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.e.k.m.a.ehsan.R;
import com.e.k.m.a.ehsan.donor.FinancialDonationRecyclerAdapter;

public class DonorsRecyclerView extends AppCompatActivity {


    RecyclerView associationRecyclerView;
    AssociationRecyclerViewAdapter associationRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_association_recycler_view);
        associationRecyclerView = findViewById(R.id.association_recyclerview);
        associationRecyclerViewAdapter = new AssociationRecyclerViewAdapter(this,15);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        associationRecyclerView.setLayoutManager(layoutManager);
        associationRecyclerView.setHasFixedSize(true);
        associationRecyclerView.setAdapter(associationRecyclerViewAdapter);
    }

}
