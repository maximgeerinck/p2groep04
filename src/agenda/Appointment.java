/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import entity.Presentation;
import java.util.Calendar;
import jfxtras.scene.control.agenda.Agenda.AppointmentGroup;

/**
 *
 * @author Maxim
 */
public interface Appointment {

    public Calendar getStartTime();

    public void setStartTime(Calendar c);

    public Calendar getEndTime();

    public void setEndTime(Calendar c);

    public Boolean isWholeDay();

    public void setWholeDay(Boolean b);

    public String getSummary();

    public void setSummary(String s);

    public String getDescription();

    public void setDescription(String s);

    public String getLocation();

    public void setLocation(String s);

    public AppointmentGroup getAppointmentGroup();

    public void setAppointmentGroup(AppointmentGroup s);
    
    public void setPresentation(Presentation p);
    
    public Presentation getPresentation();       
}
