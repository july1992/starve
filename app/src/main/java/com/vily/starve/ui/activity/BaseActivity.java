package com.vily.starve.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.vily.starve.MyApplication;
import com.vily.starve.dagger.component.HttpComponent;
import com.vily.starve.mvp.presenter.BasePresenter;

import javax.inject.Inject;

/**
 *  * description : 
 *  * Author : Vily
 *  * Date : 2019/2/18
 *  
 **/
public  abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {


    public Context mContext;
    protected MyApplication mMyApplication;

    @Inject
    T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(setLayout());

        mMyApplication = (MyApplication) getApplication();

        mContext=this;

        setupActivityComponent(mMyApplication.getHttpComponent());

        init();
        initData();
        initlistener();
    }


    protected abstract int setLayout();

    protected abstract void setupActivityComponent(HttpComponent httpComponent);

    protected abstract void init();
    protected abstract void initData();
    protected void initlistener(){};



    public int getScreenWidth() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics.widthPixels;
    }


    /**
     * 让屏幕变暗
     */
    protected void makeWindowDark() {
        Window window = getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.alpha = 0.5f;
        window.setAttributes(lp);
    }

    /**
     * 让屏幕变亮
     */
    protected void makeWindowLight() {
        Window window = getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.alpha = 1f;
        window.setAttributes(lp);
    }


    protected void hideKeyboard(EditText editText) {
        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        if(inputMethodManager.isActive(editText)){
            editText.requestFocus();
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    protected void showKeyboard(EditText editText) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null) {
            editText.requestFocus();
            inputMethodManager.showSoftInput(editText,InputMethodManager.SHOW_FORCED);

        }
    }

    protected void startActivity(Class activity) {

        startActivity(activity, false);
    }

    protected void startActivity(Class activity, boolean flag) {

        Intent intent = new Intent(this, activity);
        startActivity(intent);

        if (flag) {
            finish();
        }

    }
}
