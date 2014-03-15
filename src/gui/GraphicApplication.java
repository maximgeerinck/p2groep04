package gui;

import java.util.*;
import controller.*;

/**
 * @author Maxim
 */
public class GraphicApplication implements Observer {

	final jfxtras.scene.control.agenda.Agenda agenda;
	private PlanningController planningController = new PlanningController();
	private PlanningController attribute = new PlanningController();

	public jfxtras.scene.control.agenda.Agenda getAgenda() {
		return this.agenda;
	}

	public GraphicApplication() {
		// TODO - implement GraphicApplication.GraphicApplication
		throw new UnsupportedOperationException();
	}

	/**
	 * get the calendar for the first day of the week
	 * @param locale
	 * @param c
	 */
	private static java.util.Calendar getFirstDayOfWeekCalendar(java.util.Locale locale, java.util.Calendar c) {
		// TODO - implement GraphicApplication.getFirstDayOfWeekCalendar
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param o
	 * @param arg
	 */
	@Override
	public void update(java.util.Observable o, Object arg) {
		// TODO - implement GraphicApplication.update
		throw new UnsupportedOperationException();
	}

}