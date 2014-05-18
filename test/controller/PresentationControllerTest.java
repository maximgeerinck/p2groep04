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
public class PresentationControllerTest {
    
    public PresentationControllerTest() {
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
     * Test of deletePresentation method, of class PresentationController.
     */
    @Test
    public void testDeletePresentation() {
        System.out.println("deletePresentation");
        Presentation presentation = null;
        PresentationController instance = new PresentationController();
        instance.deletePresentation(presentation);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changePresentator method, of class PresentationController.
     */
    @Test
    public void testChangePresentator() {
        System.out.println("changePresentator");
        Presentation presentation = null;
        Student student = null;
        PresentationController instance = new PresentationController();
        instance.changePresentator(presentation, student);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeTimeframe method, of class PresentationController.
     */
    @Test
    public void testChangeTimeframe() {
        System.out.println("changeTimeframe");
        Presentation presentation = null;
        TimeFrame timeframe = null;
        PresentationController instance = new PresentationController();
        instance.changeTimeframe(presentation, timeframe);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeLocation method, of class PresentationController.
     */
    @Test
    public void testChangeLocation() {
        System.out.println("changeLocation");
        Presentation presentation = null;
        Location location = null;
        PresentationController instance = new PresentationController();
        instance.changeLocation(presentation, location);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
