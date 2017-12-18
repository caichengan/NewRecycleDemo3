package com.diandianguanjia.newrecycledemo3.rxImageLoader;

/**
 * Created by an on 2017/8/18.
 */

import android.content.Context;
import android.widget.ImageView;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;

public  class RxImageLoader {


    RequestCreater requestCreater;

    private RxImageLoader() {
        requestCreater=new RequestCreater();
    }

    static RxImageLoader rxSingleTon;
    private String url;

    public static RxImageLoader with(Context mContext){

        if (rxSingleTon==null){

            synchronized (RxImageLoader.class){
                if (rxSingleTon==null){
                    rxSingleTon=new Builder(mContext).builder();
                }
            }
        }

        return rxSingleTon;
    }


    public RxImageLoader load(String url){
        this.url=url;

        return rxSingleTon;
    }

    public void into(ImageView imgview){

        Observable.concat(requestCreater.getImagefromMermory(url),requestCreater.getImagefromDisCache(url),requestCreater.getImagefromNetWork(url))
                .first(new Func1<Image, Boolean>() {
                    @Override
                    public Boolean call(Image image) {
                        return null;
                    }
                }).subscribe(new Observer<Image>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Image image) {

            }
        });

    }

    public static class Builder{
        Context context;

        public Builder(Context context) {
            this.context = context;
        }

        public RxImageLoader builder(){
            return new RxImageLoader();
        }
    }

}