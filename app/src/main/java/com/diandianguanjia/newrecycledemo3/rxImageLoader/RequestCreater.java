package com.diandianguanjia.newrecycledemo3.rxImageLoader;

import android.content.Context;

import rx.Observable;

/**
 * Created by an on 2017/8/18.
 */

public class RequestCreater {

    private Context mCOntext;
    private MermoryObservable mermoryObservable;
    private DisCacheObservable disCacheObservable;
    private NetWorkObservable netWorkObservable;

    public RequestCreater() {
        mermoryObservable=new MermoryObservable();
        disCacheObservable=new DisCacheObservable(mCOntext);
        netWorkObservable=new NetWorkObservable();
    }

    public Observable<Image> getImagefromMermory(String url){

        return mermoryObservable.getImage(url);
    }
    public Observable<Image> getImagefromDisCache(String url){

        return disCacheObservable.getImage(url);
    }
    public Observable<Image> getImagefromNetWork(String url){

        return netWorkObservable.getImage(url);
    }

}
