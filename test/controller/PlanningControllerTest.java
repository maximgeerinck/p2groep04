/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import agenda.Agenda;
import entity.Campus;
import entity.Location;
import entity.Planning;
import entity.Presentation;
import entity.Promotor;
import entity.Student;
import entity.TimeFrame;
import java.util.Calendar;
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
public class PlanningControllerTest {
    
    public PlanningControllerTest() {
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
     * Test of retrievePresentations method, of class PlanningController.
     */
    @Test
    public void testRetrievePresentations_Planning() {
        System.out.println("retrievePresentations");
        Planning planning = null;
        PlanningController instance = new PlanningController();
        Agenda.AppointmentImpl[] expResult = null;
        Agenda.AppointmentImpl[] result = instance.retrievePresentations(planning);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removePresentation method, of class PlanningController.
     */
    @Test
    public void testRemovePresentation() {
        System.out.println("removePresentation");
        Presentation presentation = null;
        PlanningController instance = new PlanningController();
        instance.removePresentation(presentation);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changePlanningVisibility method, of class PlanningController.
     */
    @Test
    public void testChangePlanningVisibility() {
        System.out.println("changePlanningVisibility");
        Planning planning = null;
        boolean visible = false;
        PlanningController instance = new PlanningController();
        instance.changePlanningVisibility(planning, visible);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerVisibilityPeriod method, of class PlanningController.
     */
    @Test
    public void testRegisterVisibilityPeriod() {
        System.out.println("registerVisibilityPeriod");
        Planning planning = null;
        Calendar startTime = null;
        Calendar endTime = null;
        PlanningController instance = new PlanningController();
        instance.registerVisibilityPeriod(planning, startTime, endTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retrieveTimeFrames method, of class PlanningController.
     */
    @Test
    public void testRetrieveTimeFrames() {
        System.out.println("retrieveTimeFrames");
        PlanningController instance = new PlanningController();
        List<TimeFrame> expResult = null;
        List<TimeFrame> result = instance.retrieveTimeFrames();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retrieveCampuses method, of class PlanningController.
     */
    @Test
    public void testRetrieveCampuses() {
        System.out.println("retrieveCampuses");
        PlanningController instance = new PlanningController();
        List<Campus> expResult = null;
        List<Campus> result = instance.retrieveCampuses();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retrieveLocations method, of class PlanningController.
     */
    @Test
    public void testRetrieveLocations() {
        System.out.println("retrieveLocations");
        Campus campus = null;
        PlanningController instance = new PlanningController();
        List<Location> expResult = null;
        List<Location> result = instance.retrieveLocations(campus);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createPresentation method, of class PlanningController.
     */
    @Test
    public void testCreatePresentation() throws Exception {
        System.out.println("createPresentation");
        Planning planning = null;
        Calendar calendar = null;
        TimeFrame timeFrame = null;
        Location lokaal = null;
        Student presentator = null;
        PlanningController instance = new PlanningController();
        instance.createPresentation(planning, calendar, timeFrame, lokaal, presentator);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of notifyStakeHolders method, of class PlanningController.
     */
    @Test
    public void testNotifyStakeHolders() {
        System.out.println("notifyStakeHolders");
        Planning planning = null;
        PlanningController instance = new PlanningController();
        instance.notifyStakeHolders(planning);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retrievePresentations method, of class PlanningController.
     */
    @Test
    public void testRetrievePresentations_List() {
        System.out.println("retrievePresentations");
        List<Presentation> presentations = null;
        PlanningController instance = new PlanningController();
        Agenda.AppointmentImpl[] expResult = null;
        Agenda.AppointmentImpl[] result = instance.retrievePresentations(presentations);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of attachJury method, of class PlanningController.
     */
    @Test
    public void testAttachJury_4args() {
        System.out.println("attachJury");
        Promotor promotor = null;
        Promotor coPromotor = null;
        Promotor jury = null;
        Presentation presentation = null;
        PlanningController instance = new PlanningController();
        instance.attachJury(promotor, coPromotor, jury, presentation);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of attachJury method, of class PlanningController.
     */
    @Test
    public void testAttachJury_Promotor_Presentation() {
        System.out.println("attachJury");
        Promotor jury = null;
        Presentation presentation = null;
        PlanningController instance = new PlanningController();
        instance.attachJury(jury, presentation);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeJury method, of class PlanningController.
     */
    @Test
    public void testRemoveJury() {
        System.out.println("removeJury");
        Promotor jury = null;
        Presentation presentation = null;
        PlanningController instance = new PlanningController();
        instance.removeJury(jury, presentation);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
