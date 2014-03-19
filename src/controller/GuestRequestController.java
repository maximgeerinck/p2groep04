/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entity.GuestRequest;
import entity.Presentation;
import entity.Student;
import entity.User;
import java.util.ArrayList;
import java.util.List;
import model.PresentationRepository;
import model.UserRepository;
import javax.persistence.EntityManager;
import util.JPAUtil;
import model.Repository;

/**
 *
 * @author Roy
 */
public class GuestRequestController {
    
    private PresentationRepository presentationRepository = new PresentationRepository();
    private UserRepository userRepository = new UserRepository();
    private EntityManager em = presentationRepository.getEm();
    
    public void approveRegistration(Presentation presentation, User guest)
    {
       List <Student> users = new ArrayList<>();
       
       users.addAll(presentation.getGuests());
       users.add((Student)guest);
       
       em.getTransaction().begin();
       presentation.setGuests(users);
       em.getTransaction().commit();
       em.close();  
    }
    
    public List<Presentation> findAllGuestPresentations(User guest)
    {
        List<Presentation> attendingPresentations = new ArrayList<>();
        attendingPresentations.addAll(guest.getPresentationsAttending());
        
        return attendingPresentations;
    }
    
    public List<User> findAllGuestRequests(Presentation presentation)
    {
        List<GuestRequest> allRequests = new ArrayList<>();
        List<User> guests = new ArrayList<>();
        
        allRequests.addAll(presentation.getGuestRequests());
        
        for(GuestRequest g: allRequests)
        {
            guests.add(g.getStudent());
        }
        
        return guests;
    }
}
