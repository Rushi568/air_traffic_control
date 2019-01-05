/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport.data.repository;

import schedule.controller.*;
import weatherinfo.controller.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import model.Airport;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser {

    //public static String parseURL(String iata) {
    public static ArrayList getAirports() throws Exception {

        JSONParser parser = new JSONParser();
        JSONArray a = (JSONArray) parser.parse(new FileReader("E:\\Final Year Project\\GoogleMapDemo\\web\\json\\airports.json"));
        Airport air;
        ArrayList airports=new ArrayList<Airport>();
        for (Object o : a) {
            JSONObject person = (JSONObject) o;
            air=new Airport((String) person.get("name"),(String) person.get("iata"),Double.parseDouble((String)person.get("lat")),Double.parseDouble((String)person.get("lng")));
            airports.add(air);
            
            
        }
        return airports;
    }

}
