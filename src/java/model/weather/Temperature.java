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
public class Temperature {
    private String celcius;
    private String farenheit;

    public Temperature(JSONObject temperature)throws Exception{
        celcius=temperature.getString("celsius");
        farenheit=temperature.getString("fahrenheit");
    }
    public String getCelcius() {
        return celcius;
    }

   

    public String getFarenheit() {
        return farenheit;
    }

    

    @Override
    public String toString() {
        return "Temperature{" + "celcius=" + celcius + ", farenheit=" + farenheit + '}';
    }
    
}
