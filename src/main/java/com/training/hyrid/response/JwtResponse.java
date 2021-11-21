package com.training.hyrid.response;

import java.util.List;

public class JwtResponse {

    private Long responseCode;
    private String token;
    private String message;
    private Integer id;
    private String type = "Bearer";
    private List<String> roles;

    public JwtResponse(String accessToken, Long responseCode,String message,Integer id, List<String> roles) {
        this.token = accessToken;
        this.responseCode = responseCode;
        this.message = message;
        this.id = id;
        this.roles = roles;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public List<String> getRole() {
        return roles;
    }

    public Long getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Long responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
