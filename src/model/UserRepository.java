package model;

import entity.BPCoordinator;
import entity.GuestRequest;
import entity.Promotor;
import entity.Student;
import entity.User;
import java.util.Collection;
import java.util.List;



public class UserRepository extends Repository
{
    private Collection<User> users;

    public List<Student> findAllStudents() {
       return em.createQuery("SELECT u FROM " + Student.class.getSimpleName()).getResultList();
    }

    public List<Promotor> findAllPromotors() {
        return em.createQuery("SELECT u FROM " + Promotor.class.getSimpleName()).getResultList();
    }
    public User findUserById(int id)
    {
        return (User)em.createQuery("SELECT u FROM" + User.class.getSimpleName() + "WHERE id=" + id +";").getSingleResult();
    }

    /**
     * 
     * @param user
     */
    public List<GuestRequest> findGuestRequestsByUser(User user) {
            // TODO - implement UserRepository.findGuestRequestsByUser
            throw new UnsupportedOperationException();
    }	

    public BPCoordinator findBPC() 
    {
       return (BPCoordinator)em.createQuery("SELECT u FROM " + BPCoordinator.class.getSimpleName()).getSingleResult();
    }
}