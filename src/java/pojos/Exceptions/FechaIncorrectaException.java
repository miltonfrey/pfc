/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos.Exceptions;


public class FechaIncorrectaException extends Exception{
    
    String message;
    public FechaIncorrectaException(String message){
        
        super(message);
    }
    
}
