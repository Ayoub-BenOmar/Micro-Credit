package model;

import enums.SituationFamiliale;

import java.time.LocalDate;

public class Professionnel extends Person{
    private Integer id;
    private double revenue;
    private String fiscaleImmatriculation;
    private boolean autoEntrepreneur;
    private String activityField;
    private String activity;

    public Professionnel(String name, String lastName, LocalDate birthDate, String city, int kidsNumber, boolean investissement, double placement, SituationFamiliale familySituation, double score, double revenue, String fiscaleImmatriculation, boolean autoEntrepreneur, String activityField, String activity) {
        super(2, name, lastName, birthDate, city, kidsNumber, investissement, placement, familySituation, score);
        this.revenue = revenue;
        this.fiscaleImmatriculation = fiscaleImmatriculation;
        this.autoEntrepreneur = autoEntrepreneur;
        this.activityField = activityField;
        this.activity = activity;
    }

    public Professionnel(Integer id, String name, String lastName, LocalDate birthDate, String city, int kidsNumber, boolean investissement, double placement, SituationFamiliale familySituation, double score, double revenue, String fiscaleImmatriculation, boolean autoEntrepreneur, String activityField, String activity) {
        super(2, name, lastName, birthDate, city, kidsNumber, investissement, placement, familySituation, score);
        this.id = id;
        this.revenue = revenue;
        this.fiscaleImmatriculation = fiscaleImmatriculation;
        this.autoEntrepreneur = autoEntrepreneur;
        this.activityField = activityField;
        this.activity = activity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public String getFiscaleImmatriculation() {
        return fiscaleImmatriculation;
    }

    public void setFiscaleImmatriculation(String fiscaleImmatriculation) {
        this.fiscaleImmatriculation = fiscaleImmatriculation;
    }

    public boolean isAutoEntrepreneur() {
        return autoEntrepreneur;
    }

    public void setAutoEntrepreneur(boolean autoEntrepreneur) {
        this.autoEntrepreneur = autoEntrepreneur;
    }

    public String getActivityField() {
        return activityField;
    }

    public void setActivityField(String activityField) {
        this.activityField = activityField;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
}
