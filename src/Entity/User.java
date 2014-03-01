/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import Model.AbstractUser;
import org.hibernate.annotations.Entity;

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
}
