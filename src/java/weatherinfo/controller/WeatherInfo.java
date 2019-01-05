/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherinfo.controller;

import model.schedule.Schedule;
import model.weather.Weather;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Kali
 */
public class WeatherInfo {
    
    
    public static Weather getWeather(String iata) throws Exception {
    //  public static void main(String[] args)throws Exception {
        
    
  //String iata="YYZ";
        
        final String JSON_DATA = JsonParser.parseURL(iata);
        JSONObject obj = new JSONObject(JSON_DATA);
        JSONObject ob=new JSONObject( obj.get("result").toString());
        JSONObject response=new JSONObject(ob.get("response").toString());
        JSONObject airport=new JSONObject(response.get("airport").toString());
        JSONObject plugindata=new JSONObject(airport.get("pluginData").toString());
        JSONObject weather=new JSONObject(plugindata.get("weather").toString());
        //Schedule s=new Schedule(new JSONObject(plugindata.get("schedule").toString()));
          //System.out.println(s);
        return new Weather(weather);
    }
   
}
