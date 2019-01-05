/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedule.controller;


import model.schedule.Schedule;
import org.json.JSONObject;

/**
 *
 * @author Kali
 */
public class ScheduleInfo {
    
    
    public static Schedule getSchedule(String iata) throws Exception {
    //  public static void main(String[] args)throws Exception {
        
    
  //String iata="YYZ";
        
        final String JSON_DATA = JsonParser.parseURL(iata);
        JSONObject obj = new JSONObject(JSON_DATA);
        JSONObject ob=new JSONObject( obj.get("result").toString());
        JSONObject response=new JSONObject(ob.get("response").toString());
        JSONObject airport=new JSONObject(response.get("airport").toString());
        JSONObject plugindata=new JSONObject(airport.get("pluginData").toString());
        
        Schedule s=new Schedule(new JSONObject(plugindata.get("schedule").toString()));
          //System.out.println(s);
        return s;
    }
   
}
