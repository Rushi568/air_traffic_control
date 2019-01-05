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
public class Aircraft {
    private Model model;
    private String hex;
    private String registration;
    private String serialNo;
    private Age age;
    private String onGroundUpdate;
    private String hoursDiff;
    private Availability availability;

    public Aircraft(JSONObject aircraft)throws Exception{
        model=new Model(new JSONObject(aircraft.get("model").toString()));
        hex=aircraft.getString("hex");
        registration=aircraft.getString("registration");
        serialNo=aircraft.getString("serialNo");
        age=new Age(new JSONObject(aircraft.get("age").toString()));
        onGroundUpdate=aircraft.getString("onGroundUpdate");
        hoursDiff=aircraft.getString("hoursDiff");
        availability=new Availability(new JSONObject(aircraft.get("availability").toString()));
        System.out.println(this);
    }
    
    public String getOnGroundUpdate() {
        return onGroundUpdate;
    }

    
    public String getHoursDiff() {
        return hoursDiff;
    }

    public Model getModel() {
        return model;
    }

    public String getHex() {
        return hex;
    }

    public String getRegistration() {
        return registration;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public Age getAge() {
        return age;
    }

    public Availability getAvailability() {
        return availability;
    }

    @Override
    public String toString() {
        return "Aircraft{" + "model=" + model + ", hex=" + hex + ", registration=" + registration + ", serialNo=" + serialNo + ", age=" + age + ", onGroundUpdate=" + onGroundUpdate + ", hoursDiff=" + hoursDiff + ", availability=" + availability + '}';
    }

    
    
    
    
}
