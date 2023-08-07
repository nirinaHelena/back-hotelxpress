package com.Table;

public class Bookmarks {
    private static int idCounter=0;
    private int id;
    private String bookmarkName;
    private int idRoom;
    private int idUser;

    public Bookmarks(String bookmarkName, int idRoom, int idUser) {
        this.id = idCounter;
        this.bookmarkName = bookmarkName;
        this.idRoom = idRoom;
        this.idUser = idUser;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public int getId() {
        return id;
    }

    public String getBookmarkName() {
        return bookmarkName;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setBookmarkName(String bookmarkName) {
        this.bookmarkName = bookmarkName;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    @Override
    public String toString() {
        return "Bookmarks{" +
                "id=" + id +
                ", bookmarkName='" + bookmarkName + '\'' +
                ", idRoom=" + idRoom +
                ", idUser=" + idUser +
                '}';
    }
}
