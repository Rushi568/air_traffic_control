/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package speechtotext;

import java.util.List;

/**
 *
 * @author Kali
 */
public class Response {
   
    
    private String response;
    private List<String> otherPossibleResponses;
    private String confidence;

    
        Response(String response, List<String> otherPossibleResponses, String confidence){
        this.response=response;
        this.otherPossibleResponses=otherPossibleResponses;
        this.confidence=confidence;
        
    }

    @Override
    public String toString() {
        return "Response{" + "response=" + response + ", otherPossibleResponses=" + otherPossibleResponses + ", confidence=" + confidence + '}';
    }
    
        
        
        
    public String getResponse() {
        return response;
    }

    public List<String> getOtherPossibleResponses() {
        return otherPossibleResponses;
    }

    public String getConfidence() {
        return confidence;
    }
    
    
    
    
}
