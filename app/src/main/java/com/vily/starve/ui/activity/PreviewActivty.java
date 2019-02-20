package com.vily.starve.ui.activity;

import android.view.View;

import com.github.chrisbanes.photoview.PhotoView;
import com.vily.starve.R;
import com.vily.starve.dagger.component.HttpComponent;

/**
 *  * description : 
 *  * Author : Vily
 *  * Date : 2019/2/18
 *  
 **/
public class PreviewActivty extends BaseActivity {

    private PhotoView mPv_photo;

    @Override
    protected int setLayout() {
        return R.layout.activtiy_preview;
    }

    @Override
    protected void setupActivityComponent(HttpComponent httpComponent) {

    }

    @Override
    protected void init() {

        mPv_photo = findViewById(R.id.pv_photo);
    }

    @Override
    protected void initData() {

        int path = getIntent().getIntExtra("path", 0);
        if(path!=0){

            mPv_photo.setImageResource(path);
        }
    }
}
