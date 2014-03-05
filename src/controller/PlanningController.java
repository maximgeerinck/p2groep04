package controller;
import jfxtras.scene.control.agenda.Agenda;
import entity.*;
import java.sql.Array;
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
         
        public Agenda.AppointmentImpl[] retrievePresentations() {
            
           Session session = HibernateUtil.getSessionFactory().getCurrentSession();
           List<Agenda.AppointmentImpl> presentaties = new ArrayList();
           Agenda.AppointmentImpl[] presentations = new Agenda.AppointmentImpl[0];
           Calendar cal = GregorianCalendar.getInstance();
           Calendar cal2 = GregorianCalendar.getInstance();
           
           
           session.beginTransaction();
        
        Query q = session.createQuery("SELECT p FROM " + Presentation.class.getSimpleName() + " p ORDER BY DAY(p.startTime) ASC");
        for(Presentation p : (List<Presentation>)q.list())
        {
            cal.setTime(p.getStartTime());
            cal2.setTime(p.getEndTime());
            presentaties.add(new Agenda.AppointmentImpl()
            .withStartTime(cal)
            .withEndTime(cal2)
            .withSummary("")
            .withDescription("")
            );
        }
        
        session.close();
        
        presentations = presentaties.toArray(presentations);
        return presentations;
        }
        
        public void addPresentation(Presentation presentation){
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query q = session.createQuery("INSERT INTO Presentation(begin_time, end_time, location) VALUES ("+ 
                    presentation.getStartTime() +"," + presentation.getEndTime()
                    +"," +presentation.getLocation()+")");
            
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