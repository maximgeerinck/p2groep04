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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;
import org.hibernate.annotations.Entity;

/**
 *
 * @author Bram
 */
@Entity
public class User 
{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String email;
    private String fistName;
    private String lastName;
    private String password;
    private String salt;
    @Temporal(TemporalType.TIMESTAMP)
    private DateTime lastLogin;
    private String lastIp;
    @Temporal(TemporalType.TIMESTAMP)
    private DateTime createdOn;
    @Temporal(TemporalType.TIMESTAMP)
    private DateTime updatedOn;
    private int enabled;
    private int amountStudents;
    private String roles;
    
    @ManyToMany(mappedBy = "users")
    private List<Presentation> presentations;
    
    @OneToOne(mappedBy = "user")
    private Planning planning;
}
