/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exceptions;

/**
 *
 * @author Roy
 */
public class InvalidJuryMemberException extends Exception {
    public InvalidJuryMemberException(String message)
    {
        super(message);
    }
}
