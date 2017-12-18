package com.diandianguanjia.newrecycledemo3.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.diandianguanjia.newrecycledemo3.R;
import com.diandianguanjia.newrecycledemo3.mode.Realmzz;
import com.diandianguanjia.newrecycledemo3.view.RealmHelper;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by an on 2017/8/10.
 */

public class RealmActivity extends AppCompatActivity{

    private RealmHelper realmHelper;
    private Realm myRealm;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_realm);

       TextView tvRealm= (TextView) findViewById(R.id.realmhelper);


       //initDatas();
       initDatas2();

        tvRealm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<Realmzz> realmzzs = queryAll();
                int size = realmzzs.size();
                String name = realmzzs.get(0).getName();
                Log.i(TAG, "---onClick: "+size+"--"+name);


            }
        });

    }

    private List<Realmzz> queryAll() {
        RealmResults<Realmzz> list=myRealm.where(Realmzz.class).findAll();



        return myRealm.copyFromRealm(list);
    }

    private static final String TAG = "RealmActivity";

    private void initDatas() {

        myRealm = Realm.getDefaultInstance();
        myRealm.beginTransaction();

            Realmzz beam = myRealm.createObject(Realmzz.class);
            beam.setId("3");
            beam.setImgUrl("");
            beam.setName("暗黑无界"+10);
            beam.setPrice("$40");

        myRealm.commitTransaction();
    }

    private void initDatas2() {

        myRealm = Realm.getDefaultInstance();

            Realmzz beam =new Realmzz();
            beam.setImgUrl("");
            beam.setName("暗黑无界"+0);
            beam.setPrice("$40");


        myRealm.beginTransaction();

        myRealm.commitTransaction();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (myRealm!=null){

            if (myRealm.isClosed()){
                myRealm.close();
            }
            myRealm=null;
        }

    }
}
