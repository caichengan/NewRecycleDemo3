package com.diandianguanjia.newrecycledemo3.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.diandianguanjia.newrecycledemo3.R;

/**
 * Created by an on 2017/7/31.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    private Context mContext;

    public RecycleViewAdapter(Context mContext){
        this.mContext=mContext;

    }

    public RecycleViewAdapter() {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(mContext, R.layout.item_list_card,null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

       View view= holder.mView;
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(mContext, "这是点击事件", Toast.LENGTH_SHORT).show();
                Toast.makeText(mContext, "这是点击事件"+position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return 20;
    }


    class ViewHolder extends RecyclerView.ViewHolder{

        public  final View mView;
        public ViewHolder(View itemView) {
            super(itemView);
            mView=itemView;
        }
    }
}
