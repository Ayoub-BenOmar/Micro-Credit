package service;

import model.Employe;
import model.Professionnel;
import repository.ProfessionnelRepository;
import util.ProfessionnelValidation;

import java.util.List;

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

    public void getProfById(Integer id){
        try{
            if (id == null || id <= 0){
                System.out.println("Enter a valid id number");
                return;
            }

            professionnelRepository.getProfById(id);
        }catch (Exception e){
            System.out.println("Service Error: " + e.getMessage());
        }
    }

    public void delete(Integer id){
        try{
            if(id ==  null || id <= 0){
                System.out.println("Enter a valid id number");
                return;
            }
            if (professionnelRepository.delete(id) == 1){
                System.out.println("The professionnel deleted");
            }else {
                System.out.println("No professionnel found with this id");
                return;
            }
        }catch (Exception e){
            System.out.println("Service Error: " + e.getMessage());
        }
    }

    public void getAllProfs(){
        try {
            List<Professionnel> professionnels = professionnelRepository.getAllProfs();
            professionnels.forEach(employe -> System.out.println(
                    employe.getId() + ", " +
                            employe.getName() + ", " +
                            employe.getLastName() + ", " +
                            employe.getBirthDate() + ", " +
                            employe.getCity() + ", " +
                            employe.getKidsNumber() + ", " +
                            employe.isInvestissement() + ", " +
                            employe.getPlacement() + ", " +
                            employe.getFamilySituation() + ", " +
                            employe.getScore() + ", " +
                            employe.getRevenue() + ", " +
                            employe.getFiscaleImmatriculation() + ", " +
                            employe.isAutoEntrepreneur() + ", " +
                            employe.getActivityField() + ", " +
                            employe.getActivity()
            ));
        } catch (Exception e) {
            System.out.println("Service Error: " + e.getMessage());
        }
    }
}
