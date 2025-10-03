package repository;

import enums.DecisionCredit;
import model.Credit;
import model.Employe;
import util.DBConnection;
import util.ScoreCalculation;

import java.sql.*;
import java.util.function.Predicate;

public class CreditRepository {
    Connection connection = DBConnection.getConnection();

    public void createEmployeCredit(Credit credit){
        String query = "INSERT INTO credit (personne_id, date_credit, montant_demande, montant_octroye, taux_interet, duree_en_mois, type_credit, decision) VALUES (?, ?, ?, ?, ?, ?, ?, ?::decision_enum)";
        try (PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, credit.getPersonneId());
            statement.setDate(2, Date.valueOf(credit.getDateCredit()));
            statement.setDouble(3, credit.getAmountRequested());
            statement.setDouble(4, credit.getAmountAllowed());
            statement.setDouble(5, credit.getRate());
            statement.setInt(6, credit.getMonthDuration());
            statement.setString(7, credit.getCreditType().name());
            statement.setString(8, credit.getDecisionCredit().name());

            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
