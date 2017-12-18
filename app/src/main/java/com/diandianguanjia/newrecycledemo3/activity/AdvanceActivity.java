package com.diandianguanjia.newrecycledemo3.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.diandianguanjia.newrecycledemo3.R;

/**
 * Created by an on 2017/8/1.
 */

public class AdvanceActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView two;
    private TextView three;
    private TextView four;
    private TextView fire;
    private TextView six;
    private TextView servel;
    private TextView eight;
    private TextView dialog;
    private TextView okrerxUser;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_advance);

        two= (TextView) findViewById(R.id.two);
        three = (TextView) findViewById(R.id.three);
        four= (TextView) findViewById(R.id.four);
        fire = (TextView) findViewById(R.id.fire);
        six  = (TextView) findViewById(R.id.six);
        servel= (TextView) findViewById(R.id.servel);
        eight  = (TextView) findViewById(R.id.eight);
        dialog  = (TextView) findViewById(R.id.dialog);
        okrerxUser  = (TextView) findViewById(R.id.okrerxUser);

        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        fire.setOnClickListener(this);
        six.setOnClickListener(this);
        servel.setOnClickListener(this);
        eight.setOnClickListener(this);
        dialog.setOnClickListener(this);
        okrerxUser.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Intent intent=null;
        switch(v.getId()){

            case R.id.two:
                intent=new Intent(AdvanceActivity.this,MainActivity.class);
                break;
            case R.id.three:
                intent=new Intent(AdvanceActivity.this,ViewActivity.class);
                break;
            case R.id.four:
                intent=new Intent(AdvanceActivity.this,MainActivity.class);
                break;
            case R.id.fire:
                intent=new Intent(AdvanceActivity.this,MainActivity.class);
                break;
            case R.id.six:
                intent=new Intent(AdvanceActivity.this,MainActivity.class);
                break;
            case R.id.servel:
                intent=new Intent(AdvanceActivity.this,MainActivity.class);
                break;
            case R.id.eight:
                intent=new Intent(AdvanceActivity.this,MainActivity.class);
                break;

            case R.id.dialog:
                intent=new Intent(AdvanceActivity.this,DialogActivity.class);
                break;//okrerxUser
            case R.id.okrerxUser:
                intent=new Intent(AdvanceActivity.this,OkReRxJavaActivity.class);
                break;

        }


        startActivity(intent);


    }
}
