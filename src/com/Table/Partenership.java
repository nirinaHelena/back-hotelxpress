package com.Table;

import java.sql.Timestamp;

public class Partenership {
    private static int idCounter=0;
    private int id;
    private Timestamp dateProposition;
    private String partenershipType;
    private Boolean isAccepted;
    private String message;

    public Partenership( Timestamp dateProposition,
                        String partenershipType, Boolean isAccepted,
                        String message) {
        this.id = idCounter++;
        this.dateProposition = dateProposition;
        this.partenershipType = partenershipType;
        this.isAccepted = isAccepted;
        this.message = message;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public int getId() {
        return id;
    }

    public Timestamp getDateProposition() {
        return dateProposition;
    }

    public String getPartenershipType() {
        return partenershipType;
    }

    public Boolean getAccepted() {
        return isAccepted;
    }

    public String getMessage() {
        return message;
    }

    public void setAccepted(Boolean accepted) {
        isAccepted = accepted;
    }

    @Override
    public String toString() {
        return "Partenership{" +
                "id=" + id +
                ", dateProposition=" + dateProposition +
                ", partenershipType='" + partenershipType + '\'' +
                ", isAccepted=" + isAccepted +
                ", message='" + message + '\'' +
                '}';
    }
}
