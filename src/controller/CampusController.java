/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entity.Campus;
import java.util.List;
import model.CampusRepository;

/**
 *
 * @author Maxim
 */
public class CampusController 
{
    private CampusRepository campusRepository = new CampusRepository();
    
    public List<Campus> retrieveCampuses() 
    {
        return campusRepository.findAll();
    }
}
