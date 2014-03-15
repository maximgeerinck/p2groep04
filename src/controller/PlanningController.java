package controller;

import model.*;
import entity.*;

/**
 * import util.JPAUtil;
 */
public class PlanningController {

	private PresentationRepository presentationRepository = new PresentationRepository();
	private PresentationRepository attribute = new PresentationRepository();
	private TimeFrameRepository timeFrameRepository = new TimeFrameRepository();
	private CampusRepository campusRepository = new CampusRepository();
	private LocationRepository locationRepository = new LocationRepository();
	private PresentationRepository attribute2 = new PresentationRepository();
	private TimeFrameRepository attribute3 = new TimeFrameRepository();
	private CampusRepository attribute4 = new CampusRepository();
	private LocationRepository attribute5 = new LocationRepository();

	public jfxtras.scene.control.agenda.Agenda.AppointmentImpl[] retrievePresentations() {
		// TODO - implement PlanningController.retrievePresentations
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param startTime
	 * @param endTime
	 * @param campus
	 * @param lokaal
	 * @param promotor
	 * @param coPromotor
	 * @param presentator
	 * @param onderwerp
	 * @param tijdstip
	 */
	public void createPresentation(String startTime, String endTime, String campus, String lokaal, String promotor, String coPromotor, String presentator, String onderwerp, String tijdstip) {
		// TODO - implement PlanningController.createPresentation
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param presentation
	 */
	public void removePresentation(Presentation presentation) {
		// TODO - implement PlanningController.removePresentation
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param planning
	 * @param visible
	 */
	public void changePlanningVisibility(Planning planning, boolean visible) {
		// TODO - implement PlanningController.changePlanningVisibility
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param planning
	 * @param startTime
	 * @param endTime
	 */
	public void registerVisibilityPeriod(Planning planning, java.sql.Timestamp startTime, java.sql.Timestamp endTime) {
		// TODO - implement PlanningController.registerVisibilityPeriod
		throw new UnsupportedOperationException();
	}

	public java.util.List<TimeFrame> retrieveTimeFrames() {
		// TODO - implement PlanningController.retrieveTimeFrames
		throw new UnsupportedOperationException();
	}

	public java.util.List<Campus> retrieveCampuses() {
		// TODO - implement PlanningController.retrieveCampuses
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param campus
	 */
	public java.util.List<Location> retrieveLocations(Campus campus) {
		// TODO - implement PlanningController.retrieveLocations
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param timeFrame
	 * @param campus
	 * @param lokaal
	 * @param promotor
	 * @param coPromotor
	 * @param presentator
	 * @param onderwerp
	 * @param tijdstip
	 */
	public void createPresentation(TimeFrame timeFrame, String campus, String lokaal, String promotor, String coPromotor, String presentator, String onderwerp, String tijdstip) {
		// TODO - implement PlanningController.createPresentation
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param planning
	 */
	public void notifyStakeHolders(Planning planning) {
		// TODO - implement PlanningController.notifyStakeHolders
		throw new UnsupportedOperationException();
	}

}