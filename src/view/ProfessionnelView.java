package view;

import enums.Secteur;
import enums.SituationFamiliale;
import enums.TypeContrat;
import model.Professionnel;
import service.ProfessionnelService;
import java.util.*;

import java.time.LocalDate;
import java.util.InputMismatchException;

public class ProfessionnelView {
    ProfessionnelService professionnelService = new ProfessionnelService();
    Scanner scanner = new Scanner(System.in);

    public void create(){
        try{
            Professionnel professionnel = new Professionnel(
                    "Hamada",
                    "Tadada",
                    LocalDate.of(1996, 7, 18),
                    "Marrakech",
                    4,
                    true,
                    9000.0,
                    SituationFamiliale.MARRIED,
                    84.0,
                    6500,
                    "A25MHJ56",
                    true,
                    "Agriculture",
                    "Engineer"
            );
            professionnelService.create(professionnel);
        }catch (Exception e){
            System.out.println("View Error: " + e.getMessage());
        }
    }

    public void getProfById(){
        System.out.println("Enter the id of the professionnel: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        try{
            professionnelService.getProfById(id);
        }catch (InputMismatchException e){
            System.out.println("View Error: " + e.getMessage());
        }
    }

    public void delete(){
        System.out.println("Enter the id of the professionnel: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        try{
            professionnelService.delete(id);
        }catch (InputMismatchException e){
            System.out.println("View Error: " + e.getMessage());
        }
    }

    public void getAllProfs(){
        try{
            professionnelService.getAllProfs();
        }catch (Exception e){
            System.out.println("View Error: " + e.getMessage());
        }
    }
}
