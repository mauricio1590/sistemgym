package com.sistemgym.model;

public class Usuario {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    private  String username;
    private String password;
    private  String nivel;

    public Usuario (){}

    public Usuario(int id,String username, String password,String nivel){
        this.id = id;
        this.username = username;
        this.password = password;
        this.nivel = nivel;
    }
}
