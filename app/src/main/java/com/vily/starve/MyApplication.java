package com.vily.starve;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.vily.starve.dagger.component.DaggerHttpComponent;
import com.vily.starve.dagger.component.HttpComponent;
import com.vily.starve.dagger.module.HttpModule;
import com.vily.starve.rx.cookie.AddCookiesInterceptor;
import com.vily.starve.rx.cookie.ReceivedCookiesInterceptor;
import com.vily.starve.utils.UIUtils;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 *  * description : 
 *  * Author : Vily
 *  * Date : 2019/2/18
 *  
 **/
public class MyApplication extends Application {

    //全局上下文环境
    private static Context mContext;
    //全局的handler
    private static Handler mHandler;
    //主线程
    private static Thread mMainThread;
    //主线程id
    private static int mMainThreadId;

    private HttpComponent mHttpComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = getApplicationContext();

        mHandler = new Handler();

        mMainThread = Thread.currentThread();

        mMainThreadId = android.os.Process.myTid();

        mHttpComponent = DaggerHttpComponent.builder().httpModule(new HttpModule()).build();


//        initHttp();
    }

    private void initHttp() {
        // log用拦截器
//        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//
//        // 开发模式记录整个body，否则只记录基本信息如返回200，http协议版本等
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                // HeadInterceptor实现了Interceptor，用来往Request Header添加一些业务相关数据，如APP版本，token信息
//                .addInterceptor(logging)
//                .addInterceptor(new ReceivedCookiesInterceptor(UIUtils.getContext()))
//                .addInterceptor(new AddCookiesInterceptor(UIUtils.getContext()))
//                // 连接超时时间设置
//                .connectTimeout(10, TimeUnit.SECONDS)
//                // 读取超时时间设置
//                .readTimeout(10, TimeUnit.SECONDS)
//                .build();
    }

    public HttpComponent getHttpComponent() {
        return mHttpComponent;
    }

    public static MyApplication get(Context context){
        return (MyApplication) context.getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }

    public static Handler getHandler() {
        return mHandler;
    }

    public static Thread getMainThread() {
        return mMainThread;
    }

    public static int getMainThreadId() {
        return mMainThreadId;
    }

}
