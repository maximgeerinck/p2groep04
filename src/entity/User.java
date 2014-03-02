/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.sql.Timestamp;
import model.AbstractUser;
import javax.persistence.Entity;
import javax.persistence.PrePersist;

/**
 *
 * @author Bram
 */
@Entity
public class User extends AbstractUser
{
    public User() 
    {
        super();
    }
    
    @PrePersist
    public void onCreate() 
    {
        java.util.Date date= new java.util.Date();
        this.createdOn = new Timestamp(date.getTime());
    }
}
