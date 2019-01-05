/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.schedule;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Kali
 */
public class Ground {
    private Item item;
    private Page page;
    private String timestamp;
    private Data[] data;
    
    public Ground(JSONObject ground)throws Exception{
        item= new Item(new JSONObject(ground.get("item").toString()));
        page= new Page(new JSONObject(ground.get("page").toString()));
        timestamp=ground.getString("timestamp");
        data=new Data().getArray((JSONArray)ground.get("data"));
        
        System.out.println(this);
    }
    
    public Item getItem() {
        return item;
    }

    

    public Page getPage() {
        return page;
    }

   
    public String getTimestamp() {
        return timestamp;
    }

    

    public Data[] getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Ground{" + "item=" + item + ", page=" + page + ", timestamp=" + timestamp + ", data=" + data + '}';
    }

    
    
    
}
