package com.Table;

public class HaveMedia {
    private static int idCounter = 0;
    private int id;
    private int idHotel;
    private int idMedia;

    public HaveMedia(int idHotel, int idMedia) {
        this.id = idCounter++;
        this.idHotel = idHotel;
        this.idMedia = idMedia;
    }

    public int getId() {
        return id;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public int getIdMedia() {
        return idMedia;
    }

    @Override
    public String toString() {
        return "have_media{" +
                "id=" + id +
                ", idHotel=" + idHotel +
                ", idMedia=" + idMedia +
                '}';
    }
}
