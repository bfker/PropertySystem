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
}
