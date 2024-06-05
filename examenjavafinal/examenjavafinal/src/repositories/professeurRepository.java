package repositories;

import java.sql.SQLException;

import entities.professeur;

public class professeurRepository extends Database{
    private final String SQL_INSERT_PROFESSEUR="INSERT INTO `professeur` (`nom`, 'prenom','tel') VALUES (?,?,?);";
    public void insertProfesseur(professeur Professeur){
        try {
             ouvrirConnexion();
             initPrepareStatement(SQL_INSERT_PROFESSEUR);
            statement.setString(1,Professeur.getNom());
            statement.setString(1,Professeur.getPrenom());
            statement.setInt(1,Professeur.getTel());
             executeUpdate();
        } catch (SQLException e) {
          
            e.printStackTrace();
        }
    }
    
}
