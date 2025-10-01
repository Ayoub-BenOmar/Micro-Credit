package view;

import enums.Secteur;
import enums.SituationFamiliale;
import enums.TypeContrat;
import model.Professionnel;
import service.ProfessionnelService;

import java.time.LocalDate;

public class ProfessionnelView {
    ProfessionnelService professionnelService = new ProfessionnelService();

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
}
