/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Planning;
import java.sql.Timestamp;
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
}