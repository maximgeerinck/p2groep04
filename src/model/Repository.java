/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import util.JPAUtil;

/**
 *
 * @author Maxim
 */
public abstract class Repository 
{
    protected EntityManager em = JPAUtil.getEntityManager();

    public EntityManager getEm() 
    {
        return JPAUtil.getEntityManager();
    }
    
    
}
