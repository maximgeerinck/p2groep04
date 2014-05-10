/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import entity.GuestRequest;
import java.util.List;

/**
 *
 * @author Maxim
 */
public class GuestRequestRepository extends Repository 
{
    public List<GuestRequest> findAllGuests() 
    {
        return getEm().createQuery("SELECT g FROM GuestRequest g").getResultList();
    }
}
