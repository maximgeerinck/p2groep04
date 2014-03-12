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
    
    public PresentationTest() {
    }
    
    @Before()
    public void before()
    {
        presentation = new Presentation();
        presentation.setUser(new User());
    }
    
    
    @Test
    public void notifyStakeholdersTest()
    {
        presentation.notifyStakeholders();
        String notification = "";
        
        for(String n: presentation.getUser().getNotifications())
        {
            notification = n;
        }
        
        Assert.assertEquals("There has been a change in the planning, "
                + "please check the planning for more information.", notification);
    }
}