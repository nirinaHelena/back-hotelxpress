package com.Table;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

public class Reservation {
    private static int idCounter=0;
    private int idReservation;
    private Timestamp arrival;
    private Timestamp departure;
    private Timestamp dateReservation;
    private int idUser;

    public Reservation(Timestamp arrival, Timestamp departure, Timestamp dateReservation, int idUser) {
        this.idReservation = idCounter++;
        this.arrival = arrival;
        this.departure = departure;
        this.dateReservation = dateReservation;
        this.idUser = idUser;
    }
}
