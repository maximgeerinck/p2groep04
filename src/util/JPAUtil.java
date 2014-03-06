/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Roy
 */
public class JPAUtil {
    private final static EntityManagerFactory entityManagerFactory = 
            Persistence.createEntityManagerFactory("school");

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
    
    private JPAUtil()
    {
        
    }
}
