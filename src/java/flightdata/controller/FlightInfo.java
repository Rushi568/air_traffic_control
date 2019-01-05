/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightdata.controller;

import airport.data.repository.AirportInfo;
import java.util.ArrayList;
import java.util.Iterator;
import model.Airport;
import model.Bounds;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Kali
 */
import model.Flight;

public class FlightInfo {
    //static Flight[] flights;
    
    public static ArrayList<Flight> getFlightsInBounds(double lat0,double lat1,double lng0,double lng1) throws Exception {
        final String JSON_DATA = JsonParser.parseURL(lat0,lat1,lng0,lng1);
        JSONObject obj = new JSONObject(JSON_DATA);
        //System.out.println(obj);
        
        
        JSONArray arr = obj.names();
        JSONArray a;
        //flights=new Flight[obj.length()]; 
        Flight flight;
        ArrayList arrlist=new ArrayList<Flight>();
        for (int j = 0; j < arr.length(); j++) {
            flight = new Flight();
            String key=arr.getString(j);
            if(key.equalsIgnoreCase("stats"))
                continue;
            if(key.equalsIgnoreCase("version"))
                continue;
            if(key.equalsIgnoreCase("full_count"))
                continue;
                a = obj.getJSONArray(key);
                //flight=new Flight();
                    flight.setHexNumber(a.getString(0));
                    flight.setLatitude(a.getDouble(1));
                    flight.setLongitude(a.getDouble(2));
                    flight.setDirection(a.getInt(3));
                    flight.setAltitude(a.getInt(4));
                    flight.setSpeed(a.getInt(5));
                    flight.setUnknown1(a.getString(6));
                    flight.setRadarTech(a.getString(7));
                    flight.setAircraftType(a.getString(8));
                    flight.setAirframeInfo(a.getString(9));
                    flight.setTimestamp(a.getLong(10));
                    flight.setSourceApt(a.getString(11));
                    flight.setDestApt(a.getString(12));
                    flight.setFlightnumber(a.getString(13));
                    flight.setUnknown2(a.getString(14));
                    flight.setUnknown3(a.getString(15));
                    flight.setTailnumber(a.getString(16));
                    flight.setUnknown4(a.getString(17));
                    arrlist.add(flight);
            //System.out.println(flights[j]);
        }
        
        return arrlist; 
    }
    public static ArrayList<Flight> getFlightsInBounds(Bounds b)throws Exception{
        return getFlightsInBounds(b.getLat0(),b.getLat1(),b.getLng0(),b.getLng1());
    }
    public static ArrayList<Flight> getFlightsTakingoffOrLandingInBounds(Bounds b)throws Exception{
        return getFlightsTakingoffOrLandingInBounds(b.getLat0(),b.getLat1(),b.getLng0(),b.getLng1());
    }
    public static ArrayList<Flight> getFlightsOnAirport(String iata)throws Exception{
        Airport apt=AirportInfo.getAirport(iata);
        Bounds b=new Bounds(apt.getLatitude(),apt.getLongitude());
        return getFlightsInBounds(b.getLat0(),b.getLat1(),b.getLng0(),b.getLng1());
    }
    public static ArrayList<Flight> getFlightsTakingoffOrLandingOnAirport(String iata)throws Exception{
        Airport apt=AirportInfo.getAirport(iata);
        Bounds b=new Bounds(apt.getLatitude(),apt.getLongitude());
        return getFlightsTakingoffOrLandingInBounds(b.getLat0(),b.getLat1(),b.getLng0(),b.getLng1());
    }
    public static ArrayList<Flight> getFlightsTakingoffOrLandingInBounds(double lat0,double lat1,double lng0,double lng1) throws Exception {
        final String JSON_DATA = JsonParser.parseURL(lat0,lat1,lng0,lng1);
        JSONObject obj = new JSONObject(JSON_DATA);
        //System.out.println(obj);
        
        
        JSONArray arr = obj.names();
        JSONArray a;
        //flights=new Flight[obj.length()]; 
        Flight flight;
        ArrayList arrlist=new ArrayList<Flight>();
        for (int j = 0; j < arr.length(); j++) {
            flight = new Flight();
            String key=arr.getString(j);
            if(key.equalsIgnoreCase("stats"))
                continue;
            if(key.equalsIgnoreCase("version"))
                continue;
            if(key.equalsIgnoreCase("full_count"))
                continue;
                a = obj.getJSONArray(key);
                //flight=new Flight();
                    if(a.getInt(4)!=0&&a.getInt(5)<=280){
                    flight.setHexNumber(a.getString(0));
                    flight.setLatitude(a.getDouble(1));
                    flight.setLongitude(a.getDouble(2));
                    flight.setDirection(a.getInt(3));
                    flight.setAltitude(a.getInt(4));
                    flight.setSpeed(a.getInt(5));
                    flight.setUnknown1(a.getString(6));
                    flight.setRadarTech(a.getString(7));
                    flight.setAircraftType(a.getString(8));
                    flight.setAirframeInfo(a.getString(9));
                    flight.setTimestamp(a.getLong(10));
                    flight.setSourceApt(a.getString(11));
                    flight.setDestApt(a.getString(12));
                    flight.setFlightnumber(a.getString(13));
                    flight.setUnknown2(a.getString(14));
                    flight.setUnknown3(a.getString(15));
                    flight.setTailnumber(a.getString(16));
                    flight.setUnknown4(a.getString(17));
                    arrlist.add(flight);
                    }
            //System.out.println(flights[j]);
        }
        
        return arrlist; 
    }
    
    public static ArrayList<Flight> getFlightsTakingoffFromAirport(String iata) throws Exception {
        Airport apt=AirportInfo.getAirport(iata);
        Bounds b=new Bounds(apt.getLatitude(),apt.getLongitude());
        final String JSON_DATA = JsonParser.parseURL(b.getLat0(),b.getLat1(),b.getLng0(),b.getLng1());
        JSONObject obj = new JSONObject(JSON_DATA);
        //System.out.println(obj);
        
        
        JSONArray arr = obj.names();
        JSONArray a;
        //flights=new Flight[obj.length()]; 
        Flight flight;
        ArrayList arrlist=new ArrayList<Flight>();
        for (int j = 0; j < arr.length(); j++) {
            flight = new Flight();
            String key=arr.getString(j);
            if(key.equalsIgnoreCase("stats"))
                continue;
            if(key.equalsIgnoreCase("version"))
                continue;
            if(key.equalsIgnoreCase("full_count"))
                continue;
                a = obj.getJSONArray(key);
                //flight=new Flight();
                    if(a.getInt(4)!=0&&a.getInt(5)<=280&&a.getString(11).equalsIgnoreCase(iata)){
                    flight.setHexNumber(a.getString(0));
                    flight.setLatitude(a.getDouble(1));
                    flight.setLongitude(a.getDouble(2));
                    flight.setDirection(a.getInt(3));
                    flight.setAltitude(a.getInt(4));
                    flight.setSpeed(a.getInt(5));
                    flight.setUnknown1(a.getString(6));
                    flight.setRadarTech(a.getString(7));
                    flight.setAircraftType(a.getString(8));
                    flight.setAirframeInfo(a.getString(9));
                    flight.setTimestamp(a.getLong(10));
                    flight.setSourceApt(a.getString(11));
                    flight.setDestApt(a.getString(12));
                    flight.setFlightnumber(a.getString(13));
                    flight.setUnknown2(a.getString(14));
                    flight.setUnknown3(a.getString(15));
                    flight.setTailnumber(a.getString(16));
                    flight.setUnknown4(a.getString(17));
                    arrlist.add(flight);
                    }
            //System.out.println(flights[j]);
        }
        
        return arrlist; 
    }
    
    
    public static ArrayList<Flight> getFlightsLandingOnAirport(String iata) throws Exception {
        Airport apt=AirportInfo.getAirport(iata);
        Bounds b=new Bounds(apt.getLatitude(),apt.getLongitude());
        final String JSON_DATA = JsonParser.parseURL(b.getLat0(),b.getLat1(),b.getLng0(),b.getLng1());
        JSONObject obj = new JSONObject(JSON_DATA);
        //System.out.println(obj);
        
        
        JSONArray arr = obj.names();
        JSONArray a;
        //flights=new Flight[obj.length()]; 
        Flight flight;
        ArrayList arrlist=new ArrayList<Flight>();
        for (int j = 0; j < arr.length(); j++) {
            flight = new Flight();
            String key=arr.getString(j);
            if(key.equalsIgnoreCase("stats"))
                continue;
            if(key.equalsIgnoreCase("version"))
                continue;
            if(key.equalsIgnoreCase("full_count"))
                continue;
                a = obj.getJSONArray(key);
                //flight=new Flight();
                    if(a.getInt(4)!=0&&a.getInt(5)<=280&&a.getString(12).equalsIgnoreCase(iata)){
                    flight.setHexNumber(a.getString(0));
                    flight.setLatitude(a.getDouble(1));
                    flight.setLongitude(a.getDouble(2));
                    flight.setDirection(a.getInt(3));
                    flight.setAltitude(a.getInt(4));
                    flight.setSpeed(a.getInt(5));
                    flight.setUnknown1(a.getString(6));
                    flight.setRadarTech(a.getString(7));
                    flight.setAircraftType(a.getString(8));
                    flight.setAirframeInfo(a.getString(9));
                    flight.setTimestamp(a.getLong(10));
                    flight.setSourceApt(a.getString(11));
                    flight.setDestApt(a.getString(12));
                    flight.setFlightnumber(a.getString(13));
                    flight.setUnknown2(a.getString(14));
                    flight.setUnknown3(a.getString(15));
                    flight.setTailnumber(a.getString(16));
                    flight.setUnknown4(a.getString(17));
                    arrlist.add(flight);
                    }
            //System.out.println(flights[j]);
        }
        
        return arrlist; 
    }
    
    
    
    
    
    
}
