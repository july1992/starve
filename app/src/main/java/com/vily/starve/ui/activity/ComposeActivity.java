package com.vily.starve.ui.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.vily.starve.R;
import com.vily.starve.bean.FoodBean;
import com.vily.starve.dagger.component.HttpComponent;
import com.vily.starve.ui.adapter.ComposeAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 *  * description : 合成
 *  * Author : Vily
 *  * Date : 2019/2/19
 *  
 **/
public class ComposeActivity extends BaseActivity {

    private ImageView mIv_compose1;
    private ImageView mIv_compose2;
    private ImageView mIv_compose3;
    private ImageView mIv_compose4;
    private RecyclerView mRv_vegetables;
    private RecyclerView mRv_meat;
    private ComposeAdapter mVegetablesAdapter;
    private ComposeAdapter mMeatAdapter;

    @Override
    protected int setLayout() {
        return  R.layout.activity_compose;
    }

    @Override
    protected void setupActivityComponent(HttpComponent httpComponent) {

    }

    @Override
    protected void init() {
        mIv_compose1 = findViewById(R.id.iv_compose1);
        mIv_compose2 = findViewById(R.id.iv_compose2);
        mIv_compose3 = findViewById(R.id.iv_compose3);
        mIv_compose4 = findViewById(R.id.iv_compose4);
        mRv_vegetables = findViewById(R.id.rv_vegetables);
        mRv_meat = findViewById(R.id.rv_meat);

        mVegetablesAdapter = new ComposeAdapter();
        mRv_vegetables.setLayoutManager(new GridLayoutManager(ComposeActivity.this,4));
        mRv_vegetables.setAdapter(mVegetablesAdapter);


        mMeatAdapter = new ComposeAdapter();
        mRv_meat.setLayoutManager(new GridLayoutManager(ComposeActivity.this,4));
        mRv_meat.setAdapter(mMeatAdapter);
    }

    @Override
    protected void initData() {
        int[] imgs={R.mipmap.img_01,R.mipmap.img_02};

        List<FoodBean> listVeg=new ArrayList<>();
        listVeg.add(new FoodBean(0,"胡萝卜",imgs[0],"掘金"));
        listVeg.add(new FoodBean(1,"香蕉",imgs[1],"掘金"));
        listVeg.add(new FoodBean(2,"蜂蜜",imgs[1],"掘金"));
        listVeg.add(new FoodBean(2,"蜂蜜",imgs[1],"掘金"));
        mVegetablesAdapter.setNewData(listVeg);


        List<FoodBean> listMeat=new ArrayList<>();
        listMeat.add(new FoodBean(0,"大肉",imgs[0],"掘金"));
        listMeat.add(new FoodBean(1,"鸡腿",imgs[1],"掘金"));
        listMeat.add(new FoodBean(2,"怪物肉",imgs[1],"掘金"));
        listMeat.add(new FoodBean(2,"怪物肉",imgs[1],"掘金"));
        mMeatAdapter.setNewData(listMeat);

    }
}
