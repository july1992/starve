package com.vily.starve.ui.activity;

import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.vily.starve.R;
import com.vily.starve.bean.FoodBean;
import com.vily.starve.dagger.component.HttpComponent;
import com.vily.starve.ui.adapter.HeaderAdapter;
import com.vily.starve.ui.adapter.ImagePage;
import com.vily.starve.wight.gesture.ExtendListHeader;
import com.vily.starve.wight.gesture.OverFlyingLayoutManager;
import com.vily.starve.wight.gesture.PullExtendLayout;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 *  * description : 
 *  * Author : Vily
 *  * Date : 2019/2/19
 *  
 **/
public class HomeActivtiy extends BaseActivity implements View.OnClickListener {

    private Banner mBanner;
    private PullExtendLayout mPull_extend;
    private ExtendListHeader mExtend_header;

    @Override
    protected int setLayout() {
        return  R.layout.activity_home;
    }

    @Override
    protected void setupActivityComponent(HttpComponent httpComponent) {

    }

    @Override
    protected void init() {
        mBanner = findViewById(R.id.banner);

        mPull_extend = findViewById(R.id.pull_extend);
        mExtend_header = findViewById(R.id.extend_header);


        findViewById(R.id.cv_food).setOnClickListener(this);
        findViewById(R.id.cv_weapon).setOnClickListener(this);
        findViewById(R.id.cv_clothes).setOnClickListener(this);
        findViewById(R.id.cv_season).setOnClickListener(this);
        findViewById(R.id.cv_compose).setOnClickListener(this);
        findViewById(R.id.cv_boss).setOnClickListener(this);
        findViewById(R.id.cv_secret).setOnClickListener(this);
        findViewById(R.id.cv_animal).setOnClickListener(this);
        findViewById(R.id.cv_friend).setOnClickListener(this);
    }

    @Override
    protected void initData() {
        List<Integer> list=new ArrayList<>();
        list.add(R.mipmap.page1);
        list.add(R.mipmap.page2);
        list.add(R.mipmap.page3);
        mBanner.setImageLoader(new ImagePage());
        mBanner.setImages(list);
        mBanner.start();


        RecyclerView mExtend_header = this.mExtend_header.getRecyclerView();
        mExtend_header.setLayoutManager(new OverFlyingLayoutManager(OrientationHelper.HORIZONTAL));

        HeaderAdapter adapter=new HeaderAdapter();
        mExtend_header.setAdapter(adapter);

        List<FoodBean> list1=new ArrayList<>();
        list1.add(new FoodBean(1,"eee",22,"eee"));
        list1.add(new FoodBean(1,"eee",22,"eee"));
        list1.add(new FoodBean(1,"eee",22,"eee"));
        list1.add(new FoodBean(1,"eee",22,"eee"));
        list1.add(new FoodBean(1,"eee",22,"eee"));
        list1.add(new FoodBean(1,"eee",22,"eee"));
        list1.add(new FoodBean(1,"eee",22,"eee"));
        list1.add(new FoodBean(1,"eee",22,"eee"));
        list1.add(new FoodBean(1,"eee",22,"eee"));
        list1.add(new FoodBean(1,"eee",22,"eee"));
        list1.add(new FoodBean(1,"eee",22,"eee"));
        list1.add(new FoodBean(1,"eee",22,"eee"));
        list1.add(new FoodBean(1,"eee",22,"eee"));
        list1.add(new FoodBean(1,"eee",22,"eee"));
        list1.add(new FoodBean(1,"eee",22,"eee"));
        list1.add(new FoodBean(1,"eee",22,"eee"));
        list1.add(new FoodBean(1,"eee",22,"eee"));
        list1.add(new FoodBean(1,"eee",22,"eee"));
        adapter.setNewData(list1);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.cv_food :
                startActivity(MainActivity.class,false);
                break;

            case R.id.cv_weapon :
                break;
            case R.id.cv_clothes :
                break;
            case R.id.cv_season :
                break;
            case R.id.cv_compose :
                startActivity(ComposeActivity.class,false);
                break;
            case R.id.cv_boss :
                break;
            case R.id.cv_secret :
                break;
            case R.id.cv_animal :
                break;
            case R.id.cv_friend :
                break;

        }
    }
}
