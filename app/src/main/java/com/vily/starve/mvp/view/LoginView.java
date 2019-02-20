package com.vily.starve.mvp.view;

import com.vily.starve.bean.UserBean;

/**
 *  * description : 
 *  * Author : Vily
 *  * Date : 2019/2/18
 *  
 **/
public interface LoginView extends BaseView {
    void loginSuccess(UserBean userBean);
}
