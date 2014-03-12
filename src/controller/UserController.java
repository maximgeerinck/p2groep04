package controller;

import entity.User;
import java.util.List;
import model.UserRepository;

public class UserController 
{
    
    private UserRepository userRepository = new UserRepository();
    
    public List<User> retrievePromotors()
    {
        return userRepository.findAllPromotors();
    }
    
    public User retrieveBPC() 
    {
        return userRepository.findBPC();
    }
    
    public List<User> retrieveStudents() 
    {
        return userRepository.findAllStudents();
    }
}