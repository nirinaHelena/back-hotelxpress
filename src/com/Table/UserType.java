package com.Table;

import java.util.Objects;

public class UserType {
    private static int idCounter=0;
    private int idUserType;
    private String userType;

    public UserType(String userType) {
        this.idUserType = idCounter++;
        this.userType = userType;
    }

    public int getIdUserType() {
        return idUserType;
    }

    public String getUserType() {
        return userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserType userType1 = (UserType) o;
        return getIdUserType() == userType1.getIdUserType() && Objects.equals(getUserType(), userType1.getUserType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdUserType(), getUserType());
    }

    @Override
    public String toString() {
        return "idUserType= " + idUserType +
                "\n userType= " + userType ;
    }
}
