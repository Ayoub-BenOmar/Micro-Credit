package repository;

import enums.PaymentStatus;
import model.Echeance;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EcheanceRepository {
    Connection connection = DBConnection.getConnection();

    public void createEcheance(Echeance echeance){
            String query = "INSERT INTO echeance (credit_id, date_echeance, mensualite, date_paiement, statut_paiement) VALUES (?, ?, ?, ?, ?::statutpaiement_enum)";
            try (PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, echeance.getCreditId());
                statement.setDate(2, Date.valueOf(echeance.getDateEcheance()));
                statement.setDouble(3, echeance.getMonthly());
                if (echeance.getDatePaiement() != null) {
                    statement.setDate(4, Date.valueOf(echeance.getDatePaiement()));
                } else {
                    statement.setNull(4, java.sql.Types.DATE);
                }
                statement.setString(5, echeance.getPaymentStatus().name());

                statement.executeUpdate();
            }catch (SQLException e){
                System.out.println("Repository Error: " + e.getMessage());
            }
        }

    public void updatePaymentStatus(Integer echeanceId, PaymentStatus status) {
        String query = "UPDATE echeance SET statut_paiement = ?::statutpaiement_enum WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, status.name());
            statement.setInt(2, echeanceId);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 0) {
                throw new SQLException("Failed to update payment status for echeance " + echeanceId);
            }

        } catch (SQLException e) {
            System.err.println("Error updating payment status: " + e.getMessage());
        }
    }

    public List<Echeance> getAllEcheances() {
        List<Echeance> echeances = new ArrayList<>();
        String query = "SELECT id, credit_id, date_echeance, mensualite, date_paiement, statut_paiement FROM echeance";

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Echeance echeance = new Echeance();
                echeance.setId(resultSet.getInt("id"));
                echeance.setCreditId(resultSet.getInt("credit_id"));
                echeance.setDateEcheance(resultSet.getDate("date_echeance").toLocalDate());
                echeance.setMonthly(resultSet.getDouble("mensualite"));

                Date datePaiement = resultSet.getDate("date_paiement");
                if (datePaiement != null) {
                    echeance.setDatePaiement(datePaiement.toLocalDate());
                }

                echeance.setPaymentStatus(PaymentStatus.valueOf(resultSet.getString("statut_paiement")));

                echeances.add(echeance);
            }

        } catch (SQLException e) {
            System.err.println("Error getting all echeances: " + e.getMessage());
        }

        return echeances;
    }
}
