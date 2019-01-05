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
public class Schedule {
    private Ground ground;
    public Schedule(JSONObject schedule)throws Exception{
        ground=new Ground(new JSONObject(schedule.get("ground").toString()));
        System.out.println(this);
    }
    public Ground getGround() {
        return ground;
    }

    @Override
    public String toString() {
        return "Schedule{" + "ground=" + ground + '}';
    }

    
    
    
}
