package model;

import enums.SituationFamiliale;

import java.time.LocalDate;

public abstract class Person {
    private Integer id;
    private Integer role;
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private String city;
    private int kidsNumber;
    private boolean investissement ;
    private double placement;
    private SituationFamiliale familySituation;
    private double score;

    public Person(Integer role, String name, String lastName, LocalDate birthDate, String city, int kidsNumber, boolean investissement, double placement, SituationFamiliale familySituation, double score) {
        this.role = role;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.city = city;
        this.kidsNumber = kidsNumber;
        this.investissement  = investissement ;
        this.placement = placement;
        this.familySituation = familySituation;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getKidsNumber() {
        return kidsNumber;
    }

    public void setKidsNumber(int kidsNumber) {
        this.kidsNumber = kidsNumber;
    }

    public boolean isInvestissement () {
        return investissement;
    }

    public void setInvestissement (boolean investissement) {
        this.investissement = investissement;
    }

    public double getPlacement() {
        return placement;
    }

    public void setPlacement(double placement) {
        this.placement = placement;
    }

    public SituationFamiliale getFamilySituation() {
        return familySituation;
    }

    public void setFamilySituation(SituationFamiliale familySituation) {
        this.familySituation = familySituation;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
