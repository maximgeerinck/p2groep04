/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Roy
 */
public class PresentationTest {
    
    private Presentation presentation;
    private Planning planning;
    
    public PresentationTest() {
    }
    
    @Before()
    public void before()
    {
        presentation = new Presentation();
        presentation.setPresentator(new Student());
    }
    
    
    @Test
    public void notifyStakeholdersTest()
    {
        presentation.notifyStakeholders(planning);
        String notification = "";
        
        for(String n: presentation.getPresentator().getNotifications())
        {
            notification = n;
        }
        
        Assert.assertEquals("There has been a change in the planning, "
                + "please check the planning for more information.", notification);
    }
}