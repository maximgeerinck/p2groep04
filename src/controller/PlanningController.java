package controller;

import model.*;
import entity.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import jfxtras.scene.control.agenda.Agenda;
import jfxtras.scene.control.agenda.Agenda.AppointmentImpl;

/**
 * import util.JPAUtil;
 */
public class PlanningController {

    private PresentationRepository presentationRepository;
    private TimeFrameRepository timeFrameRepository;
    private CampusRepository campusRepository;
    private LocationRepository locationRepository;
    private PlanningRepository planningRepository;

    public AppointmentImpl[] retrievePresentations() {
        List<AppointmentImpl> presentaties = new ArrayList();
        Calendar cal = GregorianCalendar.getInstance();
        Calendar cal2 = GregorianCalendar.getInstance();

        List<Presentation> presentations = presentationRepository.findAllByPlanning(planningRepository.findOneById(1));

        for (Presentation p : presentations) {
            cal = ((Calendar) cal.clone());
            cal.setTime(p.getDate());
            cal.set(Calendar.HOUR_OF_DAY, p.getTimeFrame().getStartTime().getHours());
            cal.set(Calendar.MINUTE, p.getTimeFrame().getStartTime().getMinutes());

            cal2 = ((Calendar) cal2.clone());
            cal2.setTime(p.getDate());
            cal2.set(Calendar.HOUR_OF_DAY, p.getTimeFrame().getEndTime().getHours());
            cal2.set(Calendar.MINUTE, p.getTimeFrame().getEndTime().getMinutes());

            presentaties.add(new AppointmentImpl()
                    .withStartTime(cal)
                    .withEndTime(cal2)
                    .withSummary("")
                    .withDescription("")
                    .withAppointmentGroup(new Agenda.AppointmentGroupImpl().withStyleClass("group15"))
            );
        }

        return presentaties.toArray(new AppointmentImpl[presentaties.size()]);
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
        /*EntityManager manager = JPAUtil.getEntityManager();
         manager.getTransaction().begin();

         //De gegevens van de campus setten
         Campus deCampus = new Campus();
         deCampus.setName(campus);

         //De gegevens van het lokaal en campus setten
         Location location = new Location();
         location.setClassroom(lokaal);
         location.setCampus(deCampus);

         //Het onderwerp setten
         Suggestion suggestion = new Suggestion();
         suggestion.setSubject(onderwerp);
         suggestion.setUser(null);



         Presentation p = new Presentation();

         List<User> promotors = new ArrayList<>();

         promotors.add(userRepository.findUserById(promotor));
         promotors.add(userRepository.findUserById(coPromotor));

         p.setUser(userRepository.findUserById(presentator));
         p.setPromotors(promotors);
         p.setTimeFrame(timeFrame);
         p.setDate(date);
         p.setLocation(location);


         manager.persist(p);
         manager.getTransaction().commit();
         manager.close();
         */
    }

    /**
     *
     * @param presentation
     */
    public void removePresentation(Presentation presentation) {
       //TODO: delete methode naar repository brengen
       /* EntityManager manager = JPAUtil.getEntityManagerFactory().createEntityManager();
         manager.getTransaction().begin();
         Query q = (Query) manager.createQuery("DELETE FROM Presentation WHERE id =" + presentation.getId() + ")");

         manager.getTransaction().commit();
         manager.close();*/
    }

    /**
     *
     * @param planning
     * @param visible
     */
    public void changePlanningVisibility(Planning planning, boolean visible) {
        planning.setVisible(visible);
    }

    /**
     *
     * @param planning
     * @param startTime
     * @param endTime
     */
    public void registerVisibilityPeriod(Planning planning, java.sql.Timestamp startTime, java.sql.Timestamp endTime) {
         planningRepository.changePlanningVisbilityPeriod(planning, startTime, endTime);
    }

    public List<TimeFrame> retrieveTimeFrames() {
        return timeFrameRepository.findAll();
    }

    public List<Campus> retrieveCampuses() {
        return campusRepository.findAll();
    }

    /**
     *
     * @param campus
     */
    public List<Location> retrieveLocations(Campus campus) {
        return locationRepository.findByCampus(campus);
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
