package com.Table;

public class RoomType {
    private static int idCounter = 0;
    private int id;
    private String type;

    public RoomType(String type) {
        this.id = idCounter++;
        this.type = type;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "RoomType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
