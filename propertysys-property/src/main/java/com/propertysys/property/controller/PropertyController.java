package com.propertysys.property.controller;

import com.propertysys.property.model.Property;
import com.propertysys.property.service.PropertyService;
import com.propertysys.property.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @PostMapping("/add")
    public Result<Property> addProperty(@RequestBody Property property) {
        propertyService.addProperty(property);
        return Result.success(property);
    }

    @PostMapping("/list")
    public Result<List<Property>> getPropertyList(@RequestBody Map<String, Integer> request) {
        int userID = request.get("userID");
        List<Property> properties = propertyService.getPropertyList(userID);
        return Result.success(properties);
    }

    @PostMapping("/details")
    public Result<Property> getPropertyById(@RequestBody Map<String, Integer> request) {
        int propertyID = request.get("propertyID");
        Property property = propertyService.getPropertyById(propertyID);
        return Result.success(property);
    }

    @PostMapping("/update")
    public Result<Property> updateProperty(@RequestBody Property property) {
        propertyService.updateProperty(property);
        return Result.success(property);
    }

    @DeleteMapping("/delete")
    public Result<Void> deleteProperty(@RequestParam int propertyID, @RequestParam int userID) {
        propertyService.deleteProperty(propertyID, userID);
        return Result.success();
    }

    @PostMapping("/addInterest")
    public Result<Void> addInterest(@RequestBody Map<String, Integer> request) {
        int userID = request.get("userID");
        int propertyID = request.get("propertyID");
        propertyService.addInterest(userID, propertyID);
        return Result.success();
    }

    @PostMapping("/interested")
    public Result<List<Property>> getInterestedProperties(@RequestBody Map<String, Integer> request) {
        int userID = request.get("userID");
        List<Property> properties = propertyService.getInterestedProperties(userID);
        return Result.success(properties);
    }

    @PostMapping("/removeInterest")
    public Result<Void> removeInterest(@RequestBody Map<String, Integer> request) {
        int userID = request.get("userID");
        int propertyID = request.get("propertyID");
        propertyService.removeInterest(userID, propertyID);
        return Result.success();
    }


    @GetMapping("/all")
    public Result<List<Property>> getAllProperties() {
        List<Property> properties = propertyService.getAllProperties();
        return Result.success(properties);
    }

    @PostMapping("/search")
    public Result<List<Property>> searchPropertiesByTitle(@RequestBody Map<String, String> request) {
        String title = request.get("title");
        List<Property> properties = propertyService.searchPropertiesByTitle(title);
        return Result.success(properties);
    }
}
