package com.propertysys.property.model;

import lombok.Data;

@Data
public class Media {
    private int mediaID;
    private int propertyID;
    private String type;
    private String url;
}
