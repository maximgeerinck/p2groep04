/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import entity.Planning;
import java.sql.Timestamp;
import util.JPAUtil;

/**
 *
 * @author Maxim
 */
public class PlanningRepository extends Repository
{
    public Planning findOneById(int id) 
    {
        return (Planning)em.createQuery("SELECT p FROM " + Planning.class.getSimpleName() + " p WHERE p.id = 1").getSingleResult();
    }
    
    public void changePlanningVisbility(Planning planning, boolean visible) 
    {
        em.getTransaction().begin();
        planning.setVisible(visible);
        em.getTransaction().commit();
    }
    
    public void changePlanningVisbilityPeriod(Planning planning, Timestamp startTime, Timestamp endTime)
    {
        em.getTransaction().begin();
        planning.setStartTime(startTime);
        planning.setEndTime(endTime);
        em.getTransaction().commit();
    }
}
