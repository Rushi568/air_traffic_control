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
public class Visibility {
    private String km;
    private String mi;
    private String nmi;
    
    public Visibility(JSONObject visibility)throws Exception{
        km=visibility.getString("km");
        mi=visibility.getString("mi");
        nmi=visibility.getString("nmi");
        if(km.equalsIgnoreCase("null"))
            km=null;
        if(mi.equalsIgnoreCase("null"))
            mi=null;
        if(nmi.equalsIgnoreCase("null"))
            nmi=null;
    }
    
    public String getKm() {
        return km;
    }

    

    public String getMi() {
        return mi;
    }

    

    public String getNmi() {
        return nmi;
    }

   

    @Override
    public String toString() {
        return "Visibiity{" + "km=" + km + ", mi=" + mi + ", nmi=" + nmi + '}';
    }
    
}
