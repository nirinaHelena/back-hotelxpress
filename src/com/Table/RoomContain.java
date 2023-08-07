package com.Table;

public class RoomContain {
    private static int idCounter=0;
    private int id;
    private int idRoom;
    private int idRoomContent;

    public RoomContain(int idRoom, int idRoomContent) {
        this.id = idCounter++;
        this.idRoom = idRoom;
        this.idRoomContent = idRoomContent;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public int getId() {
        return id;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public int getIdRoomContent() {
        return idRoomContent;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public void setIdRoomContent(int idRoomContent) {
        this.idRoomContent = idRoomContent;
    }

    @Override
    public String toString() {
        return "RoomContain{" +
                "id=" + id +
                ", idRoom=" + idRoom +
                ", idRoomContent=" + idRoomContent +
                '}';
    }
}