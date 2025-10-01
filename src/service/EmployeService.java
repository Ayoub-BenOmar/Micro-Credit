package service;

import util.EmployeValidation;
import model.Employe;
import repository.EmployeRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeService {
    EmployeRepository employeRepository = new EmployeRepository();

    public void createEmploye(Employe employe){
        try{
            if (EmployeValidation.validateEmploye(employe)) {
                employeRepository.create(employe);
            } else {
                System.out.println("Validation Error: employé data is invalid");
            }
        }catch (Exception e){
            System.out.println("Service Error: " + e.getMessage());
        }
    }

//    public void updateEmploye(Employe employe){
//        try{
//            boolean updated = employeRepository.update(employe);
//            if (updated){
//                System.out.println("Employee updated successfully");
//            }else{
//                System.out.println("No employé foud with this id");
//            }
//        }catch (Exception e){
//            System.out.println("Service Error: " +e.getMessage());
//        }
//    }

    public void getEmployeById(Integer id){
        try{
            if (id == null || id <= 0){
                System.out.println("Enter a valid id number");
                return;
            }

            employeRepository.getEmployeById(id);
        }catch (Exception e){
            System.out.println("Service Error: " + e.getMessage());
        }
    }

    public void deleteEmploye(Integer id){
        try{
            if(id ==  null || id <= 0){
                System.out.println("Enter a valid id number");
                return;
            }
            employeRepository.delete(id);
            System.out.println("The employe deleted");
        }catch (Exception e){
            System.out.println("Service Error: " + e.getMessage());
        }
    }

    public void getAllEmployes(){
        try {
            List<Employe> employes = employeRepository.getAllEmployes();
            employes.forEach(employe -> System.out.println(
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
                            employe.getSalary() + ", " +
                            employe.getSeniority() + ", " +
                            employe.getPost() + ", " +
                            employe.getTypeContrat() + ", " +
                            employe.getSecteur()
            ));
        } catch (Exception e) {
            System.out.println("Service Error: " + e.getMessage());
        }
    }
}
