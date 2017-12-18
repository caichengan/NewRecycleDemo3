package com.diandianguanjia.newrecycledemo3.rxImageLoader;


import com.diandianguanjia.newrecycledemo3.rxImageLoader.Image;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by an on 2017/8/18.
 */

public abstract class CachObservable {

    public  Observable<Image> getImage(final String url){
        return Observable.create(new Observable.OnSubscribe<Image>() {
            @Override
            public void call(Subscriber<? super Image> subscriber) {

                if (!subscriber.isUnsubscribed()) {
                    Image image = getDataFromCache(url);
                    subscriber.onNext(image);
                    subscriber.onCompleted();
                }

            }
        });
    };
    public abstract Image getDataFromCache(String url);
    public abstract void putDataToCache(Image image);

}
