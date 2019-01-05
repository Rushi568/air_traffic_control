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
public class Availability {
    private String serialNo;
    private String age;

    public Availability(JSONObject availability)throws Exception{
        serialNo=availability.getString("serialNo");
        age=availability.getString("age");
        System.out.println(this);
    }
    
    public String getSerialNo() {
        return serialNo;
    }

    

    public String getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Availability{" + "serialNo=" + serialNo + ", age=" + age + '}';
    }

    
    
    
    
}
