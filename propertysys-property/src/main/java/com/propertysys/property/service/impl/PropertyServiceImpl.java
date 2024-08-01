package com.propertysys.property.service.impl;

import com.propertysys.property.dao.PropertyDao;
import com.propertysys.property.model.Property;
import com.propertysys.property.model.Media;
import com.propertysys.property.service.PropertyService;
import com.propertysys.property.model.Location;
import com.propertysys.property.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    PropertyDao propertyDao;

    @Autowired
    LocationService locationService;

    @Override
    @Transactional
    public void addProperty(Property property) {
        // 添加 Location 信息
        Location location = property.getLocation();
        locationService.addLocation(location);
        property.setLocationID(location.getLocationID());

        propertyDao.addProperty(property);

        // 添加 Media 信息
        for (String imageUrl : property.getImages()) {
            Media media = new Media();
            media.setPropertyID(property.getPropertyID());
            media.setType("image");
            media.setUrl(imageUrl);
            propertyDao.addMedia(media);
        }

        if (property.getVideo() != null) {
            Media media = new Media();
            media.setPropertyID(property.getPropertyID());
            media.setType("video");
            media.setUrl(property.getVideo());
            propertyDao.addMedia(media);
        }
    }

    @Override
    public List<Property> getPropertyList(int userID) {
        return propertyDao.getPropertyList(userID);
    }

    @Override
    public Property getPropertyById(int propertyID) {
        Property property = propertyDao.getPropertyById(propertyID);
        Location location = locationService.getLocationById(property.getLocationID());
        property.setLocation(location);

        List<Media> mediaList = propertyDao.getMediaByPropertyId(propertyID);
        property.setMediaList(mediaList);
        return property;
    }

    @Override
    @Transactional
    public void updateProperty(Property property) {
        // 更新 Location 信息
        if(property.getLocation() != null) {
            Location location = property.getLocation();
            locationService.addLocation(location);
            property.setLocationID(location.getLocationID());
        }


        propertyDao.updateProperty(property);

        // 更新 Media 信息
        if((property.getImages() != null)) {
            propertyDao.deleteMediaByPropertyId(property.getPropertyID());
            for (String imageUrl : property.getImages()) {
                Media media = new Media();
                media.setPropertyID(property.getPropertyID());
                media.setType("image");
                media.setUrl(imageUrl);
                propertyDao.addMedia(media);
            }
        }

        if (property.getVideo() != null) {
            Media media = new Media();
            media.setPropertyID(property.getPropertyID());
            media.setType("video");
            media.setUrl(property.getVideo());
            propertyDao.addMedia(media);
        }
    }

    @Override
    @Transactional
    public void deleteProperty(int propertyID, int userID) {
        propertyDao.deleteMediaByPropertyId(propertyID);
        propertyDao.deleteProperty(propertyID, userID);
    }

    @Override
    @Transactional
    public void addInterest(int userID, int propertyID) {
        propertyDao.addInterest(userID, propertyID);
    }

    @Override
    public List<Property> getInterestedProperties(int userID) {
        return propertyDao.getInterestedProperties(userID);
    }

    @Override
    @Transactional
    public void removeInterest(int userID, int propertyID) {
        propertyDao.removeInterest(userID, propertyID);
    }

    @Override
    public List<Property> getAllProperties() {
        return propertyDao.getAllProperties();
    }

    @Override
    public List<Property> searchPropertiesByTitle(String title) {
        return propertyDao.searchPropertiesByTitle("%" + title + "%");
    }
}
