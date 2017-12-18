package com.diandianguanjia.newrecycledemo3.rxImageLoader;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;

/**
 * Created by an on 2017/8/18.
 */

public class Image {
    private String url;
    private Bitmap bitmap;

    public Image(String url, Bitmap bitmap) {
        this.url=url;
        this.bitmap=bitmap;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }


}
