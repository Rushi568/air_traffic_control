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
public class Condition {
    private String text;

    public Condition(JSONObject condition)throws Exception{
        text=condition.getString("text");
    }
    public String getText() {
        return text;
    }

    
    @Override
    public String toString() {
        return "Condition{" + "text=" + text + '}';
    }
    
}
