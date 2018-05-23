/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import org.codehaus.jackson.annotate.JsonPropertyOrder;

/**
 *
 * @author hoda.CO
 */
@JsonPropertyOrder({"message","status","error"})
public class ResponseMessageWithId extends ResponseMessage{
    
    int Id;
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
    
}
