package com.e.k.m.a.ehsan.association;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.e.k.m.a.ehsan.R;

public class AssociationHomePage extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_association_home_page);
    }

    public void openSearchDonor(View view){
        startActivity(new Intent(this,AssociationRecyclerView.class));
    }
}
