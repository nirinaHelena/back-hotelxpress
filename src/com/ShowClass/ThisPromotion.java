package com.ShowClass;

import java.time.LocalDate;

public class ThisPromotion {
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private double reduction;
    private String description;

    public ThisPromotion(int id, LocalDate startDate,
                         LocalDate endDate, double reduction,
                         String description) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reduction = reduction;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
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
        return "ThisPromotion{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", reduction=" + reduction +
                ", description='" + description + '\'' +
                '}';
    }
}
