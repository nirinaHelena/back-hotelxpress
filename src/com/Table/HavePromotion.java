package com.Table;

public class HavePromotion {
    private static int idCounter = 0;
    private int id;
    private int idHotel ;
    private int idPromotion;

    public HavePromotion(int idHotel, int idPromotion) {
        this.id = idCounter++;
        this.idHotel = idHotel;
        this.idPromotion = idPromotion;
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

    public int getIdPromotion() {
        return idPromotion;
    }

    @Override
    public String toString() {
        return "Have_pomotion{" +
                "id=" + id +
                ", idHotel=" + idHotel +
                ", idPromotion=" + idPromotion +
                '}';
    }
}
