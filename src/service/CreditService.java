package service;

import enums.DecisionCredit;
import enums.TypeContrat;
import model.Credit;
import model.Echeance;
import model.Employe;
import repository.CreditRepository;
import repository.EmployeRepository;
import util.ScoreCalculation;

public class CreditService {
    CreditRepository creditRepository = new CreditRepository();
    EmployeRepository employeRepository = new EmployeRepository();
    EcheanceService echeanceService = new EcheanceService();

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

    public void createEmployeCredit(Integer employeId, Credit credit) {
        try {
            Employe employe = employeRepository.getEmployeById(employeId);

            if (employe == null) {
                throw new IllegalArgumentException("No employee found with id " + employeId);
            }

            if (employe.isNewClient()) {
                if (employe.getScore() >= 60 && employe.getScore() <= 79) {
                    credit.setAmountAllowed(employe.getSalary() * 4);
                }
            } else {
                if (employe.getScore() >= 60 && employe.getScore() <= 79) {
                    credit.setAmountAllowed(employe.getSalary() * 7);
                } else if (employe.getScore() >= 80) {
                    credit.setAmountAllowed(employe.getSalary() * 10);
                }
            }

            if (employe.getScore() >= 80) {
                credit.setDecisionCredit(DecisionCredit.ACCORD_IMMEDIAT);
            } else if (employe.getScore() >= 60 && employe.getScore() <= 79) {
                credit.setDecisionCredit(DecisionCredit.ETUDE_MANUELLE);
            } else {
                credit.setDecisionCredit(DecisionCredit.REFUS_AUTOMATIQUE);
            }

            creditRepository.createEmployeCredit(credit);

            if (credit.getId() == null || credit.getId() == 0) {
                throw new IllegalStateException("Credit ID was not generated after save");
            }

            if (DecisionCredit.ACCORD_IMMEDIAT.equals(credit.getDecisionCredit())) {
                echeanceService.createEcheance(credit.getId());
            }

            employeRepository.updateNewClientStatus(employeId, false);

            System.out.println("Credit created for employee id = " + employeId);

        } catch (Exception e) {
            System.err.println("Service credit error: " + e.getMessage());
        }
    }
}
