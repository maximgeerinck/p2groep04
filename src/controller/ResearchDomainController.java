/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entity.ResearchDomain;
import java.util.List;
import model.ResearchDomainRepository;

/**
 *
 * @author Maxim
 */
public class ResearchDomainController 
{
    private ResearchDomainRepository researchDomainRepository = new ResearchDomainRepository();
    
    public List<ResearchDomain> findAll() {
        return researchDomainRepository.findAll();
    }
}
