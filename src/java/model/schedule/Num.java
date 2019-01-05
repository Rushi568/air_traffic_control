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
public class Num {
    private String def;
    private String alternative;

    public Num(JSONObject num)throws Exception{
        def=num.getString("default");
        alternative=num.getString("alternative");
        System.out.println(this);
    }
    
    public String getDef() {
        return def;
    }

    public String getAlternative() {
        return alternative;
    }

    @Override
    public String toString() {
        return "Num{" + "def=" + def + ", alternative=" + alternative + '}';
    }
    
    
    
}
