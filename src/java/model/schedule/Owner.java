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
public class Owner {
    private String name;
    private String logo;
    private Code code;

    public Owner(JSONObject owner)throws Exception{
        name=owner.getString("name");
        logo=owner.getString("logo");
        code=new Code(new JSONObject(owner.get("code").toString()));
        System.out.println(this);
    }
    
    public String getName() {
        return name;
    }

    
    public String getLogo() {
        return logo;
    }

    
    public Code getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Owner{" + "name=" + name + ", logo=" + logo + ", code=" + code + '}';
    }

    
    
}
