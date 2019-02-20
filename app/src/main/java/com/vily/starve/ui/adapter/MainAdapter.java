package com.vily.starve.ui.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.vily.starve.R;
import com.vily.starve.bean.FoodBean;

import java.util.List;

/**
 *  * description : 
 *  * Author : Vily
 *  * Date : 2019/2/18
 *  
 **/
public class MainAdapter extends BaseQuickAdapter<FoodBean,BaseViewHolder> {


    private ImageView mIv_icon;
    private TextView mTv_name;
    private TextView mTv_blood;
    private TextView mTv_meal;
    private TextView mTv_spirit;

    public MainAdapter() {
        super(R.layout.adpter_main);
    }

    public MainAdapter(@Nullable List<FoodBean> data) {
        super(R.layout.adpter_main, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FoodBean item) {


        mIv_icon = helper.getView(R.id.iv_icon);
        mTv_name = helper.getView(R.id.tv_name);
        mTv_blood = helper.getView(R.id.tv_blood);
        mTv_meal = helper.getView(R.id.tv_meal);
        mTv_spirit = helper.getView(R.id.tv_spirit);

        if(item!=null){

            if(!TextUtils.isEmpty(item.getName())){
                mTv_name.setText(item.getName());
            }

            mTv_blood.setText("加血："+item.getBloodValue());
            mTv_meal.setText("饱食度："+item.getMeal_value());
            mTv_spirit.setText("精神值："+item.getSpirit_value());
        }
    }
}
