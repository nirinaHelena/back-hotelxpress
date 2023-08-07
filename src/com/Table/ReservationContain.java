package com.Table;

public class ReservationContain {
    private static int idCounter = 0;
    private int id ;
    private int roomQuantity;
    private int idReservation;
    private int idRoom;

    public ReservationContain(int roomQuantity, int idReservation, int idRoom) {
        this.id = idCounter++;
        this.roomQuantity = roomQuantity;
        this.idReservation = idReservation;
        this.idRoom = idRoom;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public int getId() {
        return id;
    }

    public int getRoomQuantity() {
        return roomQuantity;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setRoomQuantity(int roomQuantity) {
        this.roomQuantity = roomQuantity;
    }

    @Override
    public String toString() {
        return "ReservationContain{" +
                "id=" + id +
                ", roomQuantity=" + roomQuantity +
                ", idReservation=" + idReservation +
                ", idRoom=" + idRoom +
                '}';
    }
}
