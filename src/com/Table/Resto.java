package com.Table;

import java.util.Objects;

public class Resto {
    private static int idCounter=0;
    private int id;
    private String speciality;
    private String restoUrlImg;
    private String description;
    private int idHotel;

    public Resto( String speciality,
                 String restoUrlImg,
                 String description, int idHotel) {
        this.id = idCounter++;
        this.speciality = speciality;
        this.restoUrlImg = restoUrlImg;
        this.description = description;
        this.idHotel = idHotel;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public int getId() {
        return id;
    }

    public String getSpeciality() {
        return speciality;
    }

    public String getRestoUrlImg() {
        return restoUrlImg;
    }

    public String getDescription() {
        return description;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public void setRestoUrlImg(String restoUrlImg) {
        this.restoUrlImg = restoUrlImg;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resto resto = (Resto) o;
        return getId() == resto.getId() && getIdHotel() == resto.getIdHotel() && Objects.equals(getSpeciality(), resto.getSpeciality()) && Objects.equals(getRestoUrlImg(), resto.getRestoUrlImg()) && Objects.equals(getDescription(), resto.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSpeciality(), getRestoUrlImg(), getDescription(), getIdHotel());
    }

    @Override
    public String toString() {
        return "Resto{" +
                "id=" + id +
                ", speciality='" + speciality + '\'' +
                ", restoUrlImg='" + restoUrlImg + '\'' +
                ", description='" + description + '\'' +
                ", idHotel=" + idHotel +
                '}';
    }
}
