package com.Table;

import java.util.Objects;
import java.util.UUID;

public class RoomContent {
    private static int idCounter=0;
    private int idContent;
    private String contentName;
    private String contentUrlImg;

    public RoomContent( String contentName,
                       String contentUrlImg) {
        this.idContent = idCounter++;
        this.contentName = contentName;
        this.contentUrlImg = contentUrlImg;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public int getIdContent() {
        return idContent;
    }

    public String getContentName() {
        return contentName;
    }

    public String getContentUrlImg() {
        return contentUrlImg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomContent that = (RoomContent) o;
        return getIdContent() == that.getIdContent() && Objects.equals(getContentName(), that.getContentName()) && Objects.equals(getContentUrlImg(), that.getContentUrlImg());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdContent(), getContentName(), getContentUrlImg());
    }

    @Override
    public String toString() {
        return "RoomContent{" +
                "idContent=" + idContent +
                ", contentName='" + contentName + '\'' +
                ", contentUrlImg='" + contentUrlImg + '\'' +
                '}';
    }
}
