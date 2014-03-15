package util;

import javax.persistence.EntityManager;

/**
 * @author Maxim
 */
public class JPAUtil {

	private static javax.persistence.EntityManagerFactory entityManagerFactory;
	private static final String PERSISTENCE_UNIT_NAME = "school";
	private static ThreadLocal<javax.persistence.EntityManager> manager = new ThreadLocal<EntityManager>();

	private JPAUtil() {
		// TODO - implement JPAUtil.JPAUtil
		throw new UnsupportedOperationException();
	}

	public static synchronized javax.persistence.EntityManager getEntityManager() {
		// TODO - implement JPAUtil.getEntityManager
		throw new UnsupportedOperationException();
	}

	public static void closeEntityManager() {
		// TODO - implement JPAUtil.closeEntityManager
		throw new UnsupportedOperationException();
	}

	public static void closeEntityManagerFactory() {
		// TODO - implement JPAUtil.closeEntityManagerFactory
		throw new UnsupportedOperationException();
	}

}