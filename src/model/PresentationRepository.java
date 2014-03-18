package model;

import entity.GuestRequest;
import entity.Planning;
import entity.Presentation;
import entity.Promotor;
import entity.ResearchDomain;
import entity.TimeFrame;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import util.JPAUtil;

public class PresentationRepository extends Repository
{
    private Collection<Presentation> presentations;    
    /**
     * 
     * @param presentation
     */
    public List<GuestRequest> findGuestRequestsByPresentation(Presentation presentation) {
            // TODO - implement PresentationRepository.findGuestRequestsByPresentation
            throw new UnsupportedOperationException();
    }
    
    /**
     * 
     * @param planning
     * @return 
     */
    public List<Presentation> findAllByPlanning(Planning planning) {
        getEm().getTransaction().begin();

        List<Presentation> presentations =  getEm().createQuery("SELECT p FROM " + Presentation.class.getSimpleName() + " p JOIN p.planning pl WHERE pl.id = 1").getResultList();
        getEm().getTransaction().commit();
        
        getEm().close();
        
        return presentations;
    }

    public Boolean findExistsByCalendarTimeFrame(Calendar calendar, TimeFrame timeFrame) {
        getEm().getTransaction().begin();

        Boolean exists = getEm().createQuery("SELECT p FROM " + Presentation.class.getSimpleName() + " p JOIN p.planning pl WHERE pl.id = 1 AND p.timeFrame = :timeframe AND p.date = :date").setParameter("timeframe", timeFrame).setParameter("date", calendar.getTime()).getResultList().size() > 0;
        getEm().getTransaction().commit();
        
        getEm().close();
        
        return exists;
    }

    public List<Presentation> findAllByPlanningPromotor(Planning findOneById, Promotor promotor) {
        getEm().getTransaction().begin();

        List<Presentation> presentations =  getEm().createQuery("SELECT p FROM " + Presentation.class.getSimpleName() + " p JOIN p.planning pl WHERE pl.id = 1 AND p.promotor = :promotor OR p.coPromotor = :promotor").setParameter("promotor", promotor).getResultList();
        getEm().getTransaction().commit();
        
        getEm().close();
        
        return presentations;
    }

    public List<Presentation> findAllByPlanningResearchdomain(Planning findOneById, ResearchDomain researchDomain) {
        getEm().getTransaction().begin();

        List<Presentation> presentations =  getEm().createQuery("SELECT p FROM " + Presentation.class.getSimpleName() + " p JOIN p.planning pl JOIN p.presentator u JOIN u.approvedSuggestion s WHERE pl.id = 1 AND s.researchDomain = :researchDomain").setParameter("researchDomain", researchDomain).getResultList();
        getEm().getTransaction().commit();
        
        getEm().close();
        System.out.println(presentations.size());
        
        return presentations;
    }
}