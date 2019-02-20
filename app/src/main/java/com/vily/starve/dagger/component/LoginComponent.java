package com.vily.starve.dagger.component;

import com.vily.starve.dagger.ActivityScope;
import com.vily.starve.dagger.module.LoginModule;
import com.vily.starve.ui.activity.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 *  * description : 
 *  * Author : Vily
 *  * Date : 2019/2/18
 *  
 **/
@ActivityScope
@Component(modules = LoginModule.class,dependencies = HttpComponent.class)
public interface LoginComponent {

    void inject(LoginActivity activity);
}
