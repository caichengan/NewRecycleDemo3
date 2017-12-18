package com.diandianguanjia.newrecycledemo3.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.LoginFilter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.diandianguanjia.newrecycledemo3.R;
import com.diandianguanjia.newrecycledemo3.mode.Result;
import com.diandianguanjia.newrecycledemo3.mode.User;
import com.diandianguanjia.newrecycledemo3.service.RetrofitService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.orhanobut.logger.AndroidLogAdapter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.rx.RxObservableFactory;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by an on 2017/8/16.
 */

public class RetrofitActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.btnGet)
    Button btnGet;
    @BindView(R.id.btnPost)
    Button btnPost;
    @BindView(R.id.btnGetTWO)
    Button btnGetTWO;
    @BindView(R.id.btnRxGetTWO)
    Button btnRxGetTWO;

    RetrofitService service;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_retrofit);

        ButterKnife.bind(this);

        com.orhanobut.logger.Logger.addLogAdapter(new AndroidLogAdapter());
        //Logger.addLogAdapter(new AndroidLogAdapter());
        btnGet.setOnClickListener(this);
        btnPost.setOnClickListener(this);
        btnGetTWO.setOnClickListener(this);
        btnRxGetTWO.setOnClickListener(this);


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://weixin.dd1760.com/DDHK/index.php/jc/hotel/details/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

         service=retrofit.create(RetrofitService.class);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnGet:
                getDataRetrofit();
                //getMapRetrofit();


                break;

            case R.id.btnPost:

                //postUserData();

                postHotelid();

                break;
            case R.id.btnGetTWO:

                getTWOData();

                break;
            case R.id.btnRxGetTWO:

                getRxTWOData();

                break;
        }
    }

    private void postHotelid() {

        service.getString2("45").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Result<User>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Result<User> userResult) {

                com.orhanobut.logger.Logger.d(userResult.getData().getHotel_name());
                Toast.makeText(RetrofitActivity.this, ""+userResult.getData().getHotel_name(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    /**
     * rxjava结合retrofit连续调用
     */
    private void getRxTWOData() {

        service.getString("45").flatMap(new Func1<Result<User>, Observable<Result<User>>>() {
            @Override
            public Observable<Result<User>> call(Result<User> userResult) {

                String hotel_name = userResult.getData().getHotel_name();

                Log.i(TAG, "-----call: "+hotel_name);

                return service.getString(userResult.getData().getHotel_id());
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Result<User>>() {
                    @Override
                    public void call(Result<User> userResult) {

                        String hotel_name = userResult.getData().getHotel_name();

                        Log.i(TAG, "--------: "+hotel_name);
                    }
                });

    }


    /**
     * 可以连续访问网络获取数据
     */
    private void getTWOData() {

        service.getString1("45").enqueue(new Callback<Result<User>>() {
            @Override
            public void onResponse(Call<Result<User>> call, Response<Result<User>> response) {

                service.getString1(response.body().getData().getHotel_id()).enqueue(new Callback<Result<User>>() {
                    @Override
                    public void onResponse(Call<Result<User>> call, Response<Result<User>> response) {
                        Log.i(TAG, "onResponse: "+response.body().getData().getHotel_name());

                    }

                    @Override
                    public void onFailure(Call<Result<User>> call, Throwable t) {

                    }
                });


            }

            @Override
            public void onFailure(Call<Result<User>> call, Throwable t) {

            }
        });



    }

    /**
     * post提交用户id和名称保存
     */
    private void postUserData() {

        service.createUser(new User("45","")).subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<User>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(User user) {

            }
        });
    }

    private void getMapRetrofit() {

        Map<String ,String> map=new HashMap<>();
        map.put("id","1");
        map.put("name","zhangsan");

        service.getUserInfoMap(map).subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<User>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(User user) {

                Log.i(TAG, "onNext: "+user.getHotel_name());
            }
        });

    }

    private static final String TAG = "RetrofitActivity";

    /**
     * retrofit的访问网络数据
     */
    private void getDataRetrofit() {




        Observable<Result<User>> observable = service.getString("45");

        observable.subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Result<User>>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "onNext: ---");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Result<User> userResult) {

                com.orhanobut.logger.Logger.json(userResult.getData().toString());


            }

            @Override
            public void onStart() {
                super.onStart();
                Log.i(TAG, "onStart: ");
            }
        });


       /*Call<Result<User>> call = service.getString("45");
        call.enqueue(new Callback<Result<User>>() {
            @Override
            public void onResponse(Call<Result<User>> call, Response<Result<User>> response) {

                String hotel_name = response.body().getData().getHotel_name();
                Log.i(TAG, "onResponse: "+hotel_name);
            }

            @Override
            public void onFailure(Call<Result<User>> call, Throwable t) {

            }
        });*/

      /*   call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.i(TAG, "---onResponse: ");
                User user = response.body();

                String hotel_name = user.getData().getHotel_name();

                Log.i(TAG, "--onResponse: "+hotel_name);


            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });*/


    }
}
