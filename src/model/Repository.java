package model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import util.JPAUtil;

/**
 * @author Maxim
 */
public abstract class Repository {

    protected EntityManager em;
    
    public EntityManager getEm() {
        if(em == null) {
            return JPAUtil.getEntityManager();
        }
        return em;
    }

}