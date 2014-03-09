package model;

import entity.GuestRequest;
import entity.Location;
import entity.User;
import java.util.Collection;
import java.util.List;



public class UserRepository extends Repository
{
    private Collection<User> users;

    public List<User> findAllStudents() {
        return em.createQuery("SELECT u FROM " + User.class.getSimpleName() + " u LEFT JOIN u.roles r WHERE r.name = :role").setParameter("role", "ROLE_STUDENT").getResultList();
    }

    public List<User> findAllPromotors() {
        return em.createQuery("SELECT u FROM " + User.class.getSimpleName() + " u LEFT JOIN u.roles r WHERE r.name = :role").setParameter("role", "ROLE_PROMOTOR").getResultList();
    }

    /**
     * 
     * @param user
     */
    public List<GuestRequest> findGuestRequestsByUser(User user) {
            // TODO - implement UserRepository.findGuestRequestsByUser
            throw new UnsupportedOperationException();
    }	
}