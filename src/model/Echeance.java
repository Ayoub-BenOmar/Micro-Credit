package model;

import enums.PaymentStatus;

import java.time.LocalDate;

public class Echeance {
    private int id;
    private int creditId;
    private LocalDate dateEcheance;
    private double monthly;
    private LocalDate datePaiement;
    private PaymentStatus paymentStatus;

    public Echeance(int id, int creditId, LocalDate dateEcheance, double monthly, LocalDate datePaiement, PaymentStatus paymentStatus) {
        this.id = id;
        this.creditId = creditId;
        this.dateEcheance = dateEcheance;
        this.monthly = monthly;
        this.datePaiement = datePaiement;
        this.paymentStatus = paymentStatus;
    }

    public Echeance() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCreditId() {
        return creditId;
    }

    public void setCreditId(int creditId) {
        this.creditId = creditId;
    }

    public LocalDate getDateEcheance() {
        return dateEcheance;
    }

    public void setDateEcheance(LocalDate dateEcheance) {
        this.dateEcheance = dateEcheance;
    }

    public double getMonthly() {
        return monthly;
    }

    public void setMonthly(double monthly) {
        this.monthly = monthly;
    }

    public LocalDate getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(LocalDate datePaiement) {
        this.datePaiement = datePaiement;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
