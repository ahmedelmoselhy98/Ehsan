package com.e.k.m.a.ehsan.donor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

import com.e.k.m.a.ehsan.R;

/**
 * Created by ahmedelmoselhy on 2/21/2018.
 */

public class BankAccountRecyclerAdapter extends RecyclerView.Adapter<BankAccountRecyclerAdapter.BankAccountRecyclerViewHolder> {


    private static int NUM_OF_ITEMS;
    private static Context mContext;

    public BankAccountRecyclerAdapter(Context mContext,int NUM_OF_ITEMS) {
        this.NUM_OF_ITEMS = NUM_OF_ITEMS;
        this.mContext = mContext;
    }

    @Override
    public BankAccountRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.bank_account_recyclerview_item,parent,false);
        BankAccountRecyclerViewHolder bankAccountRecyclerViewHolder = new BankAccountRecyclerViewHolder(v);
        return bankAccountRecyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(BankAccountRecyclerViewHolder holder, int position) {
        setScaleAnimation(holder.itemView);
    }
    // functions to Animate Recycler Items
    private void setFadeAnimation(View view) {
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(FADE_DURATION);
        view.startAnimation(anim);
    }
    private final static int FADE_DURATION = 1000;
    private void setScaleAnimation(View view) {
        ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setDuration(FADE_DURATION);
        view.startAnimation(anim);
    }


    @Override
    public int getItemCount() {
        if (NUM_OF_ITEMS >0){
            return NUM_OF_ITEMS;
        }else
            return 0;
    }

    public class BankAccountRecyclerViewHolder extends RecyclerView.ViewHolder{
        public BankAccountRecyclerViewHolder (View itemView) {
            super(itemView);
        }

        public void bind(int itemPosition){

        }


    }
}
