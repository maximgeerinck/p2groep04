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
       return getEm().createQuery("SELECT s FROM " + Student.class.getSimpleName() + " s").getResultList();
    }

    public List<Promotor> findAllPromotors() {
        return getEm().createQuery("SELECT p FROM " + Promotor.class.getSimpleName() + " p").getResultList();
    }
    
    public User findUserById(int id)
    {
        return (User)getEm().createQuery("SELECT u FROM" + User.class.getSimpleName() + "WHERE id=" + id +";").getSingleResult();
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
       return (BPCoordinator)getEm().createQuery("SELECT u FROM " + BPCoordinator.class.getSimpleName()).getSingleResult();
    }
    
    
}