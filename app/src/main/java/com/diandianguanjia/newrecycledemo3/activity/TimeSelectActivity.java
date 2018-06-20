package com.diandianguanjia.newrecycledemo3.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.diandianguanjia.newrecycledemo3.R;
import com.diandianguanjia.newrecycledemo3.utils.DataTimeUtils;

import org.w3c.dom.Text;

import java.util.Date;

/**
 * Created by an on 2018/6/1.
 */

public class TimeSelectActivity extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_time_select);

        TextView textView= (TextView) findViewById(R.id.time_select);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


             /*   //时间选择器
                TimePickerView pvTime = new TimePickerBuilder(TimeSelectActivity.this, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        Toast.makeText(TimeSelectActivity.this, getTime(date), Toast.LENGTH_SHORT).show();




                    }
                }).build();*/

            }
        });


    }

    private String getTime(Date date) {

        String dateToString = DataTimeUtils.dateToString(date, "yyyy-MM-dd HH:mm:ss");

        Log.d(TAG,"----------"+dateToString);

        return dateToString;


    }

    private static final String TAG = "TimeSelectActivity";
}
