package com.propertysys.property.service;

import com.propertysys.property.model.Property;

import java.util.List;

public interface PropertyService {
    void addProperty(Property property);
    List<Property> getPropertyList(int userID);
    Property getPropertyById(int propertyID);
    void updateProperty(Property property);
    void deleteProperty(int propertyID, int userID);
    void addInterest(int userID, int propertyID);
    List<Property> getInterestedProperties(int userID);
    void removeInterest(int userID, int propertyID);
    List<Property> getAllProperties(int userID);
    List<Property> searchPropertiesByTitle(String title, int userID);
}
