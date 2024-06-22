package com.propertysys.property.service;

import com.propertysys.property.model.Location;

public interface LocationService {
    void addLocation(Location location);
    Location getLocationById(int locationID);
}
