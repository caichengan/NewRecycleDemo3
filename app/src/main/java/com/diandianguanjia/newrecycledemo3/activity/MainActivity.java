package com.diandianguanjia.newrecycledemo3.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.diandianguanjia.newrecycledemo3.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView recycleListView;
    private TextView recycleGridView;
    private TextView recyclePuBu;
    private TextView recycleTabLayout;
    private TextView recycleNavigation;
    private TextView layoutCoordinatorLayout;
    private TextView collapsingToolbarlayout;
    private TextView behaviorlayout;
    private TextView realmlayout;
    private TextView recycleViewMulite;
    private TextView banner;
    private TextView mDataTimer;
    private TextView layoutCchuanke;
    private TextView mDataTimerAddress;
    private TextView mMenuPopup;
    private TextView mTimeSelect;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        recycleListView= (TextView) findViewById(R.id.recycleListView);
        recycleGridView= (TextView) findViewById(R.id.recycleGridView);
        recyclePuBu= (TextView) findViewById(R.id.recyclePuBu);
        recycleTabLayout= (TextView) findViewById(R.id.recycleTabLayout);
        recycleNavigation= (TextView) findViewById(R.id.recycleNavigation);
        layoutCoordinatorLayout= (TextView) findViewById(R.id.layoutCoordinatorLayout);
        collapsingToolbarlayout= (TextView) findViewById(R.id.CollapsingToolbarlayout);
        behaviorlayout= (TextView) findViewById(R.id.behaviorlayout);
        realmlayout= (TextView) findViewById(R.id.realmlayout);
        recycleViewMulite= (TextView) findViewById(R.id.recycleViewMulite);
        banner= (TextView) findViewById(R.id.Banner);
        mDataTimer= (TextView) findViewById(R.id.mDataTimer);
        layoutCchuanke= (TextView) findViewById(R.id.layoutCchuanke);
        mDataTimerAddress= (TextView) findViewById(R.id.mDataTimerAddress);
        mMenuPopup= (TextView) findViewById(R.id.mMenuPopup);
        mTimeSelect= (TextView) findViewById(R.id.mTimeSelect);

        recycleViewMulite.setOnClickListener(this);
        recycleListView.setOnClickListener(this);
        recycleGridView.setOnClickListener(this);
        recyclePuBu.setOnClickListener(this);
        recycleTabLayout.setOnClickListener(this);
        recycleNavigation.setOnClickListener(this);
        layoutCoordinatorLayout.setOnClickListener(this);
        collapsingToolbarlayout.setOnClickListener(this);
        behaviorlayout.setOnClickListener(this);
        realmlayout.setOnClickListener(this);
        banner.setOnClickListener(this);
        mDataTimer.setOnClickListener(this);
        layoutCchuanke.setOnClickListener(this);
        mDataTimerAddress.setOnClickListener(this);
        mMenuPopup.setOnClickListener(this);
        mTimeSelect.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.recycleListView:

                Intent intent1=new Intent(this,RecycleListViewActivity.class);
                intent1.putExtra("style","listview");
                startActivity(intent1);

                break;
            case R.id.recycleGridView:
                Intent intent2=new Intent(this,RecycleListViewActivity.class);
                intent2.putExtra("style","gridview");
                startActivity(intent2);
                break;
            case R.id.recycleViewMulite:
                Intent intent21=new Intent(this,RecycleListViewActivity.class);
                intent21.putExtra("style","mulite");
                startActivity(intent21);
                break;
            case R.id.recyclePuBu:

                Intent intent3=new Intent(this,RecycleListViewActivity.class);
                intent3.putExtra("style","pubu");
                startActivity(intent3);
                break;
            case R.id.recycleTabLayout:

                Intent intent4=new Intent(this,TabLayoutViewPagerActivity.class);
                intent4.putExtra("style","pubu");
                startActivity(intent4);
                break;
            case R.id.recycleNavigation:

                Intent intent5=new Intent(this,NavTabLayoutViewPagerActivity.class);
                intent5.putExtra("style","pubu");
                startActivity(intent5);
                break;
            case R.id.layoutCoordinatorLayout:

                Intent intent6=new Intent(this,CoordinatorViewPagerActivity.class);
                intent6.putExtra("style","pubu");
                startActivity(intent6);
                break;

            case R.id.layoutCchuanke:

                Intent intent61=new Intent(this,CoordinatorChuankeActivity.class);
                intent61.putExtra("style","pubu");
                startActivity(intent61);
                break;
            case R.id.CollapsingToolbarlayout:

                Intent intent7=new Intent(this,CollapsingToolBarActivity.class);
                intent7.putExtra("style","pubu");
                startActivity(intent7);
                break;
            case R.id.behaviorlayout:

                Intent intent8=new Intent(this,CollapsingBehaviorActivity.class);
                intent8.putExtra("style","pubu");
                startActivity(intent8);
                break;

            case R.id.realmlayout:

                Intent intent9=new Intent(this,RealmActivity.class);
                startActivity(intent9);
                break;
            case R.id.Banner:

                Intent intent10=new Intent(this,BannerActivity.class);
                startActivity(intent10);
                break;

            case R.id.mDataTimer:

                Intent intent11=new Intent(this,TimeDataActivity.class);
                startActivity(intent11);
                break;
            case R.id.mDataTimerAddress:

                Intent intent12=new Intent(this,TimeDataAddressActivity.class);
                startActivity(intent12);
                break;
            case R.id.mMenuPopup:
                Intent intent13=new Intent(this,MenuPopupActivity.class);
                startActivity(intent13);
                break;
            case R.id.mTimeSelect:
                Intent intent14=new Intent(this,TimeSelectActivity.class);
                startActivity(intent14);
                break;
        }

    }
}
