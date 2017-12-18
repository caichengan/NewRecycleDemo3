package com.diandianguanjia.newrecycledemo3.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.diandianguanjia.newrecycledemo3.R;
import com.diandianguanjia.newrecycledemo3.adapter.FragmentAdapter;
import com.diandianguanjia.newrecycledemo3.fragment.ListsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by an on 2017/7/31.
 */

public class NavTabLayoutViewPagerActivity extends AppCompatActivity{

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ViewPager viewPager;
    private TabLayout tabs;
    private Toolbar toolbar;
    private AppBarLayout appBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_nav_tab_viewpager);

        initView();

    }

    private void initView() {

        appBar= (AppBarLayout) findViewById(R.id.appBBar);
        toolbar= (Toolbar) findViewById(R.id.toolBar);
        tabs= (TabLayout) findViewById(R.id.tabs);
        viewPager= (ViewPager) findViewById(R.id.viewpager);
        drawerLayout= (DrawerLayout) findViewById(R.id.dl_main_drawer);
        navigationView= (NavigationView) findViewById(R.id.navMain);



        toolbar.setTitle("nav_tab-Viewpager");
        setSupportActionBar(toolbar);


        ActionBar sb = getSupportActionBar();
        sb.setHomeAsUpIndicator(R.mipmap.ic_launcher);
        sb.setDisplayHomeAsUpEnabled(true);
        if (navigationView!=null){
            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    item.setCheckable(true);
                    switch (item.getItemId()){
                        case R.id.nav_home:
                            break;
                        case R.id.nav_message:
                            Intent intentMessage=new Intent(NavTabLayoutViewPagerActivity.this,MessageActivity.class);
                            startActivity(intentMessage);
                            break;
                        case R.id.nav_discussion:
                            Intent intentdis=new Intent(NavTabLayoutViewPagerActivity.this,DistanceActivity.class);
                            startActivity(intentdis);
                            break;
                        case R.id.nav_about:
                            break;
                        case R.id.nav_setting:
                            Intent intentSet=new Intent(NavTabLayoutViewPagerActivity.this,SettingActivity.class);
                            startActivity(intentSet);
                            break;
                        case R.id.nav_music:
                            break;
                    }
                    String title = item.getTitle().toString();
                    Toast.makeText(NavTabLayoutViewPagerActivity.this, "--"+title, Toast.LENGTH_SHORT).show();
                    //关闭导航栏
                    drawerLayout.closeDrawers();
                    return true;
                }
            });
        }

        initViewPager();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
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
}
