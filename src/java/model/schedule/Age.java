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
public class Age {
    private String availability;

    public Age(JSONObject age)throws Exception{
        availability=age.getString("availability");
        System.out.println(this);
    }
    
    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Age{" + "availability=" + availability + '}';
    }
    
    
    
}
