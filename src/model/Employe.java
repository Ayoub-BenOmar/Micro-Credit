package model;

import enums.Secteur;
import enums.SituationFamiliale;
import enums.TypeContrat;

import java.time.LocalDate;

public class Employe extends Person{
    private double salary;
    private double seniority;
    private String post;
    private TypeContrat typeContrat;
    private Secteur secteur;

    public Employe(String name, String lastName, LocalDate birthDate, String city, int kidsNumber, boolean investissement, double placement, SituationFamiliale familySituation, double score, double salary, double seniority, String post, TypeContrat typeContrat, Secteur secteur) {
        super(1, name, lastName, birthDate, city, kidsNumber, investissement, placement, familySituation, score);
        this.salary = salary;
        this.seniority = seniority;
        this.post = post;
        this.typeContrat = typeContrat;
        this.secteur = secteur;
    }

//    public Employe(String city, int kidsNumber, boolean investissement, double placement, SituationFamiliale familySituation, double score, double salary, double seniority, String post, TypeContrat typeContrat, Secteur secteur){}

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSeniority() {
        return seniority;
    }

    public void setSeniority(double seniority) {
        this.seniority = seniority;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public TypeContrat getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(TypeContrat typeContrat) {
        this.typeContrat = typeContrat;
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }
}
