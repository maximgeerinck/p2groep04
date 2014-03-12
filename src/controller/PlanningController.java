package controller;

import entity.Campus;
import entity.Location;
import entity.Planning;
import entity.Presentation;
import model.PresentationRepository;
import entity.TimeFrame;
import entity.User;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import jfxtras.scene.control.agenda.Agenda.AppointmentGroupImpl;
import jfxtras.scene.control.agenda.Agenda.AppointmentImpl;
import model.CampusRepository;
import model.LocationRepository;
import model.PlanningRepository;
import model.TimeFrameRepository;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;
import util.JPAUtil;
//import util.JPAUtil;

public class PlanningController 
{
    private PresentationRepository presentationRepository = new PresentationRepository();   
    private TimeFrameRepository timeFrameRepository = new TimeFrameRepository();
    private CampusRepository campusRepository = new CampusRepository();
    private LocationRepository locationRepository = new LocationRepository();
    private PlanningRepository planningRepository = new PlanningRepository();
    
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
     * @param timeFrame
     * @param startTime
     * @param endTime
     * @param campus
     * @param lokaal
     * @param promotor
     * @param coPromotor
     * @param presentator
     * @param date
     * @param onderwerp
     * @param tijdstip
     */
    public void createPresentation(TimeFrame timeFrame, String campus, String lokaal, String promotor, String coPromotor, String presentator, String onderwerp, String tijdstip, Date date) 
    {
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
             
                
        Presentation p = new Presentation();
         p.setTimeFrame(timeFrame);
         p.setDate(date);
         
         
        
                    



        manager.persist(p);
        manager.getTransaction().commit();
        manager.close();
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
    public void changePlanningVisibility(Planning planning, boolean visible) 
    {
        planning.setVisible(visible);
    }

    /**
     * 
     * @param planning
     * @param startTime
     * @param endTime
     */
    public void registerVisibilityPeriod(Planning planning, Timestamp startTime, Timestamp endTime) {
        planningRepository.changePlanningVisbilityPeriod(planning, startTime, endTime);
    }
    
    public Planning retrievePlanning(int id) 
    {
        return planningRepository.findOneById(id);
    }
    
    public void notifyStakeHolders(Planning planning){
        // TODO - implement
        /**
         * 
         */
        
        List<Presentation> presentations = new ArrayList<>();
        List<User> users = new ArrayList<>();
        
        presentations.addAll(planning.getPresentations());
        
        for(Presentation p: presentations)
        {
           if(p.isChanged()== true){
           users.add(p.getUser());
           users.addAll(p.getGuests()); 
           }
        }
        
        for(User u: users)
        {
            u.addNotification("The planning has been changed, please check the planning for more info.");
        }
        
            throw new UnsupportedOperationException();
    }
}