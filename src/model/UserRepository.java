package model;

import entity.BPCoordinator;
import entity.GuestRequest;
import entity.Presentation;
import entity.Promotor;
import entity.Student;
import entity.User;
import java.util.List;
import java.util.List;



public class UserRepository extends Repository
{
    private List<User> users;

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
    	

    public BPCoordinator findBPC() 
    {
       return (BPCoordinator)getEm().createQuery("SELECT u FROM " + BPCoordinator.class.getSimpleName()).getSingleResult();
    }

    public List<Student> findStudentByPromotor(Promotor promotor) 
    {
        return getEm().createQuery("SELECT s FROM Promotor p JOIN p.students s WHERE p.id = :promotor").setParameter("promotor", promotor.getId()).getResultList();
    }
    
    public Promotor findPromotorByStudent(Student student) 
    {
        return (Promotor)getEm().createQuery("SELECT s FROM Promotor p JOIN p.students s WHERE s.id = :student").setParameter("student", student.getId()).getSingleResult();
    }
    
    public List<Student> findAllNonAssignedStudents() 
    {
        return getEm().createQuery("SELECT s FROM Student s LEFT JOIN s.promotor p GROUP BY s HAVING COUNT(p) = 0").getResultList();
    }
    
    public List<Student> findAllNonAssignedStudentsJury() 
    {
        return getEm().createQuery("SELECT p.presentator FROM Presentation p WHERE p.juryLid IS NULL").getResultList();
        //return getEm().createQuery("SELECT s FROM Presentation p INNER JOIN Student s WHERE p.juryLid IS NULL").getResultList();
    }
    
    public List<Student> findAssignedStudentsJury(Promotor jury) 
    {
        return getEm().createQuery("SELECT p.presentator FROM Presentation p WHERE p.juryLid = :jury").setParameter("jury", jury).getResultList();
        //return getEm().createQuery("SELECT s FROM Presentation p JOIN Student s WHERE p.juryLid.id = :jury").setParameter("jury", jury.getId()).getResultList();
    }
    
    public void assignStudent(Student student, Promotor promotor) 
    {
        getEm().getTransaction().begin();
        promotor.getStudents().add(student);
        getEm().getTransaction().commit();    
    }
    
    public void unassignStudent(Student student, Promotor promotor) 
    {
        getEm().getTransaction().begin();
        promotor.getStudents().remove(student);
        getEm().getTransaction().commit();               
    } 

    public void changePresentator(Presentation presentation, Student student) {
        getEm().getTransaction().begin();
        presentation.setPresentator(student);
        getEm().getTransaction().commit();
    }
}