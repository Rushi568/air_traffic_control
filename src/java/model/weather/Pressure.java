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
public class Pressure {
    private String hg;
    private String hpa;
    public Pressure(JSONObject pressure)throws Exception{
        hg=pressure.getString("hg");
        hpa=pressure.getString("hpa");
    }
    public String getHg() {
        return hg;
    }

    

    public String getHpa() {
        return hpa;
    }

    

    @Override
    public String toString() {
        return "Pressure{" + "hg=" + hg + ", hpa=" + hpa + '}';
    }
    
}
