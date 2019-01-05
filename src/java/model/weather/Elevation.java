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
public class Elevation {
    private String m;
    private String ft;
    
    public Elevation(JSONObject elevation)throws Exception{
        m=elevation.getString("m");
        ft=elevation.getString("ft");
    }
    
    public String getM() {
        return m;
    }

    

    public String getFt() {
        return ft;
    }

    

    @Override
    public String toString() {
        return "Elevation{" + "m=" + m + ", ft=" + ft + '}';
    }
    
}
