/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entity.Location;
import entity.Presentation;
import entity.Student;
import entity.TimeFrame;
import model.LocationRepository;
import model.PresentationRepository;
import model.TimeFrameRepository;
import model.UserRepository;

/**
 *
 * @author Maxim
 */
public class PresentationController 
{

    private UserRepository userRepository = new UserRepository();
    private TimeFrameRepository timeFrameRepository = new TimeFrameRepository();
    private LocationRepository locationRepository = new LocationRepository();
    private PresentationRepository presentationRepository = new PresentationRepository();
    
    public void deletePresentation(Presentation presentation) {
        presentationRepository.deletePresentation(presentation);
    }
    
    public void changePresentator(Presentation presentation, Student student) {
       userRepository.changePresentator(presentation, student);
    }

    public void changeTimeframe(Presentation presentation, TimeFrame timeframe) {
        timeFrameRepository.changeTimeframe(presentation, timeframe);
    }

    public void changeLocation(Presentation presentation, Location location) {
        locationRepository.changeLocation(presentation, location);
    }
    
}
