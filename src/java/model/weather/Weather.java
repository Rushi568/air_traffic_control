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
public class Weather {
    private String metar;
    private String time;
    private String qnh;
    private Dewpoint dewpoint;
    private String humidity;
    private Pressure pressure;
    private Sky sky;
    private String flightcategory;
    private Wind wind;
    private Temperature temperature;
    private Elevation elevation;
    private String cached;
    public Weather()throws Exception{
    throw new Exception();
    }
    public Weather(JSONObject weather)throws Exception{
        metar=weather.get("metar").toString();
        time=weather.getString("time");
        qnh=weather.getString("qnh");
        dewpoint = new Dewpoint(new JSONObject(weather.get("dewpoint").toString()));
        humidity=weather.getString("humidity");
        pressure=new Pressure(new JSONObject(weather.get("pressure").toString()));
        sky=new Sky(new JSONObject(weather.get("sky").toString()));
        flightcategory=new JSONObject(weather.get("flight").toString()).getString("category");
        wind=new Wind(new JSONObject(weather.get("wind").toString()));
        temperature=new Temperature(new JSONObject(weather.get("temp").toString()));
        elevation =new Elevation(new JSONObject(weather.get("elevation").toString()));
        cached=weather.getString("cached");
    }

    @Override
    public String toString() {
        return "Weather{" + "metar=" + metar + ", time=" + time + ", qnh=" + qnh + ", dewpoint=" + dewpoint + ", humidity=" + humidity + ", pressure=" + pressure + ", sky=" + sky + ", flightcategory=" + flightcategory + ", wind=" + wind + ", temperature=" + temperature + ", elevation=" + elevation + ", cached=" + cached + '}';
    }

    public String getMetar() {
        return metar;
    }

    public String getTime() {
        return time;
    }

    public String getQnh() {
        return qnh;
    }

    public Dewpoint getDewpoint() {
        return dewpoint;
    }

    public String getHumidity() {
        return humidity;
    }

    public Pressure getPressure() {
        return pressure;
    }

    public Sky getSky() {
        return sky;
    }

    public String getFlightcategory() {
        return flightcategory;
    }

    public Wind getWind() {
        return wind;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public Elevation getElevation() {
        return elevation;
    }

    public String getCached() {
        return cached;
    }
    
    
    
    
    
}
