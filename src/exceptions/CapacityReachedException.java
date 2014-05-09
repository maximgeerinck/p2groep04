/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exceptions;

/**
 *
 * @author Maxim
 */
public class CapacityReachedException extends Exception 
{
    public CapacityReachedException(String message) {
        super(message);
    }       
}
