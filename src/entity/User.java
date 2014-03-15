/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.sql.Timestamp;
import java.util.List;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Maxim
 */
@MappedSuperclass
public abstract class User 
{
    protected int id;
    
    protected String email;
    
    protected String lastName;
    
    protected String password;
    
    protected String salt;
    
    protected Timestamp LastLogin;
    
    protected String lastIp;
    
    protected Timestamp createdOn;
    
    protected Timestamp updatedOn;
    
    protected int enabled;
    
    protected List<Presentation> presentationsAttending;
    
    protected List<Planning> plannings;
    
    
}
