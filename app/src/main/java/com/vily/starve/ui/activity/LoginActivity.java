package com.vily.starve.ui.activity;

import com.vily.starve.R;
import com.vily.starve.bean.UserBean;
import com.vily.starve.dagger.component.DaggerLoginComponent;
import com.vily.starve.dagger.component.HttpComponent;
import com.vily.starve.dagger.module.LoginModule;
import com.vily.starve.mvp.presenter.LoginPresenter;
import com.vily.starve.mvp.view.LoginView;

/**
 *  * description : 
 *  * Author : Vily
 *  * Date : 2019/2/18
 *  
 **/
public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView {

    @Override
    protected int setLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void setupActivityComponent(HttpComponent httpComponent) {
        DaggerLoginComponent
                .builder()
                .httpComponent(httpComponent)
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void init() {

    }

    @Override
    protected void initData() {

        mPresenter.login("vily","vily");


        //                OkHttpUtils.get()
//                        .url("http://192.168.93.113:8080/diary/user/getVerifyCode/17521721435")
//                        .build().execute(new Callback() {
//                    @Override
//                    public Object parseNetworkResponse(Response response, int i) throws Exception {
//                        Log.i(TAG, "parseNetworkResponse: -------s");
//                        ResponseBody body = response.body();
//                        String s = body.string();
//                        Log.i(TAG, "parseNetworkResponse: -------s"+s);
////                        URLEncoder.encode("","UTF-8");
////                        URLDecoder.decode()
//
//                        return null;
//                    }
//
//                    @Override
//                    public void onError(Call call, Exception e, int i) {
//                        Log.i(TAG, "onError: --------错误");
//                    }
//
//                    @Override
//                    public void onResponse(Object o, int i) {
//                        Log.i(TAG, "onResponse: -------hhh");
//                    }
//                });
//                Log.i(TAG, "onClick: ----------");
    }

    @Override
    public void loginSuccess(UserBean userBean) {

    }
}
