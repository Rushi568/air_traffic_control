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
public class Direction {
    private String degree;
    private String text;
    public Direction(JSONObject direction)throws Exception{
        degree=direction.getString("degree");
        text=direction.getString("text");
    }
    public String getDegree() {
        return degree;
    }

    

    public String getText() {
        return text;
    }

    

    @Override
    public String toString() {
        return "Direction{" + "degree=" + degree + ", text=" + text + '}';
    }
    
}
