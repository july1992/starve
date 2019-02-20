package com.vily.starve.mvp.model;

import com.vily.starve.api.ApiService;
import com.vily.starve.bean.BaseBean;
import com.vily.starve.bean.UserBean;

import dagger.Module;
import io.reactivex.Observable;

/**
 *  * description : 
 *  * Author : Vily
 *  * Date : 2019/2/18
 *  
 **/

public class LoginModel {

    private ApiService mApiService;

    public LoginModel(ApiService apiService) {
        mApiService = apiService;
    }


    public Observable<BaseBean<UserBean>> login(String phone, String password) {
        return mApiService.login(phone,password);
    }
}
