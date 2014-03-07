package gui;

import java.util.*;
import controller.*;
import jfxtras.scene.control.agenda.Agenda;

/**
 * @author Maxim
 */
public class GraphicApplication implements Observer {

	final jfxtras.scene.control.agenda.Agenda agenda;
	private PlanningController planningController = new PlanningController();

	public jfxtras.scene.control.agenda.Agenda getAgenda() {
		return this.agenda;
	}

	public GraphicApplication() {
            agenda = new Agenda();

            // setup appointment groups
            final Map<String, Agenda.AppointmentGroup> lAppointmentGroupMap = new TreeMap<String, Agenda.AppointmentGroup>();

            //APOINTMENT GROUPS ZIJN DE KLEUREN VAN DE KALENDER ITEM
            lAppointmentGroupMap.put("group00", new Agenda.AppointmentGroupImpl().withStyleClass("group0"));
            lAppointmentGroupMap.put("group01", new Agenda.AppointmentGroupImpl().withStyleClass("group1"));
            lAppointmentGroupMap.put("group02", new Agenda.AppointmentGroupImpl().withStyleClass("group2"));
            lAppointmentGroupMap.put("group03", new Agenda.AppointmentGroupImpl().withStyleClass("group3"));
            lAppointmentGroupMap.put("group04", new Agenda.AppointmentGroupImpl().withStyleClass("group4"));
            lAppointmentGroupMap.put("group05", new Agenda.AppointmentGroupImpl().withStyleClass("group5"));
            lAppointmentGroupMap.put("group06", new Agenda.AppointmentGroupImpl().withStyleClass("group6"));
            lAppointmentGroupMap.put("group07", new Agenda.AppointmentGroupImpl().withStyleClass("group7"));
            lAppointmentGroupMap.put("group08", new Agenda.AppointmentGroupImpl().withStyleClass("group8"));
            lAppointmentGroupMap.put("group09", new Agenda.AppointmentGroupImpl().withStyleClass("group9"));
            lAppointmentGroupMap.put("group10", new Agenda.AppointmentGroupImpl().withStyleClass("group10"));
            lAppointmentGroupMap.put("group11", new Agenda.AppointmentGroupImpl().withStyleClass("group11"));
            lAppointmentGroupMap.put("group12", new Agenda.AppointmentGroupImpl().withStyleClass("group12"));
            lAppointmentGroupMap.put("group13", new Agenda.AppointmentGroupImpl().withStyleClass("group13"));
            lAppointmentGroupMap.put("group14", new Agenda.AppointmentGroupImpl().withStyleClass("group14"));
            lAppointmentGroupMap.put("group15", new Agenda.AppointmentGroupImpl().withStyleClass("group15"));
            lAppointmentGroupMap.put("group16", new Agenda.AppointmentGroupImpl().withStyleClass("group16"));
            lAppointmentGroupMap.put("group17", new Agenda.AppointmentGroupImpl().withStyleClass("group17"));
            lAppointmentGroupMap.put("group18", new Agenda.AppointmentGroupImpl().withStyleClass("group18"));
            lAppointmentGroupMap.put("group19", new Agenda.AppointmentGroupImpl().withStyleClass("group19"));
            lAppointmentGroupMap.put("group20", new Agenda.AppointmentGroupImpl().withStyleClass("group20"));
            lAppointmentGroupMap.put("group21", new Agenda.AppointmentGroupImpl().withStyleClass("group21"));
            lAppointmentGroupMap.put("group22", new Agenda.AppointmentGroupImpl().withStyleClass("group22"));
            lAppointmentGroupMap.put("group23", new Agenda.AppointmentGroupImpl().withStyleClass("group23"));

            for (String lId : lAppointmentGroupMap.keySet())
            {
                Agenda.AppointmentGroup lAppointmentGroup = lAppointmentGroupMap.get(lId);
                lAppointmentGroup.setDescription(lId);
                agenda.appointmentGroups().add(lAppointmentGroup);
            }

            // accept new appointments
            /*agenda.createAppointmentCallbackProperty().set(new Callback<Agenda.CalendarRange, Agenda.Appointment>()
            {
                @Override
                public Agenda.Appointment call(Agenda.CalendarRange calendarRange)
                {
                    return new Agenda.AppointmentImpl()
                            .withStartTime(calendarRange.getStartCalendar())
                            .withEndTime(calendarRange.getEndCalendar())
                            .withSummary("new")
                            .withDescription("new")
                            .withAppointmentGroup(lAppointmentGroupMap.get("group01"));
                }
            });*/

            // set the presentations on the calendar
            agenda.appointments().addAll(planningController.retrievePresentations()); 
	}

	/**
	 * get the calendar for the first day of the week
	 * @param locale
	 * @param c
	 */
	private static java.util.Calendar getFirstDayOfWeekCalendar(java.util.Locale locale, java.util.Calendar c) 
        {
		 // result
            int lFirstDayOfWeek = Calendar.getInstance(locale).getFirstDayOfWeek();
            int lCurrentDayOfWeek = c.get(Calendar.DAY_OF_WEEK);
            int lDelta = 0;
            if (lFirstDayOfWeek <= lCurrentDayOfWeek)
            {
                lDelta = -lCurrentDayOfWeek + lFirstDayOfWeek;
            }
            else
            {
                lDelta = -lCurrentDayOfWeek - (7-lFirstDayOfWeek);
            }
            c = ((Calendar)c.clone());
            c.add(Calendar.DATE, lDelta);
            return c;
	}

	/**
	 * 
	 * @param o
	 * @param arg
	 */
	@Override
	public void update(java.util.Observable o, Object arg) {
            //Redraw
            agenda.appointments().clear();
            agenda.appointments().addAll(planningController.retrievePresentations()); 
            System.out.println("Redraw calendar");        
	}

}