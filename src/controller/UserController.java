package controller;

import model.*;
import entity.*;
import java.util.List;

public class UserController {

	private UserRepository userRepository = new UserRepository();

	public List<Promotor> retrievePromotors() {
		 return userRepository.findAllPromotors();
	}

	public BPCoordinator retrieveBPC() {
		return userRepository.findBPC();
	}

	public List<Student> retrieveStudents() {
		return userRepository.findAllStudents();
	}

}