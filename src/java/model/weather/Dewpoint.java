/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.weather;

import org.json.JSONObject;

/**
 *
 * @author Kali
 */
public class Dewpoint {
    private String celsius;
    private String farenheit;
    
    public Dewpoint(JSONObject dewpoint)throws Exception{
        celsius=dewpoint.getString("celsius");
        farenheit=dewpoint.getString("fahrenheit");
        
    }
    @Override
    public String toString() {
        return "Dewpoint{" + "celsius=" + celsius + ", farenheit=" + farenheit + '}';
    }
    
    public String getCelsius() {
        return celsius;
    }

    

    public String getFarenheit() {
        return farenheit;
    }

   
    
}
