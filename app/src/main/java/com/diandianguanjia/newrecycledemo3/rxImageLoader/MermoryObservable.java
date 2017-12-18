package com.diandianguanjia.newrecycledemo3.rxImageLoader;

/**
 * Created by an on 2017/8/18.
 */

public class MermoryObservable extends CachObservable {
    @Override
    public Image getDataFromCache(String url) {
        return null;
    }

    @Override
    public void putDataToCache(Image image) {

    }
}
