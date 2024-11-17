package com.minesweeper.model;

public class UserDTO {
    private String username;
    private String authority;

    public UserDTO(User user) {
        this.username = user.getUsername();
        if (!user.getAuthorities().isEmpty()) {
            this.authority = user.getAuthorities().iterator().next().getAuthority();
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
