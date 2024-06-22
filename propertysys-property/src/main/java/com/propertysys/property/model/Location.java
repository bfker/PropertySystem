package com.propertysys.property.model;

import lombok.Data;

@Data
public class Location {
    private int locationID;
    private String street;
    private String postalCode;
    private float latitude;
    private float longitude;
}
