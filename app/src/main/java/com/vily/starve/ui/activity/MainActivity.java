package com.vily.starve.ui.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.vily.starve.R;
import com.vily.starve.bean.FoodBean;
import com.vily.starve.dagger.component.HttpComponent;
import com.vily.starve.ui.adapter.MainAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    private RecyclerView mRv_recycle;
    private MainAdapter mAdapter;
    private List<FoodBean> mFoodList;
    private List<FoodBean> mSortList=new ArrayList<>();
    private Map<Integer,FoodBean> mMap=new HashMap<>();

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void setupActivityComponent(HttpComponent httpComponent) {

    }

    @Override
    protected void init() {

        mRv_recycle = findViewById(R.id.rv_recycle);
        findViewById(R.id.btn_blood).setOnClickListener(this);
        findViewById(R.id.btn_meal).setOnClickListener(this);
        findViewById(R.id.btn_spirit).setOnClickListener(this);
    }

    @Override
    protected void initData() {

        mRv_recycle.setLayoutManager(new LinearLayoutManager(MainActivity.this));
//        mRv_recycle.addItemDecoration(new DividerItemDecoration(MainActivity.this,DividerItemDecoration.VERTICAL));

        mAdapter = new MainAdapter();
        mRv_recycle.setAdapter(mAdapter);


        int[] imgs={R.mipmap.img_01,R.mipmap.img_02,R.mipmap.img_03,R.mipmap.img_04,R.mipmap.img_05,
                R.mipmap.img_06,R.mipmap.img_07,R.mipmap.img_08,R.mipmap.img_09,R.mipmap.img_10,
                R.mipmap.img_11,R.mipmap.img_12,R.mipmap.img_13,R.mipmap.img_14,R.mipmap.img_15,
                R.mipmap.img_16};
        mFoodList = new ArrayList<>();
        mFoodList.add(new FoodBean(1,"培根煎蛋",20,75,5,40,6,imgs[0],""));
        mFoodList.add(new FoodBean(2,"骨肉相连",3,37,5,40,6,imgs[1],""));
        mFoodList.add(new FoodBean(3,"彩蝶松饼",20,37,5,40,6,imgs[2],""));
        mFoodList.add(new FoodBean(4,"华夫饼",60,37,5,10,6,imgs[3],""));
        mFoodList.add(new FoodBean(5,"肉丸",3,62,5,15,6,imgs[4],""));
        mFoodList.add(new FoodBean(6,"炖肉",12,150,5,15,6,imgs[5],""));
        mFoodList.add(new FoodBean(7,"火鸡大餐",20,75,5,60,6,imgs[6],""));
        mFoodList.add(new FoodBean(8,"蜜汁火腿",30,75,5,40,6,imgs[7],""));
        mFoodList.add(new FoodBean(9,"怪物千层饼",-20,37,-20,10,6,imgs[8],""));
        mFoodList.add(new FoodBean(10,"果仁杂烩",30,12,5,40,6,imgs[9],""));
        mFoodList.add(new FoodBean(11,"曼德拉汤",100,150,5,60,6,imgs[10],""));
        mFoodList.add(new FoodBean(12,"火龙果派",40,75,5,40,6,imgs[11],""));
        mFoodList.add(new FoodBean(13,"冰镇西瓜",3,12,20,10,6,imgs[12],""));
        mFoodList.add(new FoodBean(14,"水果圣代",20,25,5,10,6,imgs[13],""));
        mFoodList.add(new FoodBean(15,"冰激凌",0,18,33,40,6,imgs[14],""));
        mFoodList.add(new FoodBean(16,"青蛙热狗",20,37,5,40,6,imgs[15],""));

        mAdapter.setNewData(mFoodList);
    }

    @Override
    protected void initlistener() {
        super.initlistener();

        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                Log.i(TAG, "onItemClick: -----------------");
                List<FoodBean> data = adapter.getData();
                int icon = data.get(position).getIcon();

                Intent intent=new Intent(MainActivity.this,PreviewActivty.class);
                intent.putExtra("path",icon);
                startActivity(intent);


            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_blood :
                mMap.clear();
                mSortList.clear();
                for (FoodBean foodBean:mFoodList){
                    mMap.put(foodBean.getBloodValue(),foodBean);
                }
                for (Integer key : mMap.keySet()) {

                    mSortList.add(mMap.get(key));
                }

                mAdapter.setNewData(mSortList);

                break;

            case  R.id.btn_meal :
                mMap.clear();
                mSortList.clear();
                for (FoodBean foodBean:mFoodList){
                    mMap.put(foodBean.getMeal_value(),foodBean);
                }
                for (Integer key : mMap.keySet()) {

                    mSortList.add(mMap.get(key));
                }

                mAdapter.setNewData(mSortList);
                break;
            case  R.id.btn_spirit :
                mMap.clear();
                mSortList.clear();
                for (FoodBean foodBean:mFoodList){
                    mMap.put(foodBean.getSpirit_value(),foodBean);
                }
                for (Integer key : mMap.keySet()) {

                    mSortList.add(mMap.get(key));
                }

                mAdapter.setNewData(mSortList);
                break;
            default :
                break;
        }
    }
}
