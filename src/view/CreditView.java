package view;

import enums.CreditType;
import enums.DecisionCredit;
import model.Credit;
import model.Echeance;
import service.CreditService;

import java.time.LocalDate;
import java.util.Scanner;

public class CreditView {

    CreditService creditService = new CreditService();

    public void createCreditView() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("=== Créer un Crédit ===");

            System.out.print("ID de l'employé : ");
            int employeId = sc.nextInt();
            sc.nextLine();

            System.out.print("Montant demandé : ");
            double amountRequested = sc.nextDouble();
            sc.nextLine();

            System.out.print("Taux d'intérêt : ");
            double rate = sc.nextDouble();
            sc.nextLine();

            System.out.print("Durée (en mois) : ");
            int duree = sc.nextInt();
            sc.nextLine();

            System.out.println("Type de crédit : ");
            for (CreditType type : CreditType.values()) {
                System.out.println("- " + type.name());
            }
            String typeInput = sc.nextLine().toUpperCase();
            CreditType typeCredit = CreditType.valueOf(typeInput);

            LocalDate dateCredit = LocalDate.now();

            Credit credit = new Credit(employeId, dateCredit, amountRequested, duree, rate, typeCredit);
            credit.setPersonneId(employeId);
            credit.setDateCredit(dateCredit);
            credit.setAmountRequested(amountRequested);
            credit.setMonthDuration(duree);
            credit.setRate(rate);
            credit.setCreditType(typeCredit);
            credit.setDecisionCredit(DecisionCredit.ETUDE_MANUELLE);

            creditService.createEmployeCredit(employeId, credit);

        } catch (IllegalArgumentException e) {
            System.err.println("Erreur de validation : " + e.getMessage());
        } catch (IllegalStateException e) {
            System.err.println("Erreur d'état : " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erreur lors de la création du crédit : " + e.getMessage());
        }
    }
}
