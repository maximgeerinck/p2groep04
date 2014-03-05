/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entity.Location;
import entity.Presentation;
import java.security.Timestamp;
import org.hibernate.mapping.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author Maxim
 */
@RunWith(Parameterized.class)
public class PlanningControllerTest {
    
    @Parameterized.Parameters
    public static Collection Presentaties()
    {
        return Arrays.asList(New Object[][]
        {
            //{new Presentation(new Timestamp(05-03-2014), new Timestamp(06-03-2014), new Location()), true}
        });
    }
    
    public PlanningControllerTest() {
        
    }
}
