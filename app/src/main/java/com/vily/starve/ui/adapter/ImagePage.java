package com.vily.starve.ui.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.youth.banner.loader.ImageLoader;

/**
 *  * description : 
 *  * Author : Vily
 *  * Date : 2019/1/22
 *  
 **/
public class ImagePage extends ImageLoader {

    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {


        imageView.setBackgroundResource((Integer)path);
    }

//    @Override
//    public ImageView createImageView(Context context) {
//        return super.createImageView(context);
//
//    }
}
