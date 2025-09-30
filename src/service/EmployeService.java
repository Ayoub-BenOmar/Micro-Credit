package service;

import util.EmployeValidation;
import model.Employe;
import repository.EmployeRepository;

import java.sql.SQLException;

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

    public void updateEmploye(Employe employe){
        try{
            boolean updated = employeRepository.update(employe);
            if (updated){
                System.out.println("Employee updated successfully");
            }else{
                System.out.println("No employé foud with this id");
            }
        }catch (Exception e){
            System.out.println("Service Error: " +e.getMessage());
        }
    }

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
}
