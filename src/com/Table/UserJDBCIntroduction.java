package com.Table;

public class UserJDBCIntroduction {
    private int id;
    private String name;
    private String email;
    private String password;

    public UserJDBCIntroduction(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {

        return "id = " + this.id +
                ", name = " + this.name +
                ", email = " + this.email;
    }
}
