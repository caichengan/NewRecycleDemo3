package com.diandianguanjia.newrecycledemo3.app;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by an on 2017/8/11.
 */

public class Appication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();


       /* Realm.init(getApplicationContext());
        //自定义配置
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name("myl.realm")
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm.setDefaultConfiguration(configuration);*/
    }
}
