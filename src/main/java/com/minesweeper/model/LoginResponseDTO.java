package com.minesweeper.model;

public class LoginResponseDTO {

    private UserDTO user;
    private String jwt;

    public LoginResponseDTO() {
        super();
    }

    public LoginResponseDTO(User user, String jwt) {
        super();
        this.user = new UserDTO(user);
        this.jwt = jwt;
    }


    public UserDTO getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = new UserDTO(user);
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
