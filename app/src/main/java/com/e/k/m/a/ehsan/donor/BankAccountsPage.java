package com.e.k.m.a.ehsan.donor;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.e.k.m.a.ehsan.R;



public class BankAccountsPage extends Fragment {

    RecyclerView bankAccountRecyclerView;
    BankAccountRecyclerAdapter bankAccountRecyclerAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_bank_accounts_page, container, false);
        bankAccountRecyclerView = root.findViewById(R.id.bank_account_recyclerview);
        bankAccountRecyclerAdapter = new BankAccountRecyclerAdapter(this.getActivity(),15);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        bankAccountRecyclerView.setLayoutManager(layoutManager);
        bankAccountRecyclerView.setHasFixedSize(true);
        bankAccountRecyclerView.setAdapter(bankAccountRecyclerAdapter);

        return root;
    }
}
