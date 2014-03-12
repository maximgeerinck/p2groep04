package model;

import entity.GuestRequest;
import entity.Planning;
import entity.Presentation;
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
        em.getTransaction().begin();

        List<Presentation> presentations =  em.createQuery("SELECT p FROM " + Presentation.class.getSimpleName() + " p JOIN p.planning pl WHERE pl.id = 1").getResultList();
        em.getTransaction().commit();
        
        em.close();
        
        return presentations;
    }
}