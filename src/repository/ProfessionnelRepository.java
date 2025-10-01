package repository;

import model.Employe;
import model.Professionnel;
import util.DBConnection;
import java.sql.*;

public class ProfessionnelRepository {
    Connection connection = DBConnection.getConnection();

    public void create(Professionnel professionnel){
        String query = "INSERT INTO personne (role, nom, prenom, date_naissance, ville, nombre_enfants, investissement, placement, situation_familiale, score, revenu, immatriculation_fiscale, auto_professionnel, secteur_activite, activite) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, professionnel.getRole());
            statement.setString(2, professionnel.getName());
            statement.setString(3, professionnel.getLastName());
            statement.setDate(4, Date.valueOf(professionnel.getBirthDate()));
            statement.setString(5, professionnel.getCity());
            statement.setInt(6, professionnel.getKidsNumber());
            statement.setBoolean(7, professionnel.isInvestissement());
            statement.setDouble(8,professionnel.getPlacement());
            statement.setString(9, professionnel.getFamilySituation().name());
            statement.setDouble(10, professionnel.getScore());
            statement.setDouble(11, professionnel.getRevenue());
            statement.setString(12, professionnel.getFiscaleImmatriculation());
            statement.setBoolean(13, professionnel.isAutoEntrepreneur());
            statement.setString(14, professionnel.getActivityField());
            statement.setString(15, professionnel.getActivity());

            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Repository Error: " + e.getMessage());
        }
    }

    public int getProfById(Integer id){
        String query = "SELECT nom, prenom FROM personne  WHERE id = ? AND role=2";
        try (PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, id);
            try(ResultSet resultSet = statement.executeQuery()){
                if (resultSet.next()){
                    String nom = resultSet.getString("nom");
                    String prenom = resultSet.getString("prenom");
                    System.out.println("Professionnel found: " + nom + " " + prenom);
                    return 1;
                }else{
                    System.out.println("No Professionnel found with this id");
                    return 0;
                }
            }
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }
}
