package com.vily.starve.dagger.component;

import com.vily.starve.api.ApiService;
import com.vily.starve.dagger.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 *  * description : 
 *  * Author : Vily
 *  * Date : 2019/2/18
 *  
 **/

@Singleton
@Component(modules = {HttpModule.class})
public interface HttpComponent {
    //将HttpModule中的ApiService暴露出来，以便于其他依赖于AppComponent的Component调用
    ApiService getApiService();

}
