package controller;

import entity.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import jfxtras.scene.control.agenda.Agenda;
import util.JPAUtil;
//import util.JPAUtil;

public class PlanningController 
{
	public Agenda.AppointmentImpl[] retrievePresentations() 
        {
            EntityManager em = JPAUtil.getEntityManager();
            List<Agenda.AppointmentImpl> presentaties = new ArrayList();
            Calendar cal = GregorianCalendar.getInstance();
            Calendar cal2 = GregorianCalendar.getInstance();

            em.getTransaction().begin();

            List<Presentation> presentations =  em.createQuery("SELECT p FROM " + Presentation.class.getSimpleName() + " p").getResultList();
            em.getTransaction().commit();
             for(Presentation p : presentations)
             {
                 cal = ((Calendar) cal.clone());
                 cal.setTime(p.getTimeFrame().getStartTime());

                 cal2 = ((Calendar) cal2.clone());
                 cal2.setTime(p.getTimeFrame().getEndTime());

                 presentaties.add(new Agenda.AppointmentImpl()
                     .withStartTime(cal)
                     .withEndTime(cal2)
                     .withSummary("")
                     .withDescription("")
                     .withAppointmentGroup(new Agenda.AppointmentGroupImpl().withStyleClass("group15"))        
                 );
             }

            
             em.close();
             return presentaties.toArray(new Agenda.AppointmentImpl[presentaties.size()]);
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