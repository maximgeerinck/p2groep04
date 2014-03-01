/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import javax.persistence.ManyToOne;
import org.hibernate.annotations.Entity;

/**
 *
 * @author Bram
 */
@Entity
public class UserPresentation 
{
    @ManyToOne
    private int presentationId;
    
    @ManyToOne
    private int userId;
    
    @ManyToOne
    private int planningId;
}
