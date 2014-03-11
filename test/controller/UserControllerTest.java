/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entity.User;
import org.junit.Test;
import org.junit.Before;


/**
 *
 * @author Bram
 */
public class UserControllerTest {
    
    private User user;
    private UserController userController;
    
    @Before
    public void before()
    {
        user = new User();
        userController = new UserController();
        
    }

    @Test
    public void testStudentToewijzenAanPromotor()
    {
        userController.wijsPromoterToeAanStudent();    
    }
  
    
    @Test(expected = MaxAantalStudentenBereiktException.class)
    public void testPromotorHeeftAlZijnMaxAantalStudentenBereikt()
    {
       
    }
    
    @Test
    public void testStudentHeeftAlPromotor()
    {
        
    }
}
