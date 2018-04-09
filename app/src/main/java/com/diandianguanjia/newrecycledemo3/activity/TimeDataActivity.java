package com.diandianguanjia.newrecycledemo3.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.codbking.widget.DatePickDialog;
import com.codbking.widget.OnSureLisener;
import com.codbking.widget.bean.DateType;
import com.diandianguanjia.newrecycledemo3.R;

import java.util.Date;

/**
 * Created by an on 2017/12/18.
 */


//https://github.com/caichengan/PickTime   参考网址日期选择控件
public class TimeDataActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_time_data);
        TextView tvTimeSelect1= (TextView) findViewById(R.id.time_select1);
        TextView tvTimeSelect2= (TextView) findViewById(R.id.time_select2);
        TextView tvTimeSelect3= (TextView) findViewById(R.id.time_select3);
        TextView tvTimeSelect4= (TextView) findViewById(R.id.time_select4);
        TextView tvTimeSelect5= (TextView) findViewById(R.id.time_select5);

        tvTimeSelect1.setOnClickListener(this);
        tvTimeSelect2.setOnClickListener(this);
        tvTimeSelect3.setOnClickListener(this);
        tvTimeSelect4.setOnClickListener(this);
        tvTimeSelect5.setOnClickListener(this);





    }

    private void initDataSelect(int i) {



        DatePickDialog dialog = new DatePickDialog(TimeDataActivity.this);
        //设置上下年分限制
        dialog.setYearLimt(5);

        //设置标题
        dialog.setTitle("选择时间");


        switch (i){
            case 1:
                //设置类型
                dialog.setType(DateType.TYPE_ALL);
                break;
            case 2:
//设置类型
                dialog.setType(DateType.TYPE_YMDHM);
                break;
            case 3:
//设置类型
                dialog.setType(DateType.TYPE_YMDH);
                break;
            case 4:
//设置类型
                dialog.setType(DateType.TYPE_YMD);
                break;
            case 5:
//设置类型
                dialog.setType(DateType.TYPE_HM);
                break;
        }



        //设置消息体的显示格式，日期格式
        dialog.setMessageFormat("yyyy-MM-dd HH:mm");
        //设置选择回调
        dialog.setOnChangeLisener(null);
        //设置点击确定按钮回调
        dialog.setOnSureLisener(new OnSureLisener() {
            @Override
            public void onSure(Date date) {

                Log.i(TAG, "onSure: "+date.toString());
            }
        });
        dialog.show();

    }


    private static final String TAG = "TimeDataActivity";

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.time_select1:
                initDataSelect(1);
                break;
            case R.id.time_select2:
                initDataSelect(2);
                break;
            case R.id.time_select3:
                initDataSelect(3);
                break;
            case R.id.time_select4:
                initDataSelect(4);
                break;
            case R.id.time_select5:
                initDataSelect(5);
                break;

        }
    }
}
