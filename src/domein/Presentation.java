/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domein;


import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;
import org.hibernate.annotations.Entity;

/**
 *
 * @author Bram
 */
@Entity
public class Presentation 
{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @Temporal(TemporalType.TIME)
    private DateTime beginTime;
    @Temporal(TemporalType.TIME)
    private DateTime endTime;
    
    @ManyToOne
    private Location location;
    private int locationId;
    
    @ManyToMany
    private List<User> users;
    
    @ManyToMany(mappedBy = "presentations")
    private List<Planning> plannings;
    
}
