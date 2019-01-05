/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decisionmaker;

/**
 *
 * @author Kali
 */
public class NoAirportSpecifiedException extends Exception {
    public NoAirportSpecifiedException(){
        super("\nNo Airport specified.. Please specify airport code while creating instance of decision maker");
    }
}
