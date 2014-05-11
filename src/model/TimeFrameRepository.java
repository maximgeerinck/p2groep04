/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import entity.Presentation;
import entity.TimeFrame;
import java.util.List;

/**
 *
 * @author Maxim
 */
public class TimeFrameRepository extends Repository
{
    public List<TimeFrame> findAll()
    {
        return getEm().createQuery("SELECT t FROM " + TimeFrame.class.getSimpleName() + " t").getResultList();
    }

    public void changeTimeframe(Presentation presentation, TimeFrame timeframe) {
        getEm().getTransaction().begin();
        presentation.setTimeFrame(timeframe);
        getEm().getTransaction().commit();
    }
}
