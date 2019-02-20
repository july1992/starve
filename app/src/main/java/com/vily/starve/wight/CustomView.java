package com.vily.starve.wight;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.TintTypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.vily.starve.R;

/**
 *  * description : 
 *  * Author : Vily
 *  * Date : 2019/2/19
 *  
 **/
public class CustomView extends LinearLayoutCompat {

    private TextView mTv_title;
    private ImageView mIv_icon;


    public CustomView(Context context) {
        this(context,null);
    }

    public CustomView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }
    @SuppressLint("RestrictedApi")
    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
        if (attrs != null) {
            final TintTypedArray a = TintTypedArray.obtainStyledAttributes(getContext(), attrs,
                    R.styleable.CustomView, defStyleAttr, 0);




            String title = a.getString(R.styleable.CustomView_title);
            if (!TextUtils.isEmpty(title)) {
                setTitle(title);
            }

            Drawable drawable = a.getDrawable(R.styleable.CustomView_icon);
            if(drawable!=null){
                setIcon(drawable);
            }

            a.recycle();
        }

    }


    private View mView;
    private void init() {
        LayoutInflater inflater = LayoutInflater.from(getContext());

        if(mView==null){
            mView = inflater.inflate(R.layout.layout_custom, this, true);

            mTv_title = mView.findViewById(R.id.tv_title);
            mIv_icon = mView.findViewById(R.id.iv_icon);
        }


    }




    public void setIcon(Drawable drawable) {
        if(mIv_icon!=null && drawable!=null){

            mIv_icon.setImageDrawable(drawable);
        }
    }

    public void setTitle(String title) {

        if(mTv_title!=null){

            mTv_title.setText(title);
        }
    }

    public String getTitle() {
        if(!TextUtils.isEmpty(mTv_title.getText().toString().trim())){
            return mTv_title.getText().toString().trim();
        }
        return null;
    }

}
