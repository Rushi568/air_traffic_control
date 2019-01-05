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
public class OnGround {
    private String visible;
    private String total;

    public OnGround(JSONObject onground)throws Exception{
        visible = onground.getString("visible");
        total=onground.getString("total");
        System.out.println(this);
    }
    
    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "OnGround{" + "visible=" + visible + ", total=" + total + '}';
    }
    
    
}
