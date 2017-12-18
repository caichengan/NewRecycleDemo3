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
import android.widget.ImageView;

import com.diandianguanjia.newrecycledemo3.R;
import com.diandianguanjia.newrecycledemo3.adapter.RecycleViewAdapter;

/**
 * Created by an on 2017/8/1.
 */

public class CollapsingBehaviorActivity extends AppCompatActivity{

    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private ImageView imgCollasping;
    private CollapsingToolbarLayout collapsingToolbarlayout;
    private AppBarLayout appBBar;
    private CoordinatorLayout coordiation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_collapsing_behavior);

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

        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new RecycleViewAdapter(CollapsingBehaviorActivity.this));
    }
}
