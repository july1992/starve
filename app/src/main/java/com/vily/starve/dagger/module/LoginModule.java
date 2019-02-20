package com.vily.starve.dagger.module;

import com.vily.starve.api.ApiService;
import com.vily.starve.mvp.model.LoginModel;
import com.vily.starve.mvp.view.LoginView;

import dagger.Module;
import dagger.Provides;

/**
 *  * description : 
 *  * Author : Vily
 *  * Date : 2019/2/18
 *  
 **/
@Module
public class LoginModule {

    private LoginView mLoginView;


    public LoginModule(LoginView loginView ) {
        mLoginView = loginView;

    }

    @Provides
    public LoginView provideLoginView(){

        return mLoginView;
    }

    @Provides
    public LoginModel provideLoginModel(ApiService apiService){

        return new LoginModel(apiService);
    }

}
