/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import entity.Campus;
import entity.Location;
import entity.Presentation;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maxim
 */
public class LocationRepository extends Repository
{
    public List<Location> findByCampus(Campus campus) {
        if(campus == null) {
            return new ArrayList<Location>();
        }
        return getEm().createQuery("SELECT l FROM " + Location.class.getSimpleName() + " l JOIN l.campus c WHERE c.id = :id").setParameter("id", campus.getId()).getResultList();
    }

    public void changeLocation(Presentation presentation, Location location) {
        getEm().getTransaction().begin();
        presentation.setLocation(location);
        getEm().getTransaction().commit();
    }
}
