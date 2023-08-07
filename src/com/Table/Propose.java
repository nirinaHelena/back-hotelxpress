package com.Table;

public class Propose {
    private static int idCounter = 0;
    private int id ;
    private int idUser;
    private int idPartnership;

    public Propose( int idUser, int idPartnership) {
        this.id = id;
        this.idUser = idUser;
        this.idPartnership = idPartnership;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public int getId() {
        return id;
    }

    public int getIdUser() {
        return idUser;
    }

    public int getIdPartnership() {
        return idPartnership;
    }

    @Override
    public String toString() {
        return "Propose{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", idPartnership=" + idPartnership +
                '}';
    }
}
