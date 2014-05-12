package controller;

import model.*;
import entity.*;
import exceptions.DuplicateEntryException;
import exceptions.PersonHasPresentationException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import agenda.Agenda;
import agenda.Agenda.AppointmentImpl;

/**
 * import util.JPAUtil;
 */
public class PlanningController {

    private PresentationRepository presentationRepository = new PresentationRepository();
    private TimeFrameRepository timeFrameRepository = new TimeFrameRepository();
    private CampusRepository campusRepository = new CampusRepository();
    private LocationRepository locationRepository = new LocationRepository();
    private PlanningRepository planningRepository = new PlanningRepository();

    public AppointmentImpl[] retrievePresentations(Planning planning) 
    {
        List<AppointmentImpl> presentaties = new ArrayList();
        Calendar cal = GregorianCalendar.getInstance();
        Calendar cal2 = GregorianCalendar.getInstance();

        List<Presentation> presentations = presentationRepository.findAllByPlanning(planning);

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
                .withPresentation(p)
                .withStartTime(cal)
                .withEndTime(cal2)
                .withSummary(p.getPresentator().getFirstName() + " " + p.getPresentator().getLastName())
                .withDescription(p.getPresentator().getActiveSuggestion().toString())
                .withAppointmentGroup(new Agenda.AppointmentGroupImpl().withStyleClass("group15"))
            );
        }

        return presentaties.toArray(new AppointmentImpl[presentaties.size()]);
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

        EntityManager em = planningRepository.getEm();
        em.getTransaction().begin();

        em.remove(presentation);
        em.flush();
        em.getTransaction().commit();

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
    public void registerVisibilityPeriod(Planning planning, Calendar startTime, Calendar endTime) {
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
    public void createPresentation(Planning planning, Calendar calendar, TimeFrame timeFrame, Location lokaal, Student presentator) throws DuplicateEntryException, PersonHasPresentationException 
    {
        //check if presentation is already on this timeframe and date
        //if (presentationRepository.findExistsByCalendarTimeFrame(planning, calendar, timeFrame)) {
           // throw new IllegalArgumentException("Presentation already exists");
       // }
        
        if(presentationRepository.findPresentationDuplicate(planning, calendar, timeFrame, lokaal)){
            throw new DuplicateEntryException("There is another presentation on that place and time.");
        }
        
        if(presentationRepository.findPersonPresentation(planning, presentator)){
            throw new PersonHasPresentationException("This student already has a presentation.");
        }
        
        EntityManager em = planningRepository.getEm();
        em.getTransaction().begin();

        Presentation presentation = new Presentation();
        presentation.setDate(new Date(calendar.getTime().getTime()));
        presentation.setTimeFrame(timeFrame);
        presentation.setPresentator(presentator);
        presentation.setLocation(lokaal);
        presentation.setPlanning(planning);

        em.persist(presentation);
        em.flush();
        em.getTransaction().commit();
    }

    /**
     *
     * @param planning
     */
    public void notifyStakeHolders(Planning planning) {
        // TODO - implement PlanningController.notifyStakeHolders
        throw new UnsupportedOperationException();
    }
    
    public AppointmentImpl[] retrievePresentations(List<Presentation> presentations) 
    {
        List<AppointmentImpl> presentaties = new ArrayList();
        Calendar cal = GregorianCalendar.getInstance();
        Calendar cal2 = GregorianCalendar.getInstance();
        
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
                .withPresentation(p)
                .withStartTime(cal)
                .withEndTime(cal2)
                .withSummary(p.getPresentator().getFirstName() + " " + p.getPresentator().getLastName())
                .withDescription(p.getPresentator().getActiveSuggestion().toString())
                .withAppointmentGroup(new Agenda.AppointmentGroupImpl().withStyleClass("group15"))
            );
        }

        return presentaties.toArray(new AppointmentImpl[presentaties.size()]);
    }

    public void attachJury(Promotor promotor, Promotor coPromotor, Promotor jury, Presentation presentation) {
        EntityManager em = planningRepository.getEm();
        em.getTransaction().begin();

        presentation.setPromotor(promotor);
        presentation.setCoPromotor(coPromotor);
        presentation.setJuryLid(jury);

        em.getTransaction().commit();

        changePlanningVisibility(presentation.getPlanning(), true);

    }

}
