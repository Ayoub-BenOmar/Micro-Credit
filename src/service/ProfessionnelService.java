package service;

import model.Professionnel;
import repository.ProfessionnelRepository;
import util.ProfessionnelValidation;

public class ProfessionnelService {
    ProfessionnelRepository professionnelRepository = new ProfessionnelRepository();

    public void create(Professionnel professionnel){
        try{
            if(ProfessionnelValidation.validateProfessionnel(professionnel)){
                professionnelRepository.create(professionnel);
                System.out.println("Professionnel created successfully");
            }else{
                System.out.println("Validation Error: data invalid");
            }
        }catch (Exception e){
            System.out.println("Servivce Error: " + e.getMessage());
        }
    }
}
