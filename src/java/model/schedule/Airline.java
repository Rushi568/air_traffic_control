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
public class Airline {
    private String name;
    private String shortname;
    private Code code;

    public Airline(JSONObject airline)throws Exception{
        name=airline.getString("name");
        shortname=airline.getString("short");
        code=new Code(new JSONObject(airline.get("code").toString()));
        System.out.println(this);
    }
    
    public String getName() {
        return name;
    }

    

    public String getShortname() {
        return shortname;
    }

    

    public Code getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Airline{" + "name=" + name + ", shortname=" + shortname + ", code=" + code + '}';
    }

    
    
    
    
}
