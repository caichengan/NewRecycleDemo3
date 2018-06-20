package com.diandianguanjia.newrecycledemo3.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.diandianguanjia.newrecycledemo3.R;
import com.diandianguanjia.newrecycledemo3.activity.TimeDataAddressActivity;
import com.diandianguanjia.newrecycledemo3.mode.SchoolList;

import java.util.ArrayList;

/**
 * Created by an on 2018/4/11.
 */

public class SchoolAdapter extends BaseAdapter {
    public SchoolAdapter(Context timeDataAddressActivity) {

        this.mCOntext=timeDataAddressActivity;
    }

    private ArrayList<SchoolList> lislistSchool=new ArrayList<>();
    private Context mCOntext;

    @Override
    public int getCount() {
        return lislistSchool.size();
    }

    @Override
    public Object getItem(int position) {


        return lislistSchool.get(position);
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
            convertView=View.inflate(mCOntext,R.layout.item_tv,null);
            holder.tvview= (TextView) convertView.findViewById(R.id.tv);

            convertView.setTag(holder);

        }else{

            holder = (MyViewHolder) convertView.getTag();

        }


        SchoolList schoolList = lislistSchool.get(position);


        String schoolName = schoolList.getSchoolName();

        holder.tvview.setText(schoolName);
        return convertView;
    }

    class MyViewHolder {
        TextView tvview;

    }
    public void setList(ArrayList<SchoolList> lislistSchool) {

        this.lislistSchool=lislistSchool;
    }
}
