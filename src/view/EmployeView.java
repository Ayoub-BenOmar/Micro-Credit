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
                "Samil",
                "Baoud",
                LocalDate.of(2004, 7, 18),
                "Essaouira",
                0,
                true,
                3000.0,
                SituationFamiliale.SINGLE,
                88.0,
                22000.0,
                9,
                "Manager",
                TypeContrat.CDI,
                Secteur.GRANDE_ENTREPRISE
        );

        employeService.createEmploye(emp);
    }

//    public void updateEmploye(){
//        Employe emp = new Employe(
//                "Casablanca",
//                2,
//                true,
//                5000.0,
//                SituationFamiliale.MARRIED,
//                85.0,
//                12000.0,
//                5,
//                "Manager",
//                TypeContrat.CDI,
//                Secteur.GRANDE_ENTREPRISE
//        );
//
//        employeService.createEmploye(emp);
//    }

    public void getEmployeById(){
        System.out.println("Enter the id of the employe: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        try{
            employeService.getEmployeById(id);
        }catch (InputMismatchException e){
            System.out.println("View Error: " + e.getMessage());
        }
    }

    public void deleteEmploye(){
        System.out.println("Enter the id of the employe: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        try{
            employeService.deleteEmploye(id);
        }catch (InputMismatchException e){
            System.out.println("View Error: " + e.getMessage());
        }
    }
}
