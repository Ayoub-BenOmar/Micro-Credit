package view;

import enums.Secteur;
import enums.SituationFamiliale;
import enums.TypeContrat;
import model.Employe;
import service.EmployeService;

import java.time.LocalDate;
import java.util.*;

public class EmployeView {
    EmployeService employeService = new EmployeService();
    Scanner scanner = new Scanner(System.in);

    public void createEmploye() {
        Employe emp = new Employe(
                "Ayoub",
                "Ben Omar",
                LocalDate.of(2020, 7, 18),
                "Casablanca",
                2,
                true,
                5000.0,
                SituationFamiliale.MARRIED,
                85.0,
                12000.0,
                5,
                "Manager",
                TypeContrat.CDI,
                Secteur.GRANDE_ENTREPRISE
        );

        employeService.createEmploye(emp);
    }

    public void updateEmploye(){
        Employe emp = new Employe(
                "Casablanca",
                2,
                true,
                5000.0,
                SituationFamiliale.MARRIED,
                85.0,
                12000.0,
                5,
                "Manager",
                TypeContrat.CDI,
                Secteur.GRANDE_ENTREPRISE
        );

        employeService.createEmploye(emp);
    }
}
