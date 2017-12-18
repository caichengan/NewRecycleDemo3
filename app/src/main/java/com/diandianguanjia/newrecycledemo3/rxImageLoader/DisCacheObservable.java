package com.diandianguanjia.newrecycledemo3.rxImageLoader;

import android.content.Context;

import java.io.File;

/**
 * Created by an on 2017/8/18.
 */

public class DisCacheObservable extends CachObservable {

    private Context mContext;

    public DisCacheObservable(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public Image getDataFromCache(String url) {
        return null;
    }

    @Override
    public void putDataToCache(Image image) {

    }


    /**
     *
     * 初始化DiskLrucache
     *
     */
    private void initDisLeuCache(){

    }
}
