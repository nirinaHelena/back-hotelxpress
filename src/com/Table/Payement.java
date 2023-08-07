package com.Table;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

public class Payement {
    private static int idCounter=0;
    private int idPayement;
    //TODO: chercher l'équivalent de timestamp dans java
    private Timestamp datePayement;
    private String methodPayement;
    private Double amountPaid;

    public Payement(Timestamp datePayement,
                    String methodPayement, Double amountPaid) {
        this.idPayement = idCounter++;
        this.datePayement = datePayement;
        this.methodPayement = methodPayement;
        this.amountPaid = amountPaid;
    }
    // TODO: on a pas changé le amountPaid

    public int getIdPayement() {
        return idPayement;
    }

    public Timestamp getDatePayement() {
        return datePayement;
    }

    public String getMethodPayement() {
        return methodPayement;
    }

    public Double getAmountPaid() {
        return amountPaid;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payement payement = (Payement) o;
        return getIdPayement() == payement.getIdPayement() && Objects.equals(getAmountPaid(), payement.getAmountPaid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdPayement(), getAmountPaid());
    }

    @Override
    public String toString() {
        return "Payement{" +
                "idPayement=" + idPayement +
                ", datePayement=" + datePayement +
                ", methodPayement='" + methodPayement + '\'' +
                ", amountPaid=" + amountPaid +
                '}';
    }
}
