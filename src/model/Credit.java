package model;

import enums.CreditType;
import enums.DecisionCredit;
import java.time.*;

public class Credit {
    private int id;
    private int personneId;
    private LocalDate dateCredit;
    private double amountRequested;
    private double amountAllowed;
    private double rate;
    private int monthDuration;
    private CreditType creditType;
    private DecisionCredit decisionCredit;

    public Credit(LocalDate dateCredit, double amountRequested, double amountAllowed, double rate, int monthDuration, CreditType creditType, DecisionCredit decisionCredit) {
        this.dateCredit = dateCredit;
        this.amountRequested = amountRequested;
        this.amountAllowed = amountAllowed;
        this.rate = rate;
        this.monthDuration = monthDuration;
        this.creditType = creditType;
        this.decisionCredit = decisionCredit;
    }

    public Credit(int personneId, LocalDate dateCredit, double amountRequested, int monthDuration, double rate, CreditType creditType) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonneId() {
        return personneId;
    }

    public void setPersonneId(int personneId) {
        this.personneId = personneId;
    }

    public LocalDate getDateCredit() {
        return dateCredit;
    }

    public void setDateCredit(LocalDate dateCredit) {
        this.dateCredit = dateCredit;
    }

    public double getAmountRequested() {
        return amountRequested;
    }

    public void setAmountRequested(double amountRequested) {
        this.amountRequested = amountRequested;
    }

    public double getAmountAllowed() {
        return amountAllowed;
    }

    public void setAmountAllowed(double amountAllowed) {
        this.amountAllowed = amountAllowed;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getMonthDuration() {
        return monthDuration;
    }

    public void setMonthDuration(int monthDuration) {
        this.monthDuration = monthDuration;
    }

    public CreditType getCreditType() {
        return creditType;
    }

    public void setCreditType(CreditType creditType) {
        this.creditType = creditType;
    }

    public DecisionCredit getDecisionCredit() {
        return decisionCredit;
    }

    public void setDecisionCredit(DecisionCredit decisionCredit) {
        this.decisionCredit = decisionCredit;
    }
}
