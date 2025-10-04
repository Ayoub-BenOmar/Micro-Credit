package model;

import enums.PaymentStatus;
import java.time.*;

public class Incident {
    private Integer id;
    private Integer personneId;
    private Integer echeanceId;
    private LocalDate dateIncident;
    private Double score;
    private PaymentStatus paymentStatus;

    public Incident() {}

    public Incident(Integer personneId, Integer echeanceId, PaymentStatus paymentStatus, Double score) {
        this.personneId = personneId;
        this.echeanceId = echeanceId;
        this.paymentStatus = paymentStatus;
        this.score = score;
        this.dateIncident = LocalDate.now();
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getPersonneId() { return personneId; }
    public void setPersonneId(Integer personneId) { this.personneId = personneId; }

    public Integer getEcheanceId() { return echeanceId; }
    public void setEcheanceId(Integer echeanceId) { this.echeanceId = echeanceId; }

    public LocalDate getDateIncident() { return dateIncident; }
    public void setDateIncident(LocalDate dateIncident) { this.dateIncident = dateIncident; }

    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }

    public PaymentStatus getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(PaymentStatus paymentStatus) { this.paymentStatus = paymentStatus; }
}
