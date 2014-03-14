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
class Promotor {
    private List<Student> students;
    private int amountStudents;
    
    public void geefAantalStudenten(){
        amountStudents = students.size();
    }
}
