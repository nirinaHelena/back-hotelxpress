package com.Table;

import java.util.UUID;

public class Room {
    private static int idCounter = 0;
    private int idRoom;
    private String roomCategory;
    private String roomName;
    private String roomUrlImg;
    private String description;
    private Double pricePerNight;
    private Double pricePerHour;
    private int idRoomType;
    private int idHotel;

    public Room( String roomCategory, String roomName,
                 String roomUrlImg, String description,
                 Double pricePerNight,
                 Double pricePerHour, int idRoomType,
                 int idHotel) {
        this.idRoom = idCounter++;
        this.roomCategory = roomCategory;
        this.roomName = roomName;
        this.roomUrlImg = roomUrlImg;
        this.description = description;
        this.pricePerNight = pricePerNight;
        this.pricePerHour = pricePerHour;
        this.idRoomType = idRoomType;
        this.idHotel = idHotel;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public String getRoomCategory() {
        return roomCategory;
    }

    public String getRoomName() {
        return roomName;
    }

    public String getRoomUrlImg() {
        return roomUrlImg;
    }

    public String getDescription() {
        return description;
    }

    public Double getPricePerNight() {
        return pricePerNight;
    }

    public Double getPricePerHour() {
        return pricePerHour;
    }

    public int getIdRoomType() {
        return idRoomType;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setPricePerHour(Double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public void setPricePerNight(Double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRoomUrlImg(String roomUrlImg) {
        this.roomUrlImg = roomUrlImg;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setRoomCategory(String roomCategory) {
        this.roomCategory = roomCategory;
    }

    @Override
    public String toString() {
        return "Room{" +
                "idRoom=" + idRoom +
                ", roomCategory='" + roomCategory + '\'' +
                ", roomName='" + roomName + '\'' +
                ", roomUrlImg='" + roomUrlImg + '\'' +
                ", description='" + description + '\'' +
                ", pricePerNight=" + pricePerNight +
                ", pricePerHour=" + pricePerHour +
                ", idRoomType=" + idRoomType +
                ", idHotel=" + idHotel +
                '}';
    }
}
