package com.diandianguanjia.newrecycledemo3.activity;

import android.app.DownloadManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.diandianguanjia.newrecycledemo3.R;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

/**
 * Created by an on 2017/8/16.
 */

public class OkhttpActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.okhttp_get)
    Button btnGet;
    @BindView(R.id.okhttp_post)
    Button btnPOST;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_okhttp);

        ButterKnife.bind(this);


        btnGet.setOnClickListener(this);
        btnPOST.setOnClickListener(this);

    }


    private static final String TAG = "OkhttpActivity";
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.okhttp_get:

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Log.i(TAG, "-------onClick: -----"+getData("http://weixin.dd1760.com/DDHK/api/ad/getlist"));
                    }
                }).start();
                break;//
            case R.id.okhttp_post:

                postDataJson("http://weixin.dd1760.com/DDHK/index.php/jc/hotel/details","45");
                /*new Thread(new Runnable() {
                    @Override
                    public void run() {

                    }
                }).start();*/
                        //postDatas("http://weixin.dd1760.com/DDHK/api/ad/getlist","");
                        //Log.i(TAG, "-------onClick: -----"+ postDatas("http://weixin.dd1760.com/DDHK/api/ad/getlist",""));
                        //Log.i(TAG, "-------onClick: -----"+getData("http://weixin.dd1760.com/DDHK/api/ad/getlist"));



                break;
        }
    }


    /**
     * 添加参数
     * @param url
     * @param hotelid
     * @return
     */
    public String postDataJson(String url,String hotelid) {//http://weixin.dd1760.com/DDHK/index.php/jc/hotel/details

        OkHttpClient client=new OkHttpClient();
        FormBody body = new FormBody.Builder()
                .add("hotelid", hotelid)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {

                Log.i(TAG, "----onResponse:"+ response.body().string());


            }
        });


        return "";
    }


    private String postDatas(String url,String json) {
        MediaType JSON=MediaType.parse("application/json; charset=utf-8");

        OkHttpClient client=new OkHttpClient();


            RequestBody body = RequestBody.create(JSON, json);
            final Request request = new Request.Builder().patch(body)
                    .url(url)
                    .build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {

                    Log.i(TAG, "----onResponse:"+ response.body().string());



                }
            });

       /* Response response = client.newCall(request).execute();
        return response.body().string();
        }catch (Exception e) {
            e.printStackTrace();
        }*/
        return "";

    }

    public String getData(String url)  {

        OkHttpClient client=new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            Response response = null;
        try {
                response = client.newCall(request).execute();
                return response.body().string();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return "";
    }
}
