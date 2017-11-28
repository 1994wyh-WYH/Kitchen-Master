package com.example.katiechen.foodthree.Model;

import java.security.PublicKey;
import java.util.ArrayList;

/**
 * Created by katiechen on 11/21/17.
 */

public class BasicInfo {
    public String food1;
    public String food2;
    public String food3;
    private ArrayList<String> foodlist;
    private ArrayList<String> categoryList;
    private ArrayList<String> cuisineList;
    private int number;

    public BasicInfo() {
        foodlist = new ArrayList<>();
        categoryList = new ArrayList<>();
        cuisineList = new ArrayList<>();
        number = 0;
        food1 = "";
    }

    public ArrayList<String> getCategoryList() {
        return categoryList;
    }

    public ArrayList<String> getCuisineList() {
        return cuisineList;
    }

    public ArrayList<String> getFoodlist() {
        return foodlist;
    }

}
