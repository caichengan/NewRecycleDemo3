package com.diandianguanjia.newrecycledemo3.rxImageLoader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by an on 2017/8/18.
 */

public class NetWorkObservable extends CachObservable {
    @Override
    public Image getDataFromCache(String url) {

        Bitmap bitmap=downBitmap(url);

        if (bitmap!=null){

            return new Image(url,bitmap);
        }

        return null;
    }

    @Override
    public void putDataToCache(Image image) {

    }

    private Bitmap downBitmap(String url){

        Bitmap bitmap=null;
        InputStream inputStream=null;

        try {
            URLConnection cn= new URL(url).openConnection();
            inputStream=cn.getInputStream();
            bitmap= BitmapFactory.decodeStream(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        return bitmap;

    }
}
