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
public class AircraftCount {
    private String ground;
    private OnGround onground;

    public AircraftCount(JSONObject aircraftCount)throws Exception{
        ground=aircraftCount.getString("ground");
        onground=new OnGround(new JSONObject(aircraftCount.get("onground").toString()));
        System.out.println(this);
    }
    
    public String getGround() {
        return ground;
    }


    public OnGround getOnground() {
        return onground;
    }

    @Override
    public String toString() {
        return "AircraftCount{" + "ground=" + ground + ", onground=" + onground + '}';
    }
    
    
}
