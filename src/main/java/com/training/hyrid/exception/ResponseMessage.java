package com.training.hyrid.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseMessage {
    private String Messsage;
    private Long responseCode;
    public ResponseMessage(String Messsage,Long responseCode){
        this.Messsage = Messsage;
        this.responseCode = responseCode;
    }

    public String getMesssage() {
        return Messsage;
    }

    public void setMesssage(String messsage) {
        Messsage = messsage;
    }

    @JsonProperty("response_code")
    public Long getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Long responseCode) {
        this.responseCode = responseCode;
    }
}
