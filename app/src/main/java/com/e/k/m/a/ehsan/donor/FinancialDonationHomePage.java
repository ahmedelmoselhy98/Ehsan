package com.e.k.m.a.ehsan.donor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.e.k.m.a.ehsan.R;

public class FinancialDonationHomePage extends AppCompatActivity {

    RecyclerView financialDonationRecyclerView;
    FinancialDonationRecyclerAdapter financialDonationRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financial_donation_home_page);
        financialDonationRecyclerView = findViewById(R.id.financial_donation_recycler);
        financialDonationRecyclerAdapter = new FinancialDonationRecyclerAdapter(this,15);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        financialDonationRecyclerView.setLayoutManager(layoutManager);
        financialDonationRecyclerView.setHasFixedSize(true);
        financialDonationRecyclerView.setAdapter(financialDonationRecyclerAdapter);
    }
}
