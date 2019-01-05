/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherinfo.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser {

    public static String parseURL(String iata) {
        JSONParser parser = new JSONParser();
StringBuilder sb=null;
        try {

            URLConnection connection = new URL("https://api.flightradar24.com/common/v1/airport.json?code="+iata+"&plugin[weather]=weather&token=").openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            connection.connect();

            BufferedReader r = new BufferedReader(new InputStreamReader(connection.getInputStream()));

             sb = new StringBuilder();
            String line;
            while ((line = r.readLine()) != null) {
                sb.append(line+"\n");
            }
            //System.out.println(sb.toString());

           // in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            return sb.toString();
        }
    }
    
}
