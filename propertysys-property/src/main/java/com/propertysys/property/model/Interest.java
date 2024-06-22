package com.propertysys.property.model;

import lombok.Data;

@Data
public class Interest {
    private int interestID;
    private int userID;
    private int propertyID;
    private String status;
}
