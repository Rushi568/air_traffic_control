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
public class Speed {
    private String kmh;
    private String kts;
    private String mph;
    private String text;

    public Speed(JSONObject speed)throws Exception{
        kmh=speed.getString("kmh");
        kts=speed.getString("kts");
        mph=speed.getString("mph");
        text=speed.getString("text");
        
    }
    
    
    public String getKmh() {
        return kmh;
    }

   

    public String getKts() {
        return kts;
    }

    

    public String getMph() {
        return mph;
    }

    

    public String getText() {
        return text;
    }

    

    @Override
    public String toString() {
        return "Speed{" + "kmh=" + kmh + ", kts=" + kts + ", mph=" + mph + ", text=" + text + '}';
    }
    
}
