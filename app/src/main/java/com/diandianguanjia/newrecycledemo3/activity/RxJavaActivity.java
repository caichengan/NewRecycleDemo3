package com.diandianguanjia.newrecycledemo3.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.diandianguanjia.newrecycledemo3.R;
import com.diandianguanjia.newrecycledemo3.rxImageLoader.Image;
import com.diandianguanjia.newrecycledemo3.rxImageLoader.RequestCreater;
import com.diandianguanjia.newrecycledemo3.mode.Couse;
import com.diandianguanjia.newrecycledemo3.mode.User;
import com.diandianguanjia.newrecycledemo3.rxImageLoader.RxImageLoader;
import com.diandianguanjia.newrecycledemo3.service.RetrofitService;
import com.jakewharton.rxbinding.view.RxView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by an on 2017/8/16.
 */

public class RxJavaActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.rxJava)
    Button rxJava;
    @BindView(R.id.rxJavaName)
    Button rxJavaName;

    @BindView(R.id.rxJavaObservable)
    Button rxJavaObservable;
    @BindView(R.id.rxJavaOneChoose)
    Button rxJavaOneChoose;
    @BindView(R.id.rxJavaShoppingCart)
    Button rxJavaShoppingCart;
    @BindView(R.id.rxJavaBackTime)
    Button rxJavaBackTime;
    @BindView(R.id.BackTime)
    Button BackTime;
    @BindView(R.id.rxJavaBitmap)
    Button rxJavaBitmap;
    @BindView(R.id.rxJavaRxBus)
    Button rxJavaRxBus;

    private Observable<String> observable;
    private Subscriber<String> subscriber;
    private RetrofitService service;
    RequestCreater requestCreater;
    private RxBus rxBus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_rxjava);

        ButterKnife.bind(this);

        rxBus = RxBus.getInstance();

        observable=getObservable();
        subscriber=getSubscribe();

        requestCreater=new RequestCreater();

        //observable.subscribe(observer);
        rxJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //observable.subscribe(subscriber);

                Observable.create(new Observable.OnSubscribe<User>() {
                    @Override
                    public void call(Subscriber<? super User> subscriber) {
                        User user=new User("56","hasdhj");

                        subscriber.onNext(user);
                    }
                }).subscribe(new Observer<User>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(User user) {
                        Log.i(TAG, "----call: "+user.toString());
                    }
                });


            }
        });

        rxJavaName.setOnClickListener(this);
        rxJavaObservable.setOnClickListener(this);
        rxJavaOneChoose.setOnClickListener(this);
        rxJavaShoppingCart.setOnClickListener(this);
        rxJavaBackTime.setOnClickListener(this);
        rxJavaBitmap.setOnClickListener(this);
        BackTime.setOnClickListener(this);
        rxJavaRxBus.setOnClickListener(this);


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://weixin.dd1760.com/DDHK/index.php/jc/hotel/details/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        service = retrofit.create(RetrofitService.class);

        /*RxBus.getInstance().toObserverable(Couse.class).subscribe(new Action1<Couse>() {
            @Override
            public void call(Couse couse) {

                Log.i(TAG, "姓名: "+couse.getName());
                Toast.makeText(RxJavaActivity.this, "我是"+couse.getId()+couse.getName(), Toast.LENGTH_SHORT).show();


                rxJavaRxBus.setText(couse.getName());

            }
        });*/





    }

    public Subscriber<String> getSubscribe(){
        return new Subscriber<String>() {
            @Override
            public void onNext(String s) {
                Log.d(TAG, "Item: " + s);
                Toast.makeText(RxJavaActivity.this, ""+s, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCompleted() {
                Log.d(TAG, "Completed!");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "Error!");
            }
        };
    }



    public Observable<String> getObservable(){

        /**
         * 只能点击一次，之后无效了
         * @return
         */
        /*Observable<String> observable=Observable.just("dhsg","让我飞规划局黄齑淡饭","设备工人房");
        return observable;*/

        /**
         * 也是只能执行一次
         */
        /*String []item={"dhsg","让我飞规划局黄齑淡饭","设备工人房"};
        Observable<String> observable=Observable.from(item);
        return observable;*/


        /**
         * 只能执行一次，且只能返回一个字符串
         */
        Observable<String> observable = Observable.fromCallable(new Callable<String>() {
            @Override
            public String call() throws Exception {

                return "让我飞规划局黄齑淡饭";
            }
        });

        return observable;

        /**
         * 可以连续点击发送
         * @return
         */
        /*return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello");
                subscriber.onNext("Hi");
                subscriber.onNext("Aloha");
                subscriber.onCompleted();
            }
        });*/
    }

    private static final String TAG = "RxJavaActivity";

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.rxJavaName:

                //打印字符
                String [] names={"134","esfer","afw","是否看见","杭州市金融开放环境"};
                Observable.from(names).subscribe(new Action1<String>() {
                    @Override
                    public void call(String name) {


                        Log.i(TAG, "---name-: "+name);
                    }
                });


                break;

            case R.id.rxJavaObservable:

                Observable.just("filePath")
                        .map(new Func1<String, Bitmap>() {
                            @Override
                            public Bitmap call(String filePath) {

                                //map() 方法将参数中的 String 对象转换成一个 Bitmap 对象后返回，
                                // 而在经过 map() 方法后，事件的参数类型也由 String 转为了 Bitmap。
                                //getBitmapFromPath();
                                return null;
                            }
                        }).subscribe(new Action1<Bitmap>() {
                    @Override
                    public void call(Bitmap bitmap) {


                        showBitmap(bitmap);

                    }
                });

                break;

            case R.id.rxJavaOneChoose:


                //注册防止多次点击。一定时间内只能点击一次
                preventUserClick();


                break;
            case R.id.rxJavaShoppingCart:


                //合并本地数据和网络数据
                ShoppingCartClick();


                break;

            case R.id.rxJavaBackTime:


                //倒计时
                clickBackTime();


                break;
            case R.id.rxJavaBitmap:

                rxBus.postSticky(new User("567","九江至"));
                cachJavaBitmap();


                break;//rxJavaRxBus
            case R.id.rxJavaRxBus:


                postRxBusMethod();



                break;//rxJavaRxBus


        }
    }

    /**
     * 使用RxBus进行数据更新
     */
    private void postRxBusMethod() {


        //RxBus.getInstance().post(new Couse("5","我是5号张三"));
        rxBus.postSticky(new Couse("67","我是李思"));

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    /**
     * 实现图片的三级缓存
     */
    private void cachJavaBitmap() {

        Observable.concat(getMermoryData(),getDisData(),getNetData()).first(new Func1<String, Boolean>() {
            @Override
            public Boolean call(String s) {
                return !TextUtils.isEmpty(s);
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {

                Log.i(TAG, "call: "+s);
            }
        });


    }


    public Observable<String> getMermoryData(){
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {


                subscriber.onNext("mer");
                subscriber.onCompleted();

            }
        });
    }

    public Observable<String> getDisData(){
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {

                subscriber.onNext("dis");subscriber.onCompleted();

            }
        });
    }

    public Observable<String> getNetData(){
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {

                subscriber.onNext("net");subscriber.onCompleted();

            }
        });
    }

    /**
     * 倒计时
     * interval 倒计时
     * take 执行多少次
     * map  转换倒计时
     * doOnSubscribe  在执行过程中做点事
     * subscribe  订阅
     */
    private void clickBackTime() {

        Log.i(TAG, "clickBackTime: ");

        final int count=10;
        Observable.interval(0,1,TimeUnit.SECONDS).take(count+1).map(new Func1<Long, Long>() {
            @Override
            public Long call(Long aLong) {
                return count-aLong;
            }
        }).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Action0() {
            @Override
            public void call() {
                 rxJavaBackTime.setClickable(false);
            }
        }).subscribe(new Observer<Long>() {
            @Override
            public void onCompleted() {
                rxJavaBackTime.setText("发送验证码");
                rxJavaBackTime.setClickable(true);
            }

            @Override
            public void onError(Throwable e) {

                e.printStackTrace();
            }

            @Override
            public void onNext(Long aLong) {

                rxJavaBackTime.setText("倒计时："+aLong);

            }
        });


       /* new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                rxJavaBackTime.setText("倒计时: " + millisUntilFinished / 1000);
            }
            public void onFinish() {

                rxJavaBackTime.setText("倒计时:done!");

            }
        }.start();*/




    }


    /**
     * merge 可以将多个Observable的输出合并，就像的单个Observable一样（数据可能会交错）
     * concat 也可以将多个Observable的输出合并，但是concat则不会交错，会按照顺序一直合并（数据不会交错）
     *
     *   合并本地数据和网络数据
     */
    private void ShoppingCartClick() {
        Observable<List<Couse>> localData = getLocalData();
        Observable<List<Couse>> netDatas = getNetDatas();

        /*Observable.concat(localData,netDatas).subscribe(new Subscriber<List<Couse>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<Couse> couses) {
                for (Couse c:couses){
                    Log.i(TAG, "onNext: "+c.getName());
                }
            }
        });*/


        Observable.merge(localData,netDatas).subscribe(new Observer<List<Couse>>() {
            @Override
            public void onCompleted() {
            }
            @Override
            public void onError(Throwable e) {
            }
            @Override
            public void onNext(List<Couse> couses) {
                for (Couse c:couses){
                    Log.i(TAG, "onNext: "+c.getName());
                }
            }
        });

    }

    /**
     * 获取本地数据
     * @return
     */
    public Observable<List<Couse>> getLocalData(){

        List<Couse> mListDatas=new ArrayList<>();
        mListDatas.add(new Couse("商城"));
        mListDatas.add(new Couse("夜店"));
        mListDatas.add(new Couse("店铺"));

        return Observable.just(mListDatas);

    }


    /**
     * 请求网络数据
     * @return
     */
    public Observable<List<Couse>> getNetDatas(){

        return service.getNetDatas("3").subscribeOn(Schedulers.io());

    }


    /**
     * 防止按钮重复点击，如用户注册
     *
     * throttleFirst：允许设置一个时间长度，之后会发送固定时间长度内的第一个事件，而屏蔽其他事件，在间隔时间达到设置时间之后，才可以重新发送第二次事件
     */
    private void preventUserClick() {


        RxView.clicks(rxJavaOneChoose).throttleFirst(1, TimeUnit.SECONDS).subscribe(new Observer<Object>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {

                Log.i(TAG, "onNext: 点击了");

            }
        });


    }

    private void showBitmap(Bitmap bitmap) {


    }
}
