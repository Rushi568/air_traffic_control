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
public class Item {
    private String current;
    private String total;
    private String limit;
    public Item(JSONObject item)throws Exception{
        current =item.getString("current");
        total= item.getString("total");
        limit=item.getString("limit");
        System.out.println(this);
        
    }
    public String getCurrent() {
        return current;
    }

    

    public String getTotal() {
        return total;
    }

    

    public String getLimit() {
        return limit;
    }

    @Override
    public String toString() {
        return "Item{" + "current=" + current + ", total=" + total + ", limit=" + limit + '}';
    }

    
    
    
}
