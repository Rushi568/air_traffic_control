/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.schedule;

import org.json.JSONObject;

/**
 *
 * @author Kali
 */
public class Flight {
    private Identification identification;
    private Aircraft aircraft;
    private Owner owner;
    private Airline airline;
    
    public Flight(JSONObject flight)throws Exception{
        identification=new Identification(new JSONObject(flight.get("identification").toString()));
        aircraft=new Aircraft(new JSONObject(flight.get("aircraft").toString()));
        owner=new Owner(new JSONObject(flight.get("owner").toString()));
        airline=new Airline(new JSONObject(flight.get("airline").toString()));
        System.out.println(this);
    }
    
    public Identification getIdentification() {
        return identification;
    }

    
    public Aircraft getAicraft() {
        return aircraft;
    }

    public Owner getOwner() {
        return owner;
    }

    public Airline getAirline() {
        return airline;
    }

    @Override
    public String toString() {
        return "Flight{" + "identification=" + identification + ", aircraft=" + aircraft + ", owner=" + owner + ", airline=" + airline + '}';
    }

    
    
    
    
}
