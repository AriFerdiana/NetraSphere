package com.smartwaste.dto.response;

/**
 * DTO response setelah login/register sukses.
 * Berisi JWT token dan informasi dasar user.
 */
public class AuthResponse {

    private String token;
    private String tokenType = "Bearer";
    private String userId;
    private String name;
    private String email;
    private String role;
    private long expiresIn; // dalam milidetik

    public AuthResponse() {}

    public static AuthResponseBuilder builder() {
        return new AuthResponseBuilder();
    }

    public static class AuthResponseBuilder {
        private AuthResponse r = new AuthResponse();
        public AuthResponseBuilder token(String t) { r.token = t; return this; }
        public AuthResponseBuilder tokenType(String t) { r.tokenType = t; return this; }
        public AuthResponseBuilder userId(String id) { r.userId = id; return this; }
        public AuthResponseBuilder name(String n) { r.name = n; return this; }
        public AuthResponseBuilder email(String e) { r.email = e; return this; }
        public AuthResponseBuilder role(String role) { r.role = role; return this; }
        public AuthResponseBuilder expiresIn(long e) { r.expiresIn = e; return this; }
        public AuthResponse build() { return r; }
    }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
    public String getTokenType() { return tokenType; }
    public void setTokenType(String tokenType) { this.tokenType = tokenType; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public long getExpiresIn() { return expiresIn; }
    public void setExpiresIn(long expiresIn) { this.expiresIn = expiresIn; }
}
