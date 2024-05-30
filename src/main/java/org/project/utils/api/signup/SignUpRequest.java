package org.project.utils.api.signup;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SignUpRequest {
    private String email;
    private String password;
    private String username;
    private String errorMessage;

    public SignUpRequest(String email, String password, String username, String errorMessage) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.errorMessage = errorMessage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
