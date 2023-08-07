package com.ShowClass;

import java.sql.Timestamp;

public class ThisReservation {
    private int idReservation;
    private Timestamp arrival;
    private Timestamp departure;
    private Timestamp dateReservation;
    public ThisReservation(int idReservation,
                           Timestamp arrival,
                           Timestamp departure,
                           Timestamp dateReservation) {
        this.idReservation = idReservation;
        this.arrival = arrival;
        this.departure = departure;
        this.dateReservation = dateReservation;
    }

    @Override
    public String toString() {
        return "ThisReservation{" +
                "idReservation=" + idReservation +
                ", arrival=" + arrival +
                ", departure=" + departure +
                ", dateReservation=" + dateReservation +
                '}';
    }
}
