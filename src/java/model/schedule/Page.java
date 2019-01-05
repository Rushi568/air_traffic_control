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
public class Page {
    private String current;
    private String total;
    public Page(JSONObject page)throws Exception{
        current=page.getString("current");
        total=page.getString("total");
        System.out.println(this);
    }
    public String getCurrent() {
        return current;
    }

   
    public String getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Page{" + "current=" + current + ", total=" + total + '}';
    }

    
    
    
    
}
