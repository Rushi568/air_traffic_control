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
public class Sky {
    private Condition condition;
    private Visibility visibiity;
    
    public Sky(JSONObject sky)throws Exception{
        condition=new Condition(new JSONObject(sky.get("condition").toString()));
        visibiity=new Visibility(new JSONObject(sky.get("visibility").toString()));
    }
    
    public Condition getCondition() {
        return condition;
    }

    

    public Visibility getVisibiity() {
        return visibiity;
    }

    

    @Override
    public String toString() {
        return "Sky{" + "condition=" + condition + ", visibiity=" + visibiity + '}';
    }
    
}
