package model;

import entity.GuestRequest;
import entity.User;
import java.util.Collection;
import java.util.List;



public class UserRepository extends Repository
{
    private Collection<User> users;

    public List<User> findAllStudents() {
       return em.createQuery("SELECT u FROM " + User.class.getSimpleName() + " u JOIN u.roles r WHERE r.roleName = :role ORDER BY u.firstName").setParameter("role", User.ROLE_STUDENT).getResultList();
    }

    public List<User> findAllPromotors() {
        return em.createQuery("SELECT u FROM " + User.class.getSimpleName() + " u JOIN u.roles r WHERE r.roleName = :role ORDER BY u.firstName").setParameter("role", User.ROLE_PROMOTOR).getResultList();
    }

    /**
     * 
     * @param user
     */
    public List<GuestRequest> findGuestRequestsByUser(User user) {
            // TODO - implement UserRepository.findGuestRequestsByUser
            throw new UnsupportedOperationException();
    }	

    public User findBPC() 
    {
       return (User)em.createQuery("SELECT u FROM " + User.class.getSimpleName() + " u JOIN u.roles r WHERE r.roleName = :role ORDER BY u.firstName").setParameter("role", User.ROLE_BPC).getSingleResult();
    }
}