package com.diandianguanjia.newrecycledemo3.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.diandianguanjia.newrecycledemo3.R;
import com.diandianguanjia.newrecycledemo3.adapter.RecycleViewAdapter;

/**
 * Created by an on 2017/8/1.
 */

public class CollapsingToolBarActivity extends AppCompatActivity{

    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private ImageView imgCollasping;
    private CollapsingToolbarLayout collapsingToolbarlayout;
    private AppBarLayout appBBar;
    private CoordinatorLayout coordiation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_collapsing_toolbar);

        coordiation= (CoordinatorLayout) findViewById(R.id.coordiation);
        appBBar= (AppBarLayout) findViewById(R.id.appBBar);
        collapsingToolbarlayout= (CollapsingToolbarLayout) findViewById(R.id.CollapsingToolbarlayout);
        imgCollasping= (ImageView) findViewById(R.id.imgCollasping);

        toolbar= (Toolbar) findViewById(R.id.toolBar);
        recyclerView= (RecyclerView) findViewById(R.id.recycle);


        setSupportActionBar(toolbar);
        collapsingToolbarlayout.setTitle("哆啦A梦");
        collapsingToolbarlayout.setCollapsedTitleTextColor(Color.RED);
        collapsingToolbarlayout.setBackgroundColor(Color.GRAY);

        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new RecycleViewAdapter(CollapsingToolBarActivity.this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar, menu); //解析menu布局文件到menu
        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.toolbar_r_img:
                Log.e("Test---->","点击了右边图标");
                break;
            case R.id.toolbar_r_1:
                Log.e("Test---->","点击了弹出菜单1");
                break;
            case R.id.toolbar_r_2:
                Log.e("Test---->","点击了弹出菜单2");
                break;
            case R.id.toolbar_r_3:
                Log.e("Test---->","点击了弹出菜单3");
                break;
        }
        return true;    //返回为true
    }
}
