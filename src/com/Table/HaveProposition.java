package com.Table;

public class HaveProposition {
    private static int idCounter = 0;
    private int id ;
    private int idHotel;
    private int idPartnership;

    public HaveProposition(int idHotel, int idPartnership) {
        this.id = idCounter++;
        this.idHotel = idHotel;
        this.idPartnership = idPartnership;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public int getId() {
        return id;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public int getIdPartnership() {
        return idPartnership;
    }

    @Override
    public String toString() {
        return "HaveProposition{" +
                "id=" + id +
                ", idHotel=" + idHotel +
                ", idPartnership=" + idPartnership +
                '}';
    }
}
