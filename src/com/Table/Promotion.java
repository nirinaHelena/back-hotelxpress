package com.Table;

import java.time.LocalDate;

public class Promotion {
    private static int idCounter = 0;
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private double reduction;
    private String description;

    public Promotion(LocalDate start_date, LocalDate end_date, double reduction, String description) {
        this.id = idCounter++;
        this.startDate = start_date;
        this.endDate = end_date;
        this.reduction = reduction;
        this.description = description;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public int getId() {
        return id;
    }

    public LocalDate getStart_date() {
        return startDate;
    }

    public LocalDate getEnd_date() {
        return endDate;
    }

    public double getReduction() {
        return reduction;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "id=" + id +
                ", start_date=" + startDate +
                ", end_date=" + endDate +
                ", reduction=" + reduction +
                ", description='" + description + '\'' +
                '}';
    }
}
