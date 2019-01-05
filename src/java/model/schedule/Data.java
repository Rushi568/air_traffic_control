/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.schedule;


import org.json.JSONArray;
import org.json.JSONObject;


/**
 *
 * @author Kali
 */
public class Data {

    private Flight flight;
    private Owner owner;
    private Airline airline;
    private Aircraft aircraft;
    public Data() {
        flight = null;
        owner = null;
        airline = null;

    }

    private Data(JSONArray data) throws Exception {
//        if(data.get("flight")!=null)
//        flight = new Flight(new JSONObject(data.get("flight").toString()));
//        if(data.get("owner")!=null)
//        owner = new Owner(new JSONObject(data.get("owner").toString()));
//        if(data.get("airline")!=null)
//        airline = new Airline(new JSONObject(data.get("airline").toString()));
//        if(data.get("aircraft")!=null)
//        aircraft =new Aircraft(new JSONObject(data.get("aircraft").toString()));
        System.out.println(data);
        for(int i=0;i<data.length();i++) {
            if(i==1)
                flight = new Flight(new JSONObject(data.get(1).toString()));
            else if(i==2)
                owner = new Owner(new JSONObject(data.get(2).toString()));
            else if(i==3)
                airline = new Airline(new JSONObject(data.get(3).toString()));
            else if(i==4)    
                aircraft =new Aircraft(new JSONObject(data.get(4).toString()));
        }
        
    }

 

    public Data[] getArray(JSONArray dataArray) throws Exception {
        Data[] data=new Data[dataArray.length()];
        for(int i=0;i<dataArray.length();i++){
            String arr=dataArray.getJSONObject(i).toString();
            int len=arr.length();
            System.out.println(new JSONArray(arr.substring(0,len-1)));
            //data[i]=new Data(new JSONArray("["+arr.substring(2,len-1)+"]"));
            
        }
        return data;
    }

    public Flight getFlight() {
        return flight;
    }

    public Owner getOwner() {
        return owner;
    }

    public Airline getAirline() {
        return airline;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    @Override
    public String toString() {
        return "Data{" + "flight=" + flight + ", owner=" + owner + ", airline=" + airline + ", aircraft=" + aircraft + '}';
    }

    

}
