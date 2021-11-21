package com.training.hyrid.request;

public class LoginRequest {

    private String email;
    private String password;

    /**
     * Create an empty LoginRequest object
     */
    public LoginRequest() {
        super();
    }

    /**
     * Create a LoginRequest object with full attributes
     *
     * @param email user's email
     * @param password
     */
    public LoginRequest(String email, String password) {
        super();
        this.email = email;
        this.password = password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}