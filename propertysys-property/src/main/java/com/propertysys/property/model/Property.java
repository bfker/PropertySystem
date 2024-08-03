package com.propertysys.property.model;

import lombok.Data;

import java.util.List;

@Data
public class Property {
    private int propertyID;
    private int userID;
    private int locationID;
    private String title;
    private float price;
    private String description;
    private String type;
    private String size;
    private List<String> images;
    private String video;
    private Location location;
    private List<Media> mediaList;

    // 添加这个字段
    private boolean isInterested;

    // Getters and Setters
    public boolean isInterested() {
        return isInterested;
    }

    public void setInterested(boolean interested) {
        isInterested = interested;
    }
}
