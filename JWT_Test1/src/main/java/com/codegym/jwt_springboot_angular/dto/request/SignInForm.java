package com.codegym.jwt_springboot_angular.dto.request;

public class SignInForm {
    private String userName;
    private String password;

    public SignInForm() {
    }

    public SignInForm(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
