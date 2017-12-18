package com.diandianguanjia.newrecycledemo3.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.diandianguanjia.newrecycledemo3.R;
import com.diandianguanjia.newrecycledemo3.mode.Couse;
import com.diandianguanjia.newrecycledemo3.mode.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.functions.Action1;

/**
 * Created by an on 2017/8/16.
 */

public class OkReRxJavaActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.okhttp)
    TextView tvOkhttp;
    @BindView(R.id.retrofit)
    TextView tvRetrofit;
    @BindView(R.id.rxjava)
    TextView tvRxjava;
    private RxBus rxBus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_okrerxuse);

        ButterKnife.bind(this);

        tvOkhttp.setOnClickListener(this);
        tvRetrofit.setOnClickListener(this);
        tvRxjava.setOnClickListener(this);
        rxBus = RxBus.getInstance();

        rxBus.toObservableSticky(Couse.class).subscribe(new Action1<Couse>() {
            @Override
            public void call(Couse couse) {
                Log.i(TAG, "姓名:---------- "+couse.getName());
                Toast.makeText(OkReRxJavaActivity.this, "我是"+couse.getId()+couse.getName(), Toast.LENGTH_SHORT).show();


                tvRxjava.setText(couse.getName());
            }
        });


        rxBus.toObservableSticky(User.class).subscribe(new Action1<User>() {
            @Override
            public void call(User couse) {
                Log.i(TAG, "酒店:---------- "+couse.getHotel_name());
                Toast.makeText(OkReRxJavaActivity.this, "我是"+couse.getHotel_name(), Toast.LENGTH_SHORT).show();


                tvRxjava.setText(couse.getHotel_name());
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        rxBus.removeAllStickyEvents();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.okhttp:

               Intent intent1=new Intent(OkReRxJavaActivity.this,OkhttpActivity.class);
                startActivity(intent1);

                break;
            case R.id.retrofit:
                Intent intent2=new Intent(OkReRxJavaActivity.this,RetrofitActivity.class);
                startActivity(intent2);

                break;
            case R.id.rxjava:
                Intent intent3=new Intent(OkReRxJavaActivity.this,RxJavaActivity.class);


                startActivity(intent3);
                break;

        }

    }

    private static final String TAG = "OkReRxJavaActivity";
    public void get(){
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onNext(String s) {
                Log.d(TAG, "Item: " + s);
            }

            @Override
            public void onCompleted() {
                Log.d(TAG, "Completed!");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "Error!");
            }
        };
    }
}
