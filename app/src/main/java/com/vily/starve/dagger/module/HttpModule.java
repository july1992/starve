package com.vily.starve.dagger.module;

import com.vily.starve.api.ApiService;
import com.vily.starve.rx.cookie.AddCookiesInterceptor;
import com.vily.starve.rx.cookie.ReceivedCookiesInterceptor;
import com.vily.starve.utils.CommonConfig;
import com.vily.starve.utils.UIUtils;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *  * description : 
 *  * Author : Vily
 *  * Date : 2019/2/18
 *  
 **/
@Module
public class HttpModule {

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(){

        System.out.println("：：：：初始化  OkHttpClient");
        // log用拦截器
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

        // 开发模式记录整个body，否则只记录基本信息如返回200，http协议版本等
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                // HeadInterceptor实现了Interceptor，用来往Request Header添加一些业务相关数据，如APP版本，token信息
                .addInterceptor(logging)
                .addInterceptor(new ReceivedCookiesInterceptor(UIUtils.getContext()))
                .addInterceptor(new AddCookiesInterceptor(UIUtils.getContext()))
                // 连接超时时间设置
                .connectTimeout(10, TimeUnit.SECONDS)
                // 读取超时时间设置
                .readTimeout(10, TimeUnit.SECONDS)
                .build();

        return okHttpClient;


    }
    @Provides
    @Singleton
    public Retrofit provideRetrofit(){

        System.out.println("：：：：初始化  Retrofit");


        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(CommonConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());


        return builder.build();
    }

    @Provides
    @Singleton
    public ApiService provideApiService(Retrofit retrofit){

        System.out.println("：：：：初始化  ApiService");

        return retrofit.create(ApiService.class);
    }

}
