/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import entity.Planning;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Maxim
 */
public class PlanningRepository extends Repository
{
    public Planning findOneById(long id) 
    {
        return (Planning)getEm().createQuery("SELECT p FROM " + Planning.class.getSimpleName() + " p WHERE p.id = :id").setParameter("id", id).getSingleResult();
    }
    
    public void changePlanningVisbility(Planning planning, boolean visible) 
    {
        getEm().getTransaction().begin();
        planning.setVisible(visible);
        getEm().getTransaction().commit();
    }
    
    public void changePlanningVisbilityPeriod(Planning planning, Calendar startTime, Calendar endTime)
    {
        getEm().getTransaction().begin();
        planning.setStartTime(new Timestamp(startTime.getTime().getTime()));
        planning.setEndTime(new Timestamp(endTime.getTime().getTime()));
        getEm().getTransaction().commit();
    }

    public List<Planning> findAll() {
       return getEm().createQuery("SELECT p FROM " + Planning.class.getSimpleName() + " p").getResultList();
    }
    
    public Planning create() 
    {
        getEm().getTransaction().begin();
        Planning planning = new Planning();
        getEm().persist(planning);
        getEm().flush();
        getEm().getTransaction().commit();
        
        return planning;
    }
}
