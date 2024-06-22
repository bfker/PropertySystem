package com.propertysys.property.service.impl;

import com.propertysys.property.dao.LocationDao;
import com.propertysys.property.model.Location;
import com.propertysys.property.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired(required = false)
    LocationDao locationDao;

    @Override
    @Transactional
    public void addLocation(Location location) {
        locationDao.addLocation(location);
    }

    @Override
    public Location getLocationById(int locationID) {
        return locationDao.getLocationById(locationID);
    }
}
