package com.e.k.m.a.ehsan.association;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

import com.e.k.m.a.ehsan.R;

/**
 * Created by ahmedelmoselhy on 2/20/2018.
 */

public class DonorsRecyclerViewAdapter extends RecyclerView.Adapter<DonorsRecyclerViewAdapter.MyAssociationViewHolder> {
    private static int NUM_OF_ITEMS;
    private static Context mContext;

    public DonorsRecyclerViewAdapter(Context mContext, int NUM_OF_ITEMS) {
        this.NUM_OF_ITEMS = NUM_OF_ITEMS;
        this.mContext = mContext;
    }

    @Override
    public MyAssociationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.donors_recycler_view_item,parent,false);
        MyAssociationViewHolder myAssociationViewHolder = new MyAssociationViewHolder(v);
        return myAssociationViewHolder;
    }

    @Override
    public void onBindViewHolder(MyAssociationViewHolder holder, int position) {
        setScaleAnimation(holder.itemView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext,DonarDetail.class));
            }
        });
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

    class MyAssociationViewHolder extends RecyclerView.ViewHolder
    {
        public MyAssociationViewHolder(View itemView) {
            super(itemView);
        }
    }
}
