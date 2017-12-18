package com.diandianguanjia.newrecycledemo3.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.diandianguanjia.newrecycledemo3.R;
import com.diandianguanjia.newrecycledemo3.mode.RefreshBean;
import com.diandianguanjia.newrecycledemo3.view.ImageUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 丁瑞 on 2017/1/3.
 * 首页热议
 */
public class TypeHistoryAdapter extends RecyclerView.Adapter<TypeHistoryAdapter.TypeHistoryHolder> {

    private Context mContext;

    private List<RefreshBean.DataBean> mHomehopspot;

    private LayoutInflater inflater;


    public TypeHistoryAdapter(Context mContext, List<RefreshBean.DataBean> mHomeCategory) {
        this.mContext = mContext;
        this.mHomehopspot = mHomeCategory;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public TypeHistoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TypeHistoryHolder(inflater.inflate(R.layout.item_raiders, parent, false));
    }

    @Override
    public void onBindViewHolder(TypeHistoryHolder holder, int position) {
        RefreshBean.DataBean contentBean = mHomehopspot.get(position);
        ImageUtils.load(mContext, contentBean.getCpThree().getImgUrl(), holder.homeReadPivIv);
        holder.homeReadTitle.setText("#" + contentBean.getTitle());
    }

    @Override
    public int getItemCount() {
        return mHomehopspot == null ? 0 : mHomehopspot.size();
    }

    public class TypeHistoryHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.home_read_piv_iv)
        ImageView homeReadPivIv;
        @BindView(R.id.home_read_title)
        TextView homeReadTitle;


        public TypeHistoryHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


}
