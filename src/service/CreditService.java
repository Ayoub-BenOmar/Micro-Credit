package service;

import enums.DecisionCredit;
import enums.TypeContrat;
import model.Credit;
import model.Employe;
import repository.CreditRepository;
import repository.EmployeRepository;
import util.ScoreCalculation;

public class CreditService {
    CreditRepository creditRepository = new CreditRepository();
    EmployeRepository employeRepository = new EmployeRepository();
    public DecisionCredit decisionCredit(Employe employe){
        ScoreCalculation scoreCalculation = new ScoreCalculation();
        int score = scoreCalculation.employeTotalScore(employe);
        if (score >= 80){
            return DecisionCredit.ACCORD_IMMEDIAT;
        } else if (score >= 60 && score <= 79) {
            return  DecisionCredit.ETUDE_MANUELLE;
        } else {
            return DecisionCredit.REFUS_AUTOMATIQUE;
        }
    }

    public void createEmployeCredit(Integer employeId, Credit credit){
        try{
            Employe employe = employeRepository.getEmployeById(employeId);

            if (employe == null) {
                System.out.println("No employee found with id " + employeId);
                return;
            }

            try {
                if (employe.isNewClient()){
                    if (employe.getScore() >= 60 && employe.getScore() <= 79){
                        credit.setAmountAllowed(employe.getSalary() * 4);
                    }
                }else{
                    if (employe.getScore() >= 60 && employe.getScore() <= 79){
                        credit.setAmountAllowed(employe.getSalary() * 7);
                    } else if (employe.getScore() > 80) {
                        System.out.println("dkhel");
                        credit.setAmountAllowed(employe.getSalary() * 10);
                        System.out.println("khrej");
                    }
                }
            }catch (Exception e){
                throw new Exception(e.getMessage());
            }

            try {
                if (employe.getScore() >= 80){
                    credit.setDecisionCredit(DecisionCredit.ACCORD_IMMEDIAT);
                } else if (employe.getScore() >= 60 && employe.getScore() <= 79) {
                    credit.setDecisionCredit(DecisionCredit.ETUDE_MANUELLE);
                } else {
                    credit.setDecisionCredit(DecisionCredit.REFUS_AUTOMATIQUE);
                }
            }catch (Exception e){
                throw new Exception(e.getMessage());
            }

            creditRepository.createEmployeCredit(credit);
            employe.setNewClient(false);
            System.out.println("Credit created for employee id = " + employeId);
        }catch (Exception e){
            System.out.println("Service Error: " + e.getMessage());
        }
    }
}
