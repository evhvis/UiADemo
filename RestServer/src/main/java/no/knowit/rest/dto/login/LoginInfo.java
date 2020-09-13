package no.knowit.rest.dto.login;

import no.knowit.database.entities.Role;

public class LoginInfo {
    private String username;
    private String password;
    private String token;
    private Role role;

    public String getUsername() {
        return username;
    }

    public LoginInfo setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginInfo setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getToken() {
        return token;
    }

    public LoginInfo setToken(String token) {
        this.token = token;
        return this;
    }

    public Role getRole() {
        return role;
    }

    public LoginInfo setRole(Role role) {
        this.role = role;
        return this;
    }

    @Override
    public String toString() {
        return "LoginInfo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                ", role=" + role +
                '}';
    }
}
