package com.diandianguanjia.newrecycledemo3.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.diandianguanjia.newrecycledemo3.R;
import com.diandianguanjia.newrecycledemo3.adapter.FragmentAdapter;
import com.diandianguanjia.newrecycledemo3.fragment.ListsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by an on 2017/7/31.
 */

public class CoordinatorViewPagerActivity extends AppCompatActivity{

    private ViewPager viewPager;
    private TabLayout tabs;
    private Toolbar toolbar;
    private AppBarLayout appBar;
    private CoordinatorLayout coordiation;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cooridator_viewpager);

        initView();

    }

    private void initView() {

        coordiation= (CoordinatorLayout) findViewById(R.id.coordiation);
        appBar= (AppBarLayout) findViewById(R.id.appBBar);
        toolbar= (Toolbar) findViewById(R.id.toolBar);
        tabs= (TabLayout) findViewById(R.id.tabs);
        viewPager= (ViewPager) findViewById(R.id.viewpager);

        toolbar.setTitle("TabLayout-Viewpager");
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);



        initViewPager();

    }

    private void initViewPager() {

        List<String> titles=new ArrayList<>();
        titles.add("精选");
        titles.add("精选");
        titles.add("精选");
        titles.add("精选");
        titles.add("精选");
        titles.add("精选");


        for (int i = 0; i < titles.size(); i++) {
            tabs.addTab(tabs.newTab().setText(titles.get(i)));
        }

        List<Fragment> fragments=new ArrayList<>();
        for (int i = 0; i < titles.size(); i++) {
            fragments.add(new ListsFragment(i));
        }

        FragmentAdapter fragmentPagerAdapter=new FragmentAdapter(getSupportFragmentManager(),fragments,titles);


        //给viewpager设置适配器
        viewPager.setAdapter(fragmentPagerAdapter);
        //将viewpager和Tablayout关联起来
        tabs.setupWithViewPager(viewPager);
        tabs.setTabTextColors(Color.BLACK,Color.RED);

        //给tabLayout设置适配器
        tabs.setTabsFromPagerAdapter(fragmentPagerAdapter);

    }

    public void check(View view){
        Snackbar.make(view,"点击成功",Snackbar.LENGTH_SHORT).show();
    }
}
