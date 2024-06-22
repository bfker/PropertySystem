package com.propertysys.property.dao;

import com.propertysys.property.model.Location;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LocationDao {
    void addLocation(Location location);
    Location getLocationById(int locationID);
}
