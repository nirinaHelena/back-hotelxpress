package com.Table;

import java.util.Objects;

public class Hotel {
    private static int idCounter=0;
    private int id;
    private String hotelName;
    private String adress;
    private String city;
    private String state;
    private String phoneNumber;

    public Hotel( String hotelName,
                 String adress, String city,
                 String state, String phoneNumber) {
        this.id = idCounter++;
        this.hotelName = hotelName;
        this.adress = adress;
        this.city = city;
        this.state = state;
        this.phoneNumber = phoneNumber;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public int getId() {
        return id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getAdress() {
        return adress;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return getId() == hotel.getId() && Objects.equals(getHotelName(), hotel.getHotelName()) && Objects.equals(getAdress(), hotel.getAdress()) && Objects.equals(getCity(), hotel.getCity()) && Objects.equals(getState(), hotel.getState()) && Objects.equals(getPhoneNumber(), hotel.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getHotelName(), getAdress(), getCity(), getState(), getPhoneNumber());
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", hotelName='" + hotelName + '\'' +
                ", adress='" + adress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
