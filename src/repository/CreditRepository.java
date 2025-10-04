package repository;

import enums.CreditType;
import enums.DecisionCredit;
import model.Credit;
import util.DBConnection;
import java.sql.*;

public class CreditRepository {
    Connection connection = DBConnection.getConnection();

    public void createEmployeCredit(Credit credit) {
        String query = "INSERT INTO credit (personne_id, date_credit, montant_demande, montant_octroye, taux_interet, duree_en_mois, type_credit, decision) VALUES (?, ?, ?, ?, ?, ?, ?, ?::decision_enum)";

        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, credit.getPersonneId());
            statement.setDate(2, Date.valueOf(credit.getDateCredit()));
            statement.setDouble(3, credit.getAmountRequested());
            statement.setDouble(4, credit.getAmountAllowed());
            statement.setDouble(5, credit.getRate());
            statement.setInt(6, credit.getMonthDuration());
            statement.setString(7, credit.getCreditType().name());
            statement.setString(8, credit.getDecisionCredit().name());

            int rows = statement.executeUpdate();

            if (rows > 0) {
                try (ResultSet key = statement.getGeneratedKeys()) {
                    if (key.next()) {
                        int generatedId = key.getInt(1);
                        credit.setId(generatedId);
                        System.out.println("Generated ID: " + generatedId); // Debug
                    } else {
                        throw new SQLException("Failed to get generated key after insert");
                    }
                }
            } else {
                throw new SQLException("Insert failed, no rows affected");
            }

        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
    }

    public Credit getCreditById(int id) {
        String query = "SELECT id, personne_id, date_credit, montant_demande, montant_octroye, taux_interet, duree_en_mois, type_credit, decision FROM credit WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Credit credit = new Credit(
                            resultSet.getInt("id"),
                            resultSet.getInt("personne_id"),
                            resultSet.getDate("date_credit").toLocalDate(),
                            resultSet.getDouble("montant_demande"),
                            resultSet.getDouble("montant_octroye"),
                            resultSet.getDouble("taux_interet"),
                            resultSet.getInt("duree_en_mois"),
                            CreditType.valueOf(resultSet.getString("type_credit")),
                            DecisionCredit.valueOf(resultSet.getString("decision"))
                    );
                    return credit;
                }
            }
        } catch (SQLException e) {
            System.out.println("Repository Error (getCreditById): " + e.getMessage());
        }
        return null;
    }

}
