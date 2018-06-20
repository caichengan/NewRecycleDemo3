package com.diandianguanjia.newrecycledemo3.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.diandianguanjia.newrecycledemo3.R;
import com.diandianguanjia.newrecycledemo3.activity.TimeDataAddressActivity;
import com.diandianguanjia.newrecycledemo3.mode.ProvinceList;

import java.util.ArrayList;

/**
 * Created by an on 2018/4/11.
 */

public class ProvinceAdapter extends BaseAdapter {

    private ArrayList<ProvinceList> mProvinceList=new ArrayList<>();
    private Context mContext;

    public ProvinceAdapter(Context timeDataAddressActivity) {
        this.mContext=timeDataAddressActivity;

    }

    public void setList(ArrayList<ProvinceList> mProvinceList){

        this.mProvinceList=mProvinceList;
    }

    @Override
    public int getCount() {
        return mProvinceList.size();
    }

    @Override
    public Object getItem(int position) {


        return mProvinceList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyViewHolder holder;
        if (convertView==null){
            holder=new MyViewHolder();
            convertView=View.inflate(mContext,R.layout.item_tv,null);
            holder.tvview= (TextView) convertView.findViewById(R.id.tv);

            convertView.setTag(holder);

        }else{

            holder = (MyViewHolder) convertView.getTag();

        }


        ProvinceList provinceList = mProvinceList.get(position);


        String schoolName = provinceList.getProvinceName();

        holder.tvview.setText(schoolName);
        return convertView;
    }

    class MyViewHolder {
        TextView tvview;

    }
}
