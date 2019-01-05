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
public class Identification {
    private String id;
    private String row;
    private Num number;
    private String callsign;
    private String codeshare;
    
    public Identification(JSONObject identification)throws Exception{
        id=identification.getString("id");
        row=identification.getString("row");
        number=new Num(new JSONObject(identification.get("number").toString()));
        callsign=identification.getString("callsign");
        codeshare=identification.getString("codeshare");
        System.out.println(this);
    }
    
    public String getId() {
        return id;
    }

    public String getRow() {
        return row;
    }

    public Num getNumber() {
        return number;
    }

    public String getCallsign() {
        return callsign;
    }

    public String getCodeshare() {
        return codeshare;
    }

    @Override
    public String toString() {
        return "Identification{" + "id=" + id + ", row=" + row + ", number=" + number + ", callsign=" + callsign + ", codeshare=" + codeshare + '}';
    }
    
    
            
}
