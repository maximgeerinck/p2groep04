/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Planning;
import entity.Presentation;
import entity.TimeFrame;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Roy
 */
public class PlanningControllerTest {
    
    public PlanningControllerTest() {
    }
    
    private Planning planning;
    private PlanningController planningController;
    private List<Presentation> presentations;
    private Presentation presentation;
    
    @Before
    public void before()
    {
        planning = new Planning();
        planningController = new PlanningController();
        
    }
    
    @Test
    public void trueVisibilty()
    {
        planningController.changePlanningVisibility(planning, true);
        Assert.assertEquals(true, planning.isVisible());
    }
    
    @Test
    public void falseVisibilty()
    {
        planningController.changePlanningVisibility(planning, false);
        Assert.assertEquals(false, planning.isVisible());
    }
    
    @Test(expected = NullPointerException.class)
    public void planningNullVisibilty()
    {
        planningController.changePlanningVisibility(null, false);
        
    }
    
    @Test
    public void testRegisterVisibilityPeriod()
    {
        Timestamp visibleStart = new Timestamp(20140310L);
        Timestamp visibleEnd = new Timestamp(20140311L);
        
        planningController.registerVisibilityPeriod(planning, visibleStart , visibleEnd);
        
        Assert.assertEquals(planning.getVisibleStart(), visibleStart);
        Assert.assertEquals(planning.getVisibleEnd(), visibleEnd);
    }
    
    @Test(expected = NullPointerException.class)
    public void testNullRegisterVisibilityPeriod()
    {
        planningController.registerVisibilityPeriod(planning, null , null);
    }
    
    @Test(expected = NullPointerException.class)
    public void testPlanningNullRegisterVisibilityPeriod()
    {
       Timestamp visibleStart = new Timestamp(20140310L);
       Timestamp visibleEnd = new Timestamp(20140311L); 
       
        planningController.registerVisibilityPeriod(null, visibleStart , visibleEnd);
        
    }
    
    @Test
    public void testCreateCorrectPlanning(){
      
      
        
      planningController.createPresentation(new TimeFrame(new Time(20140310L),new Time(20140311L)), 
              "Schoonmeersen", "B1.027", 1, 
              2, 3, "onderwerp", new Date(2014,03,12));
      
      
      
    }
}