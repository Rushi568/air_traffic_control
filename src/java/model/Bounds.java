/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Kali
 */
public class Bounds {
   private double lat0;
   private double lat1;
   private double lng1;
   private double lng0;

    public double getLat0() {
        return lat0;
    }

    public double getLat1() {
        return lat1;
    }

    public double getLng0() {
        return lng0;
    }

    public double getLng1() {
        return lng1;
    }
    
   public Bounds()throws Exception{
       throw (new Exception());
   } 
   
   public Bounds(double latitude,double longitude){
       lat0=latitude+0.5;
       lat1=latitude-0.5;
       lng0=longitude-0.5;
       lng1=longitude+0.5;
   }

    @Override
    public String toString() {
        return "Bounds{" + "lat0=" + lat0 + ", lat1=" + lat1 + ", lng0=" + lng0 + ", lng1=" + lng1 + '}';
    }
   
       
   
}
