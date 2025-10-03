package util;

import enums.Secteur;
import enums.SituationFamiliale;
import enums.TypeContrat;
import model.Employe;

import java.time.LocalDate;
import java.time.Period;

public class ScoreCalculation {

    // stabilité professionnelle
    public int employeStabilityProf(Employe employe){
        int counter = 0;
        int counter1;
        if (employe.getTypeContrat() == TypeContrat.CDI ){
            if (employe.getSecteur() == Secteur.PUBLIC){
                counter = 25;
            } else if (employe.getSecteur() == Secteur.GRANDE_ENTREPRISE) {
                counter = 15;
            }else{
                counter = 12;
            }
        }else if (employe.getTypeContrat() == TypeContrat.CDD){
            counter = 10;
        }

        if(employe.getSeniority() >= 5){
            counter1 = 5;
        } else if (employe.getSeniority() < 5 && employe.getSeniority() >= 2) {
            counter1 = 3;
        } else if (employe.getSeniority() == 1) {
            counter1 = 1;
        }else {
            counter1 = 0;
        }

        return counter1 + counter;
    }

    // critères complémentaires
    public int employePatrimoine(Employe employe){
        int counter;
        if (employe.isInvestissement()){
            counter = 10;
        }else {
            counter = 0;
        }
        return counter;
    }

    // relation client
    public int employeAge(Employe employe){
        int counter = 0;
        LocalDate today = LocalDate.now();
        int age = Period.between(employe.getBirthDate(), today).getYears();
        if (age >= 18 && age <= 25){
            counter = 4;
        } else if (age >= 26 && age <= 35) {
            counter = 8;
        } else if (age >= 36 && age <= 55) {
            counter = 10;
        } else if (age > 55) {
            counter = 6;
        }

        return counter;
    }

    public int employeFamilySituation(Employe employe){
        int counter = 0;
        if (employe.getFamilySituation() == SituationFamiliale.MARRIED){
            counter = 3;
        } else if (employe.getFamilySituation() == SituationFamiliale.SINGLE) {
            counter = 2;
        }

        return counter;
    }

    public int employeKids(Employe employe){
        int counter = 0;
        if (employe.getKidsNumber() < 1){
            counter = 2;
        } else if (employe.getKidsNumber() == 1 || employe.getKidsNumber() == 2) {
            counter = 1;
        }
        return counter;
    }


    public int employeTotalScore(Employe employe){
        return employe.setScore(employeAge(employe) + employeStabilityProf(employe) + employePatrimoine(employe) + employeFamilySituation(employe) + employeKids(employe));
    }

}
