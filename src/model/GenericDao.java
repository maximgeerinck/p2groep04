package model;

public interface GenericDao<T> {

	List<T> findAll();

	/**
	 * 
	 * @param object
	 */
	T update(T object);

	/**
	 * 
	 * @param id
	 */
	T get(Long id);

	/**
	 * 
	 * @param object
	 */
	void delete(T object);

	/**
	 * 
	 * @param object
	 */
	void insert(T object);

	/**
	 * 
	 * @param id
	 */
	boolean exists(Long id);

}