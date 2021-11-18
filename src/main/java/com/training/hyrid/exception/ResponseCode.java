package com.training.hyrid.exception;

public class ResponseCode {
    private Long responseCode;

    public ResponseCode(Long responseCode) {
        this.responseCode = responseCode;
    }

    public Long getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Long responseCode) {
        this.responseCode = responseCode;
    }
}
