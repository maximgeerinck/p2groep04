package model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Maxim
 */
public abstract class Repository {

        @PersistenceContext
	protected EntityManager em;

}