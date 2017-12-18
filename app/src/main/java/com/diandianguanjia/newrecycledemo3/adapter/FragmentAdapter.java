package com.diandianguanjia.newrecycledemo3.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by an on 2017/7/31.
 */

public class FragmentAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragments;
    private List<String> titles;

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }



    public FragmentAdapter(FragmentManager supportFragmentManager, List<Fragment> fragments, List<String> titles) {
        super(supportFragmentManager);
        this.fragments=fragments;
        this.titles=titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);

    }
}
