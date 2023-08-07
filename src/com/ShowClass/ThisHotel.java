package com.ShowClass;

public class ThisHotel {
    private int id;
    private String hotelName;
    private String adress;
    private String city;
    private String state;
    private String phoneNumber;

    public ThisHotel(int id, String hotelName,
                     String adress, String state,
                     String phoneNumber) {
        this.id = id;
        this.hotelName = hotelName;
        this.adress = adress;
        this.state = state;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "ThisHotel{" +
                "id=" + id +
                ", hotelName='" + hotelName + '\'' +
                ", adress='" + adress + '\'' +
                ", state='" + state + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
