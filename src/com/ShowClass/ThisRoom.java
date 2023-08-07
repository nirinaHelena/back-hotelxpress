package com.ShowClass;

public class ThisRoom {
    private int idRoom;
    private String roomCategory;
    private String roomName;
    private String roomUrlImg;
    private String description;
    private Double pricePerNight;
    private Double pricePerHour;
    private int idRoomType;
    private int idHotel;

    public ThisRoom(int idRoom, String roomCategory,
                    String roomName, String roomUrlImg,
                    String description, Double pricePerNight,
                    Double pricePerHour, int idRoomType,
                    int idHotel) {
        this.idRoom = idRoom;
        this.roomCategory = roomCategory;
        this.roomName = roomName;
        this.roomUrlImg = roomUrlImg;
        this.description = description;
        this.pricePerNight = pricePerNight;
        this.pricePerHour = pricePerHour;
        this.idRoomType = idRoomType;
        this.idHotel = idHotel;
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

    @Override
    public String toString() {
        return "ThisRoom{" +
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
