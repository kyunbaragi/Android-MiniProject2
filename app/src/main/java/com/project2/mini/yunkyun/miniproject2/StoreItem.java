package com.project2.mini.yunkyun.miniproject2;

/**
 * Created by YunKyun on 2017-07-11.
 */

public class StoreItem {
    private String name;
    private String description;
    private boolean isChecked;
    private int popularity;
    private int recent;
    private double distance;

    public StoreItem(String name, String description, int popularity, int recent, double distance){
        this.name = name;
        this.description = description;
        this.isChecked = false;
        this.popularity = popularity;
        this.recent = recent;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
