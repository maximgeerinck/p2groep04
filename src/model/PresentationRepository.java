package model;

import entity.GuestRequest;
import entity.Planning;
import entity.Presentation;
import entity.Promotor;
import entity.ResearchDomain;
import entity.TimeFrame;
import java.util.Calendar;
import java.util.List;
import java.util.List;
import javax.persistence.EntityManager;
import util.JPAUtil;

public class PresentationRepository extends Repository
{
    private List<Presentation> presentations;    
    
    /**
     * 
     * @param planning
     * @return 
     */
    public List<Presentation> findAllByPlanning(Planning planning) {
        getEm().getTransaction().begin();

        List<Presentation> presentations =  getEm().createQuery("SELECT p FROM " + Presentation.class.getSimpleName() + " p JOIN p.planning pl WHERE pl.id = :planning").setParameter("planning", planning.getId()).getResultList();
        getEm().getTransaction().commit();
        
        getEm().close();
        
        return presentations;
    }

    public Boolean findExistsByCalendarTimeFrame(Planning planning, Calendar calendar, TimeFrame timeFrame) {
        getEm().getTransaction().begin();

        Boolean exists = getEm().createQuery("SELECT p FROM " + Presentation.class.getSimpleName() + " p JOIN p.planning pl WHERE pl.id = :planning AND p.timeFrame = :timeframe AND p.date = :date").setParameter("timeframe", timeFrame).setParameter("planning", planning.getId()).setParameter("date", calendar.getTime()).getResultList().size() > 0;
        getEm().getTransaction().commit();
        
        getEm().close();
        
        return exists;
    }

    public List<Presentation> findAllByPlanningPromotor(Planning planning, Promotor promotor) {
        getEm().getTransaction().begin();

        List<Presentation> presentations =  getEm().createQuery("SELECT p FROM " + Presentation.class.getSimpleName() + " p JOIN p.planning pl WHERE pl.id = :planning AND p.promotor = :promotor OR p.coPromotor = :promotor").setParameter("planning", planning.getId()).setParameter("promotor", promotor).getResultList();
        getEm().getTransaction().commit();
        
        getEm().close();
        
        return presentations;
    }

    public List<Presentation> findAllByPlanningResearchdomain(Planning planning, ResearchDomain researchDomain) {
        getEm().getTransaction().begin();

        List<Presentation> presentations =  getEm().createQuery("SELECT p FROM " + Presentation.class.getSimpleName() + " p JOIN p.planning pl JOIN p.presentator u JOIN u.approvedSuggestion s WHERE pl.id = :planning AND s.researchDomain = :researchDomain").setParameter("planning", planning.getId()).setParameter("researchDomain", researchDomain).getResultList();
        getEm().getTransaction().commit();
        
        getEm().close();
        System.out.println(presentations.size());
        
        return presentations;
    }
}