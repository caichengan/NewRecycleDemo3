package com.diandianguanjia.newrecycledemo3.service;

import com.diandianguanjia.newrecycledemo3.mode.Couse;
import com.diandianguanjia.newrecycledemo3.mode.Result;
import com.diandianguanjia.newrecycledemo3.mode.User;

import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;


/**
 * Created by an on 2017/8/17.
 */

public interface RetrofitService {


    @GET("{hotelid}")
    Call<User> getUser(@Path(("hotelid"))String hotelid);

    @GET("{hotelid}")
    Observable<User> getUser1(@Path(("hotelid"))String name);

    @GET("hotelid")
    Call<Result<User>> getString1(@Query("hotelid")String hotelid);

    @GET("hotelid")
    Observable<Result<User>> getString(@Query("hotelid")String hotelid);//Observable<List<Couse>>


    @GET("id")
    Observable<List<Couse>> getNetDatas(@Query("id")String id);//Observable<List<Couse>>

    @GET("user/info")
    Observable<User> getUserInfoMap(@QueryMap Map<String,String> params);


    @POST("hotelid")
    Observable<Result<User>> getString2(@Query("hotelid")String hotelid);

    //表单
    @FormUrlEncoded
    @POST("user/edit")
    Observable<User> getFromString(@Field("name")String name,@Field("pass")String pass);


    @POST("user/new")
    Observable<User> createUser(@Body User user);



}
