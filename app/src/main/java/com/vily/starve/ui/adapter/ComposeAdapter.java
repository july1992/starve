package com.vily.starve.ui.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.vily.starve.R;
import com.vily.starve.bean.FoodBean;

import java.util.List;

/**
 *  * description : 
 *  * Author : Vily
 *  * Date : 2019/2/19
 *  
 **/
public class ComposeAdapter extends BaseQuickAdapter<FoodBean,BaseViewHolder> {


    private ImageView mIv_icon;

    public ComposeAdapter() {
        super(R.layout.adapter_compose);
    }

    public ComposeAdapter(@Nullable List<FoodBean> data) {
        super(R.layout.adapter_compose, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FoodBean item) {

        mIv_icon = helper.getView(R.id.iv_icon);
        if(item!=null){
            mIv_icon.setImageResource(item.getImg());
        }
    }
}
