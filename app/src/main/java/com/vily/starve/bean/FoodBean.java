package com.vily.starve.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 *  * description : 
 *  * Author : Vily
 *  * Date : 2019/2/18
 *  
 **/
public class FoodBean {

    private int id;
    private String name;
    private int bloodValue;
    private int meal_value;
    private int spirit_value;
    private int cooking_time;
    private int bad_time;
    private int img;
    private String menu;
    private String des;

    public FoodBean() {
    }

    public FoodBean(int id, String name, int img, String des) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.des = des;
    }

    public FoodBean(int id, String name, int bloodValue, int meal_value, int spirit_value, int cooking_time, int bad_time, int img, String menu) {
        this.id = id;
        this.name = name;
        this.bloodValue = bloodValue;
        this.meal_value = meal_value;
        this.spirit_value = spirit_value;
        this.cooking_time = cooking_time;
        this.bad_time = bad_time;
        this.img = img;
        this.menu = menu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBloodValue() {
        return bloodValue;
    }

    public void setBloodValue(int bloodValue) {
        this.bloodValue = bloodValue;
    }

    public int getMeal_value() {
        return meal_value;
    }

    public void setMeal_value(int meal_value) {
        this.meal_value = meal_value;
    }

    public int getSpirit_value() {
        return spirit_value;
    }

    public void setSpirit_value(int spirit_value) {
        this.spirit_value = spirit_value;
    }

    public int getCooking_time() {
        return cooking_time;
    }

    public void setCooking_time(int cooking_time) {
        this.cooking_time = cooking_time;
    }

    public int getBad_time() {
        return bad_time;
    }

    public void setBad_time(int bad_time) {
        this.bad_time = bad_time;
    }

    public int getIcon() {
        return img;
    }

    public void setIcon(int img) {
        this.img = img;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
