package controller;

import entity.Campus;
import entity.Location;
import entity.Planning;
import entity.Presentation;
import model.PresentationRepository;
import entity.TimeFrame;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import jfxtras.scene.control.agenda.Agenda.AppointmentGroupImpl;
import jfxtras.scene.control.agenda.Agenda.AppointmentImpl;
import model.CampusRepository;
import model.LocationRepository;
import model.TimeFrameRepository;
//import util.JPAUtil;

public class PlanningController 
{
    private PresentationRepository presentationRepository = new PresentationRepository();   
    private TimeFrameRepository timeFrameRepository = new TimeFrameRepository();
    private CampusRepository campusRepository = new CampusRepository();
    private LocationRepository locationRepository = new LocationRepository();
    
    public AppointmentImpl[] retrievePresentations() 
    {
        
        List<AppointmentImpl> presentaties = new ArrayList();
        Calendar cal = GregorianCalendar.getInstance();
        Calendar cal2 = GregorianCalendar.getInstance();

        List<Presentation> presentations = presentationRepository.findAllByPlanning(null);
        
        for(Presentation p : presentations)
        {
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
                .withAppointmentGroup(new AppointmentGroupImpl().withStyleClass("group15"))        
            );
        }
        
        return presentaties.toArray(new AppointmentImpl[presentaties.size()]);
    }
    
    public List<TimeFrame> retrieveTimeFrames() 
    {
        return timeFrameRepository.findAll();
    }
    
    public List<Campus> retrieveCampuses() 
    {
        return campusRepository.findAll();
    }
    
    public List<Location> retrieveLocations(Campus campus) {
        return locationRepository.findByCampus(campus);
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
    public void createPresentation(String startTime, String endTime, String campus, String lokaal, String promotor, String coPromotor, String presentator, String onderwerp, String tijdstip) 
    {
       /* EntityManager manager = JPAUtil.getEntityManagerFactory().createEntityManager();
        manager.getTransaction().begin();

        Presentation p = new Presentation();
        //p.setStartTime(new Timestamp(startTijd));
        //p.setEndTime(new Timestamp(eindTijd));            



        manager.persist(p);
        manager.getTransaction().commit();
        manager.close();*/
    }

    /**
     * 
     * @param presentation
     */
    public void removePresentation(Presentation presentation) 
    {
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
            // TODO - implement PlanningController.changePlanningVisibility
            throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param planning
     * @param startTime
     * @param endTime
     */
    public void registerVisibilityPeriod(Planning planning, Timestamp startTime, Timestamp endTime) {
            // TODO - implement PlanningController.registerVisibilityPeriod
            throw new UnsupportedOperationException();
    }
}