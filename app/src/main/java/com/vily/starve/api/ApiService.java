package com.vily.starve.api;



import com.vily.starve.bean.BaseBean;
import com.vily.starve.bean.UserBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 *  * description : 
 *  * Author : Vily
 *  * Date : 2019/2/18
 *  
 **/
public interface ApiService {

    // 获取验证码
    @GET("user/getVerifyCode/{phone}")
    Observable<BaseBean<String>> getVerifyCode(@Path("phone") String phone);


    @FormUrlEncoded
    @POST("user/login/")
    Observable<BaseBean<UserBean>> login(@Field("phone") String phone, @Field("password") String password);


//    @FormUrlEncoded
//    @POST("user/register/")
//    Observable<BaseBean<UserBean>> register(@Field("phone") String phone, @Field("password") String password, @Field("verifyCode") String verifyCode);


    @FormUrlEncoded
    @POST("user/modifyPassword/")
    Observable<BaseBean<String>> modifyPassword(@Field("phone") String phone, @Field("newPassword") String newPassword, @Field("verifyCode") String verifyCode);



}
