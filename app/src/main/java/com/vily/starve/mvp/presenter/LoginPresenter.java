package com.vily.starve.mvp.presenter;

import android.util.Log;

import com.vily.starve.bean.UserBean;
import com.vily.starve.mvp.model.LoginModel;
import com.vily.starve.mvp.view.LoginView;
import com.vily.starve.rx.RxHttpResponseCompat;
import com.vily.starve.rx.subscriber.ErrorHandlerSubscriber;

import javax.inject.Inject;

/**
 *  * description : 
 *  * Author : Vily
 *  * Date : 2019/2/18
 *  
 **/
public class LoginPresenter extends BasePresenter<LoginModel, LoginView> {

    private static final String TAG = "LoginPresenter";

    @Inject
    public LoginPresenter(LoginModel model, LoginView view) {
        super(model, view);
    }

    public void login(String name, String psw) {

        mModel.login(name, psw)
                .compose(RxHttpResponseCompat.<UserBean>compatResult())
                .subscribe(new ErrorHandlerSubscriber<UserBean>() {
                    @Override
                    public void onNext(UserBean userBean) {
                        mView.loginSuccess(userBean);
                    }
                });

        Log.i(TAG, "login: ---------2");
    }
}
