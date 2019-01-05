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
public class Model {
    private String code;
    private String text;

    public Model(JSONObject model)throws Exception{
        code=model.getString("code");
        text=model.getString("text");
        System.out.println(this);
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Model{" + "code=" + code + ", text=" + text + '}';
    }
    
    
    
}
