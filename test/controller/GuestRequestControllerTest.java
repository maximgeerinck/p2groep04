/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entity.Presentation;
import entity.User;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Maxim
 */
public class GuestRequestControllerTest {
    
    public GuestRequestControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of approveRegistration method, of class GuestRequestController.
     */
    @Test
    public void testApproveRegistration() {
        System.out.println("approveRegistration");
        Presentation presentation = null;
        User guest = null;
        GuestRequestController instance = new GuestRequestController();
        instance.approveRegistration(presentation, guest);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllGuestPresentations method, of class GuestRequestController.
     */
    @Test
    public void testFindAllGuestPresentations() {
        System.out.println("findAllGuestPresentations");
        User guest = null;
        GuestRequestController instance = new GuestRequestController();
        List<Presentation> expResult = null;
        List<Presentation> result = instance.findAllGuestPresentations(guest);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllGuestRequests method, of class GuestRequestController.
     */
    @Test
    public void testFindAllGuestRequests() {
        System.out.println("findAllGuestRequests");
        Presentation presentation = null;
        GuestRequestController instance = new GuestRequestController();
        List<User> expResult = null;
        List<User> result = instance.findAllGuestRequests(presentation);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
