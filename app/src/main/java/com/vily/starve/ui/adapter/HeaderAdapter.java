package com.vily.starve.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.vily.starve.R;
import com.vily.starve.bean.FoodBean;

import java.util.List;

/**
 *  * description : 
 *  * Author : Vily
 *  * Date : 2019/2/20
 *  
 **/
public class HeaderAdapter extends BaseQuickAdapter<FoodBean,BaseViewHolder> {


    public HeaderAdapter() {
        super(R.layout.adapter_header);
    }

    public HeaderAdapter(@Nullable List<FoodBean> data) {
        super(R.layout.adapter_header, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FoodBean item) {

    }
}
