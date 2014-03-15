/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.util.*;
import javax.persistence.Entity;

/**
 *
 * @author Bram
 */
@Entity
public class BPCoordinator extends User{

	private Collection<Planning> plannings;

	public BPCoordinator() {
		// TODO - implement BPCoordinator.BPCoordinator
		throw new UnsupportedOperationException();
	}
    
}
