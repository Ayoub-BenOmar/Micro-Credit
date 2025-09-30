package repository;

import util.DBConnection;
import model.Employe;

import java.sql.*;

public class EmployeRepository {
    Connection connection = DBConnection.getConnection();

    public void create(Employe employe){
        String query = "INSERT INTO personne (role, nom, prenom, date_naissance, ville, nombre_enfants, investissement, placement, situation_familiale, score, salaire, anciennete, poste, type_contrat, secteur_entreprise) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, employe.getRole());
            statement.setString(2, employe.getName());
            statement.setString(3, employe.getLastName());
            statement.setDate(4, Date.valueOf(employe.getBirthDate()));
            statement.setString(5, employe.getCity());
            statement.setInt(6, employe.getKidsNumber());
            statement.setBoolean(7, employe.isInvestissement());
            statement.setDouble(8,employe.getPlacement());
            statement.setString(9, employe.getFamilySituation().name());
            statement.setDouble(10, employe.getScore());
            statement.setDouble(11, employe.getSalary());
            statement.setDouble(12, employe.getSeniority());
            statement.setString(13, employe.getPost());
            statement.setString(14, employe.getTypeContrat().name());
            statement.setString(15, employe.getSecteur().name());

            statement.executeUpdate();
            System.out.println("Employee created successfully");
        }catch (SQLException e){
            System.out.println("Repository Error: " + e.getMessage());
        }
    }

    public boolean update(Employe employe){
        String query = "UPDATE personne SET ville = ?, nombre_enfants = ?, investissment = ?, placement = ?, situation_familiale = ?, salaire = ?, anciennete = ?, poste = ?, type_contrat = ?, secteur_entreprise = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, employe.getCity());
            statement.setInt(2, employe.getKidsNumber());
            statement.setBoolean(3, employe.isInvestissement());
            statement.setDouble(4, employe.getPlacement());
            statement.setString(5, employe.getFamilySituation().name());
            statement.setDouble(6, employe.getSalary());
            statement.setDouble(7, employe.getSeniority());
            statement.setString(8, employe.getPost());
            statement.setString(9, employe.getTypeContrat().name());
            statement.setString(10, employe.getSecteur().name());
            statement.setInt(11, employe.getId());

            int rows = statement.executeUpdate();
            return rows > 0;
        }catch (SQLException e){
            System.out.println("Repository Error: " + e.getMessage());
        }
        return false;
    }

    public int getEmployeById(Integer id){
        String query = "SELECT nom, prenom FROM personne  WHERE id = ? AND role=1";
        try (PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, id);
            try(ResultSet resultSet = statement.executeQuery()){
                if (resultSet.next()){
                    String nom = resultSet.getString("nom");
                    String prenom = resultSet.getString("prenom");
                    System.out.println("Employe found: " + nom + " " + prenom);
                    return 1;
                }else{
                    System.out.println("No employe found with this id");
                    return 0;
                }
            }
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }

}
