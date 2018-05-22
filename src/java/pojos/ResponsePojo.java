/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import org.codehaus.jackson.annotate.JsonPropertyOrder;

/**
 *
 * @author Hagar
 */
@JsonPropertyOrder({"status", "message", "error"})
public class ResponsePojo {

    private boolean status;
    private String message;
    private String error;

    public void setError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public boolean isStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
