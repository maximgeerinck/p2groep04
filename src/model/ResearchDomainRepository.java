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
    
}
