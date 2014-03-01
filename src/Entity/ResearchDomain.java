/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.apache.derby.client.am.DateTime;
import org.hibernate.annotations.Entity;

/**
 *
 * @author Bram
 */
@Entity
public class ResearchDomain 
{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String name;
    @Temporal(TemporalType.TIMESTAMP)
    private DateTime createdOn;
}
