/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.util.List;

/**
 *
 * @author Samsung
 */
public class BPCoordinator {
    private List<Student> selectedStudents;
    private Promotor promotor;

    public void selectPromotor(Promotor promotor) {
            this.promotor = promotor;
    }

    public void selectStudent(Student student) {
            selectedStudents.add(student);
    }
}
