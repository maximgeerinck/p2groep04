package controller;
import jfxtras.scene.control.agenda.Agenda;
import entity.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Query;
import org.hibernate.Session;
import util.JPAUtil;



public class PlanningController {

	/**
	 * 
	 * @param coPromotor
	 */
         
        public Agenda.AppointmentImpl[] retrievePresentations() 
        {
            
           EntityManager manager = JPAUtil.getEntityManagerFactory().createEntityManager();
           List<Agenda.AppointmentImpl> presentaties = new ArrayList();
           Calendar cal = GregorianCalendar.getInstance();
           Calendar cal2 = GregorianCalendar.getInstance();

           manager.getTransaction().begin();
        
            Query q = (Query) manager.createQuery("SELECT p FROM " + Presentation.class.getSimpleName() + " p ORDER BY DAY(p.startTime) ASC");
            
            for(Presentation p : (List<Presentation>)q.list())
            {
                cal = ((Calendar) cal.clone());
                cal.setTime(p.getStartTime());
                
                cal2 = ((Calendar) cal2.clone());
                cal2.setTime(p.getEndTime());
                
                presentaties.add(new Agenda.AppointmentImpl()
                    .withStartTime(cal)
                    .withEndTime(cal2)
                    .withSummary("")
                    .withDescription("")
                    .withAppointmentGroup(new Agenda.AppointmentGroupImpl().withStyleClass("group15"))        
                );
            }

            manager.getTransaction().commit();
            manager.close();

            return presentaties.toArray(new Agenda.AppointmentImpl[presentaties.size()]);
        }
        
        public void addPresentation(String campus, String lokaal, String promotor, String coPromotor, String presentator, String onderwerp, String tijdstip)
        {
            EntityManager manager = JPAUtil.getEntityManagerFactory().createEntityManager();
            manager.getTransaction().begin();
            
            Presentation p = new Presentation();
            //p.setStartTime(new Timestamp(startTijd));
            //p.setEndTime(new Timestamp(eindTijd));            
            
            
            
            manager.persist(p);
            manager.getTransaction().commit();
            manager.close();
        }
        
        public void removePresentation(Presentation presentation)
        {
            EntityManager manager = JPAUtil.getEntityManagerFactory().createEntityManager();
            manager.getTransaction().begin();
            Query q = (Query) manager.createQuery("DELETE FROM Presentation WHERE id =" + presentation.getId() + ")");
            
            manager.getTransaction().commit();
            manager.close();
        }
    
	public Planning filterOnCopromotor(User coPromotor) {
		// TODO - implement PlanningController.filterOnCopromotor
		throw new UnsupportedOperationException();
	}

	public Planning filterOnAvailable() {
		// TODO - implement PlanningController.filterOnAvailable
		throw new UnsupportedOperationException();
	}

}