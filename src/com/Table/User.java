package com.Table;

import java.time.LocalDate;
import java.util.Objects;

public class User {
    private static int idCounter=0;
    private int idUser;
    private String firstName;
    private String lastName;
    private Character gender;
    private String email;
    private String phoneNumber;
    private String profileUrlImg;
    private String nationality;
    private LocalDate birthdate;
    private String password;
    private int idUserType;

    public User(String firstName, String lastName,
                Character gender, String email, String phoneNumber,
                String profileUrlImg, String nationality,
                LocalDate birthdate, String password, int idUserType) {
        this.idUser = idCounter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.profileUrlImg = profileUrlImg;
        this.nationality = nationality;
        this.birthdate = birthdate;
        this.password = password;
        this.idUserType = idUserType;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Character getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getProfileUrlImg() {
        return profileUrlImg;
    }

    public String getNationality() {
        return nationality;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public String getPassword() {
        return password;
    }

    public int getIdUserType() {
        return idUserType;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setProfileUrlImg(String profileUrlImg) {
        this.profileUrlImg = profileUrlImg;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getIdUser() == user.getIdUser() && getIdUserType() == user.getIdUserType() && Objects.equals(getFirstName(), user.getFirstName()) && Objects.equals(getLastName(), user.getLastName()) && Objects.equals(getGender(), user.getGender()) && Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getPhoneNumber(), user.getPhoneNumber()) && Objects.equals(getProfileUrlImg(), user.getProfileUrlImg()) && Objects.equals(getNationality(), user.getNationality()) && Objects.equals(getBirthdate(), user.getBirthdate()) && Objects.equals(getPassword(), user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdUser(), getFirstName(), getLastName(), getGender(), getEmail(), getPhoneNumber(), getProfileUrlImg(), getNationality(), getBirthdate(), getPassword(), getIdUserType());
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", profileUrlImg='" + profileUrlImg + '\'' +
                ", nationality='" + nationality + '\'' +
                ", birthdate=" + birthdate +
                ", password='" + password + '\'' +
                ", idUserType=" + idUserType +
                '}';
    }
}
