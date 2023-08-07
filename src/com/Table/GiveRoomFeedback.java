package com.Table;

public class GiveRoomFeedback {
    private static int idCounter = 0;
    private int id;
    private String textBody;
    private String note;
    private int idRoom;
    private int idUser;

    public GiveRoomFeedback( String textBody, String note, int idRoom, int idUser) {
        this.id = idCounter++;
        this.textBody = textBody;
        this.note = note;
        this.idRoom = idRoom;
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

    public String getNote() {
        return note;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public int getIdUser() {
        return idUser;
    }

    @Override
    public String toString() {
        return "GiveRoomFeedback{" +
                "id=" + id +
                ", textBody='" + textBody + '\'' +
                ", note='" + note + '\'' +
                ", idRoom=" + idRoom +
                ", idUser=" + idUser +
                '}';
    }
}
