package com.diandianguanjia.newrecycledemo3.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.diandianguanjia.newrecycledemo3.R;
import com.diandianguanjia.newrecycledemo3.activity.RecycleListViewActivity;

import java.util.List;

/**
 * Created by an on 2017/7/11.
 */

public class RecycleViewMyAdapter extends RecyclerView.Adapter<RecycleViewMyAdapter.ViewHolder> {

    private List<String> mListDatas;

    private Context mContext;

    private static final String TAG = "RecycleViewMyAdapter";


    private List<Integer> mHeights;
    private String style;

    /**
     * 通过接口来实现点击、长按等事件
     */
    private OnItenClickListener mOnItenClickListener;

   public interface OnItenClickListener {
       void  onItenClick(View view, int position);
       void onItenLonfClick(View view, int position);
    }

    public void setOnItenClickListener(OnItenClickListener mOnItenClickListener){
        this.mOnItenClickListener=mOnItenClickListener;
    }

    public RecycleViewMyAdapter(String style,List<Integer> mHeights, List<String> mListData, RecycleListViewActivity mainActivity) {

        this.mHeights=mHeights;
        this.style=style;
        this.mContext=mainActivity;
        this.mListDatas=mListData;

    }

    public void removeData(int position){
        mListDatas.remove(position);
        notifyItemRemoved(position);

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recycle, parent,false);
        ViewHolder holder=new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.tv.setText(mListDatas.get(position));

        if (style.equals("pubu")) {
            ViewGroup.LayoutParams lp = holder.tv.getLayoutParams();
            lp.height = mHeights.get(position);
            holder.tv.setLayoutParams(lp);
        }

       if (mOnItenClickListener!=null){
           holder.tv.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   int pos=holder.getLayoutPosition();
                   Toast.makeText(mContext, ""+pos, Toast.LENGTH_SHORT).show();
                   Log.d(TAG, "onClick: "+pos);

                   mOnItenClickListener.onItenClick(holder.tv,pos);

               }
           });


           holder.tv.setOnLongClickListener(new View.OnLongClickListener() {
               @Override
               public boolean onLongClick(View v) {
                   int pos=holder.getLayoutPosition();
                   Toast.makeText(mContext, ""+pos, Toast.LENGTH_SHORT).show();
                   mOnItenClickListener.onItenLonfClick(holder.tv,pos);
                   return false;
               }
           });


       }
    }

    @Override
    public int getItemCount() {
        return mListDatas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tv;
       // private ImageView lin;
        public ViewHolder(View itemView) {
            super(itemView);

            tv= (TextView) itemView.findViewById(R.id.item_tv);
            //lin= (ImageView) itemView.findViewById(R.id.img);

        }
    }
}
