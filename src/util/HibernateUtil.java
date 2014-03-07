package util;

/**
 * @author Maxim
 */
public class HibernateUtil {

	private static final org.hibernate.SessionFactory sessionFactory = util.HibernateUtil.buildSessionFactory();

	public org.hibernate.SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	private static org.hibernate.SessionFactory buildSessionFactory() {
		// TODO - implement HibernateUtil.buildSessionFactory
		throw new UnsupportedOperationException();
	}

}