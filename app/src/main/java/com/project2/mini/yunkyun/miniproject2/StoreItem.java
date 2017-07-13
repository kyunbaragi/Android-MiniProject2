package com.project2.mini.yunkyun.miniproject2;

/**
 * Created by YunKyun on 2017-07-11.
 */

public class StoreItem {
    private String name;
    private String description;
    private int imageFile;
    private int popularity;
    private int recent;
    private boolean isChecked;
    private double distance;

    public StoreItem(String name, String description, int imageFile, int popularity, int recent, double distance){
        this.name = name;
        this.description = description;
        this.imageFile = imageFile;
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

    public int getImageFile() {
        return imageFile;
    }

    public int getPopularity() {
        return popularity;
    }

    public int getRecent() {
        return recent;
    }

    public double getDistance() {
        return distance;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
