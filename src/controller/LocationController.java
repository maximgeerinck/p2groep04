/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entity.Campus;
import entity.Location;
import java.util.List;
import model.CampusRepository;
import model.LocationRepository;

/**
 *
 * @author Maxim
 */
public class LocationController 
{
    private LocationRepository locationRepository = new LocationRepository();    
    
    public List<Location> retrieveLocations(Campus campus) {
        return locationRepository.findByCampus(campus);
    }
    
    
}
