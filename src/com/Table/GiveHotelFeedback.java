package com.Table;

import java.time.LocalDate;

public class GiveHotelFeedback {
    private static int idCounter=0;
    private int id;
    private String textBody;
    private LocalDate dateFeedback;
    private int note;
    private int idHotel;
    private int idUser;

    public GiveHotelFeedback( String textBody,
                             LocalDate dateFeedback, int note,
                             int idHotel, int idUser) {
        this.id = idCounter++;
        this.textBody = textBody;
        this.dateFeedback = dateFeedback;
        this.note = note;
        this.idHotel = idHotel;
        this.idUser = idUser;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public int getId() {
        return id;
    }

    public String getTextBody() {
        return textBody;
    }

    public LocalDate getDateFeedback() {
        return dateFeedback;
    }

    public int getNote() {
        return note;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public int getIdUser() {
        return idUser;
    }

    @Override
    public String toString() {
        return "GiveHotelFeedback{" +
                "id=" + id +
                ", textBody='" + textBody + '\'' +
                ", dateFeedback=" + dateFeedback +
                ", note=" + note +
                ", idHotel=" + idHotel +
                ", idUser=" + idUser +
                '}';
    }
}
