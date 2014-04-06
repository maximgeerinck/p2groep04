/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import entity.Location;
import entity.ResearchDomain;
import java.util.List;

/**
 *
 * @author Maxim
 */
public class ResearchDomainRepository extends Repository{

    public List<ResearchDomain> findAll() {
        return getEm().createQuery("SELECT r FROM " + ResearchDomain.class.getSimpleName() + " r").getResultList();
    }
    
    public ResearchDomain findBy(int id) {
        return (ResearchDomain)getEm().createQuery("SELECT r FROM " + ResearchDomain.class.getSimpleName() + " r WHERE r.id = :id").setParameter("id", id).getSingleResult();
    }

    public void update(ResearchDomain rs) {
        getEm().getTransaction().begin();
        
        ResearchDomain currentRS = findBy(rs.getId());
        
        if(currentRS == null)
            return;
        
        currentRS = rs;
        
        getEm().getTransaction().commit();
    }

    public void create(String name) 
    {
       getEm().getTransaction().begin();
       
       ResearchDomain rs = new ResearchDomain();
       rs.setName(name);
       
       getEm().persist(rs);
       getEm().flush();
       getEm().getTransaction().commit();
    }
}
