package com.propertysys.property.dao;

import com.propertysys.property.model.Property;
import com.propertysys.property.model.Media;
import com.propertysys.property.model.Interest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PropertyDao {
    void addProperty(Property property);
    List<Property> getPropertyList(int userID);
    Property getPropertyById(int propertyID);
    void updateProperty(Property property);
    void deleteProperty(int propertyID, int userID);
    void addMedia(Media media);
    List<Media> getMediaByPropertyId(int propertyID);
    void deleteMediaByPropertyId(int propertyID);
    void addInterest(int userID, int propertyID);
    List<Property> getInterestedProperties(int userID);
    void removeInterest(int userID, int propertyID);
    List<Property> getAllProperties();

    List<Property> searchPropertiesByTitle(String title);

    Integer getInterestStatus(int userID, int propertyID);

    void deleteInterestsByPropertyId(int propertyID);
}
