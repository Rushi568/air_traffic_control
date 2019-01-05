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
public class Code {
    private String iata;
    private String icao;

    public Code(JSONObject code)throws Exception{
        iata=code.getString("iata");
        icao=code.getString("icao");
        System.out.println(this);
    }
    
    public String getIata() {
        return iata;
    }

    

    public String getIcao() {
        return icao;
    }

    @Override
    public String toString() {
        return "Code{" + "iata=" + iata + ", icao=" + icao + '}';
    }

    
    
    
}
