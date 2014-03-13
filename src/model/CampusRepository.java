/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import entity.Campus;
import java.util.List;

/**
 *
 * @author Maxim
 */
public class CampusRepository extends Repository
{
    public List<Campus> findAll() {
        return getEm().createQuery("SELECT c FROM " + Campus.class.getSimpleName() + " c ").getResultList();
    }
}
