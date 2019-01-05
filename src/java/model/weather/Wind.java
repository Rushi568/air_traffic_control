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
public class Wind {
    private Direction direction;
    private Speed speed;
    public Wind(JSONObject wind)throws Exception{
        speed=new Speed(new JSONObject(wind.get("speed").toString()));
        direction=new Direction(new JSONObject(wind.get("direction").toString()));
    }
    public Direction getDirection() {
        return direction;
    }

   
    public Speed getSpeed() {
        return speed;
    }

   
    @Override
    public String toString() {
        return "Wind{" + "direction=" + direction + ", speed=" + speed + '}';
    }
    
}
