/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entity.BPCoordinator;
import entity.Promotor;
import entity.Student;
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
public class UserControllerTest {
    
    public UserControllerTest() {
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
     * Test of retrievePromotors method, of class UserController.
     */
    @Test
    public void testRetrievePromotors() {
        System.out.println("retrievePromotors");
        UserController instance = new UserController();
        List<Promotor> expResult = null;
        List<Promotor> result = instance.retrievePromotors();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retrieveBPC method, of class UserController.
     */
    @Test
    public void testRetrieveBPC() {
        System.out.println("retrieveBPC");
        UserController instance = new UserController();
        BPCoordinator expResult = null;
        BPCoordinator result = instance.retrieveBPC();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retrieveStudents method, of class UserController.
     */
    @Test
    public void testRetrieveStudents() {
        System.out.println("retrieveStudents");
        UserController instance = new UserController();
        List<Student> expResult = null;
        List<Student> result = instance.retrieveStudents();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of attachPromotorToStudent method, of class UserController.
     */
    @Test
    public void testAttachPromotorToStudent() {
        System.out.println("attachPromotorToStudent");
        Student student = null;
        Promotor promotor = null;
        UserController instance = new UserController();
        instance.attachPromotorToStudent(student, promotor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of detachPromotorFromStudent method, of class UserController.
     */
    @Test
    public void testDetachPromotorFromStudent() {
        System.out.println("detachPromotorFromStudent");
        Student student = null;
        Promotor promotor = null;
        UserController instance = new UserController();
        instance.detachPromotorFromStudent(student, promotor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
