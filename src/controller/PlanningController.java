package controller;

import model.*;
import entity.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import jfxtras.scene.control.agenda.Agenda;
import jfxtras.scene.control.agenda.Agenda.AppointmentImpl;

/**
 * import util.JPAUtil;
 */
public class PlanningController {

    private PresentationRepository presentationRepository = new PresentationRepository();
    private TimeFrameRepository timeFrameRepository = new TimeFrameRepository();
    private CampusRepository campusRepository = new CampusRepository();
    private LocationRepository locationRepository = new LocationRepository();
    private PlanningRepository planningRepository = new PlanningRepository();

    public AppointmentImpl[] retrievePresentations(long planningId) 
    {
        List<AppointmentImpl> presentaties = new ArrayList();
        Calendar cal = GregorianCalendar.getInstance();
        Calendar cal2 = GregorianCalendar.getInstance();

        List<Presentation> presentations = presentationRepository.findAllByPlanning(planningRepository.findOneById(planningId));

        for (Presentation p : presentations) {
            cal = ((Calendar) cal.clone());
            cal.setTime(p.getDate());
            cal.set(Calendar.HOUR_OF_DAY, p.getTimeFrame().getStartTime().getHours());
            cal.set(Calendar.MINUTE, p.getTimeFrame().getStartTime().getMinutes());

            cal2 = ((Calendar) cal2.clone());
            cal2.setTime(p.getDate());
            cal2.set(Calendar.HOUR_OF_DAY, p.getTimeFrame().getEndTime().getHours());
            cal2.set(Calendar.MINUTE, p.getTimeFrame().getEndTime().getMinutes());

            presentaties.add(new PresentationProperty()
                .withPresentation(p)
                .withStartTime(cal)
                .withEndTime(cal2)
                .withSummary(p.getPresentator().getFirstName() + " " + p.getPresentator().getLastName())
                .withDescription(p.getPresentator().getActiveSuggestion().toString())
                .withAppointmentGroup(new Agenda.AppointmentGroupImpl().withStyleClass("group15"))
            );
        }

        return presentaties.toArray(new PresentationProperty[presentaties.size()]);
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
    public void createPresentation(Planning planning, Calendar calendar, TimeFrame timeFrame, Location lokaal, Student presentator) 
    {
        //check if presentation is already on this timeframe and date
        if (presentationRepository.findExistsByCalendarTimeFrame(planning, calendar, timeFrame)) {
            throw new IllegalArgumentException("Presentation already exists");
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

    
    public AppointmentImpl[] retrievePresentationsByPromotor(Promotor promotor) {
        List<AppointmentImpl> presentaties = new ArrayList();
        Calendar cal = GregorianCalendar.getInstance();
        Calendar cal2 = GregorianCalendar.getInstance();

        List<Presentation> presentations = presentationRepository.findAllByPlanningPromotor(planningRepository.findOneById(1), promotor);

        for (Presentation p : presentations) {
            cal = ((Calendar) cal.clone());
            cal.setTime(p.getDate());
            cal.set(Calendar.HOUR_OF_DAY, p.getTimeFrame().getStartTime().getHours());
            cal.set(Calendar.MINUTE, p.getTimeFrame().getStartTime().getMinutes());

            cal2 = ((Calendar) cal2.clone());
            cal2.setTime(p.getDate());
            cal2.set(Calendar.HOUR_OF_DAY, p.getTimeFrame().getEndTime().getHours());
            cal2.set(Calendar.MINUTE, p.getTimeFrame().getEndTime().getMinutes());

            presentaties.add(new PresentationProperty()
                .withPresentation(p)
                .withStartTime(cal)
                .withEndTime(cal2)
                .withSummary(p.getPresentator().getFirstName() + " " + p.getPresentator().getLastName())
                .withDescription(p.getPresentator().getActiveSuggestion().toString())
                .withAppointmentGroup(new Agenda.AppointmentGroupImpl().withStyleClass("group15"))
            );
        }

        return presentaties.toArray(new PresentationProperty[presentaties.size()]);
    }

    public AppointmentImpl[] retrievePresentationsByResearchdomain(ResearchDomain researchDomain) {
        List<AppointmentImpl> presentaties = new ArrayList();
        Calendar cal = GregorianCalendar.getInstance();
        Calendar cal2 = GregorianCalendar.getInstance();

        List<Presentation> presentations = presentationRepository.findAllByPlanningResearchdomain(planningRepository.findOneById(1), researchDomain);

        for (Presentation p : presentations) {
            cal = ((Calendar) cal.clone());
            cal.setTime(p.getDate());
            cal.set(Calendar.HOUR_OF_DAY, p.getTimeFrame().getStartTime().getHours());
            cal.set(Calendar.MINUTE, p.getTimeFrame().getStartTime().getMinutes());

            cal2 = ((Calendar) cal2.clone());
            cal2.setTime(p.getDate());
            cal2.set(Calendar.HOUR_OF_DAY, p.getTimeFrame().getEndTime().getHours());
            cal2.set(Calendar.MINUTE, p.getTimeFrame().getEndTime().getMinutes());

            presentaties.add(new PresentationProperty()
                .withPresentation(p)
                .withStartTime(cal)
                .withEndTime(cal2)
                .withSummary(p.getPresentator().getFirstName() + " " + p.getPresentator().getLastName())
                .withDescription(p.getPresentator().getActiveSuggestion().toString())
                .withAppointmentGroup(new Agenda.AppointmentGroupImpl().withStyleClass("group15"))
            );
        }

        return presentaties.toArray(new PresentationProperty[presentaties.size()]);
    }

    public void attachJury(Promotor promotor, Promotor coPromotor, Presentation presentation) {
        EntityManager em = planningRepository.getEm();
        em.getTransaction().begin();

        presentation.setPromotor(promotor);
        presentation.setCoPromotor(coPromotor);

        
        em.getTransaction().commit();

        changePlanningVisibility(presentation.getPlanning(), true);

    }

}
