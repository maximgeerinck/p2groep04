package controller;
import jfxtras.scene.control.agenda.Agenda;
import entity.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;


public class PlanningController {

	/**
	 * 
	 * @param coPromotor
	 */
         
        public Agenda.AppointmentImpl[] retrievePresentations() 
        {
            
           Session session = HibernateUtil.getSessionFactory().getCurrentSession();
           List<Agenda.AppointmentImpl> presentaties = new ArrayList();
           Calendar cal = GregorianCalendar.getInstance();
           Calendar cal2 = GregorianCalendar.getInstance();

           session.beginTransaction();
        
            Query q = session.createQuery("SELECT p FROM " + Presentation.class.getSimpleName() + " p ORDER BY DAY(p.startTime) ASC");
            
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

            session.close();

            return presentaties.toArray(new Agenda.AppointmentImpl[presentaties.size()]);
        }
        
        public void addPresentation(String startTijd, String eindTijd, String campus, String lokaal, String promotor, String coPromotor, String presentator, String onderwerp, String tijdstip)
        {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            
            Presentation p = new Presentation();
            //p.setStartTime(new Timestamp(startTijd));
            //p.setEndTime(new Timestamp(eindTijd));            
            
            session.save(p);
            session.flush();
            session.close();
        }
        
        public void removePresentation(Presentation presentation)
        {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query q = session.createQuery("DELETE FROM Presentation WHERE id =" + presentation.getId() + ")");
            
            session.close();
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