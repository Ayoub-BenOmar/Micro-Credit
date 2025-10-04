package service;

import enums.PaymentStatus;
import model.Credit;
import model.Echeance;
import repository.CreditRepository;
import repository.EcheanceRepository;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class EcheanceService {
    EcheanceRepository echeanceRepository = new EcheanceRepository();
    CreditRepository creditRepository = new CreditRepository();

    public void createEcheance(Integer creditId){
        if (creditId == null) {
            throw new IllegalArgumentException("Credit ID cannot be null");
        }

        Credit credit = creditRepository.getCreditById(creditId);
        if (credit == null) {
            throw new IllegalArgumentException("No credit found with id " + creditId);
        }

        try{
            double monthlyPaiement = ((credit.getRate() * credit.getAmountAllowed()) + credit.getAmountAllowed()) / credit.getMonthDuration();

            for (int i = 0; i < credit.getMonthDuration(); i++) {
                LocalDate dateEcheance = LocalDate.now().plusMonths(i + 1);
                Echeance echeance = new Echeance();
                echeance.setDateEcheance(dateEcheance);
                echeance.setMonthly(monthlyPaiement);
                echeance.setPaymentStatus(PaymentStatus.IMPAYE_REGLE);
                echeance.setCreditId(creditId);

                echeanceRepository.createEcheance(echeance);
            }
            System.out.println("Created " + credit.getMonthDuration() + " échéances for credit " + creditId);

        } catch(Exception e){
            System.err.println("Echeance Service Error: " + e.getMessage());
            e.printStackTrace(); // This will show the full error with stack trace
        }
    }

    private PaymentStatus calculatePaymentStatus(Echeance echeance) {
        LocalDate dateEcheance = echeance.getDateEcheance();
        LocalDate datePaiement = echeance.getDatePaiement();
        LocalDate today = LocalDate.now();

        if (datePaiement != null) {
            long daysDifference = ChronoUnit.DAYS.between(dateEcheance, datePaiement);

            if (daysDifference <= 0) {
                return PaymentStatus.PAYE_A_TEMPS;
            } else if (daysDifference <= 30) {
                return PaymentStatus.PAYE_EN_RETARD;
            } else {
                return PaymentStatus.IMPAYE_REGLE;
            }
        } else {
            long daysOverdue = ChronoUnit.DAYS.between(dateEcheance, today);

            if (daysOverdue < 0) {
                return echeance.getPaymentStatus();
            } else if (daysOverdue <= 4) {
                return echeance.getPaymentStatus();
            } else if (daysOverdue <= 30) {
                return PaymentStatus.EN_RETARD;
            } else {
                return PaymentStatus.IMPAYE_NON_REGLE;
            }
        }
    }

    public void updatePaymentStatusAutomatically() {
        List<Echeance> allEcheances = echeanceRepository.getAllEcheances();

        for (Echeance echeance : allEcheances) {
            PaymentStatus newStatus = calculatePaymentStatus(echeance);

            if (!newStatus.equals(echeance.getPaymentStatus())) {
                echeanceRepository.updatePaymentStatus(echeance.getId(), newStatus);
                System.out.println("Updated echeance " + echeance.getId() + " to status: " + newStatus);
            }
        }
    }
}
