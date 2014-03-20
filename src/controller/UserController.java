package controller;

import model.*;
import entity.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

public class UserController {

    private UserRepository userRepository = new UserRepository();
    private final int MAX_AANTAL_STUDENTEN = 20;
    

    public List<Promotor> retrievePromotors() {
        return userRepository.findAllPromotors();
    }

    public BPCoordinator retrieveBPC() {
        return userRepository.findBPC();
    }

    public List<Student> retrieveStudents() {
        return userRepository.findAllStudents();
    }

    public void attachPromotorToStudent(Student student, Promotor promotor) {

        if (promotor.getAmountOfStudents() > MAX_AANTAL_STUDENTEN) {
            throw new IllegalArgumentException("This promotor has reached his maximum capacity of students it may have.");
        }

        if(promotor == null || student == null)
        {
            throw new IllegalArgumentException("One of the objects was null.");
        }
        
        EntityManager em = userRepository.getEm();
        em.getTransaction().begin();

        student.getPromotors().add(promotor);
        promotor.getStudents().add(student);
        promotor.setAmountOfStudents(promotor.getAmountOfStudents() + 1);
 
        em.getTransaction().commit();

    }

    public void detachPromotorFromStudent(Student student, Promotor promotor) {
        if(promotor.getAmountOfStudents() == 0)
        {
            throw new IllegalArgumentException("There are no students.");
        }
        
        EntityManager em = userRepository.getEm();
        em.getTransaction().begin();

        student.getPromotors().remove(promotor);
        promotor.getStudents().remove(student);
        promotor.setAmountOfStudents(promotor.getAmountOfStudents() - 1);
        
        em.getTransaction().commit();
        
    }
    

}
