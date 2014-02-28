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
public class Planning 
{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private int visable;
    @Temporal(TemporalType.TIME)
    private DateTime startTime;
    @Temporal(TemporalType.TIME)
    private DateTime endTime;
    private String allowedToView;
    private int createdBy;
    
    @ManyToMany
    private List<Presentation> presentations;
    
    @OneToOne
    private User user;
}
