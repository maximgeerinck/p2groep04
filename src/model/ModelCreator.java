package model;

import de.jaret.util.date.JaretDate;
import de.jaret.util.ui.timebars.model.TimeBarModel;
import entity.Presentation;
import java.util.Calendar;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.joda.time.DateTime;
import util.HibernateUtil;

public class ModelCreator {
    
    static Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    
    public static TimeBarModel createCalendarModel() 
    {
        CalendarModel model = new CalendarModel();

        model.createMonth(3, 2014);
        
        session.beginTransaction();
        
        Query q = session.createQuery("SELECT p FROM " + Presentation.class.getSimpleName() + " p ORDER BY DAY(p.startTime) ASC");
        
        
        for(Presentation p : (List<Presentation>)q.list())
        {
            // get the day      
            DateTime dateTime = new DateTime(p.getStartTime().getTime());
            
            Day day = model.getDay(new JaretDate(p.getStartTime().getTime()));
            // schedule a presentation
            p.setEditable(false);
            day.addInterval(p);
            
        }
        session.close();
        
        return model;
    }

}
