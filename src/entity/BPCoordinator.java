/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.util.*;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("BPC")
public class BPCoordinator extends User {
    @OneToMany(mappedBy = "bpcoordinator", targetEntity = Planning.class)
    private List<Planning> plannings;

    public BPCoordinator() 
    {
    }
}
