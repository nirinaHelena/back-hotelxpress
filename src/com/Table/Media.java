package com.Table;

import java.util.Objects;

public class Media {
    private static int idCounter=0;
    private int id;
    private String urlMedia;

    public Media( String urlMedia) {
        this.id = idCounter++;
        this.urlMedia = urlMedia;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public int getId() {
        return id;
    }

    public String getUrlMedia() {
        return urlMedia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Media media = (Media) o;
        return getId() == media.getId() && Objects.equals(getUrlMedia(), media.getUrlMedia());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUrlMedia());
    }

    @Override
    public String toString() {
        return "Media{" +
                "id=" + id +
                ", urlMedia='" + urlMedia + '\'' +
                '}';
    }
}
