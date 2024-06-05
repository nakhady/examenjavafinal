package repositories;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.*;
import java.util.List;

import entities.cours;

public class coursRepository extends Database{

    private final String SQL_SELECT_COURS="select * from cours";
    private final String SQL_INSERT_COURS="INSERT INTO `cours` (`date`,`heureDb`, (heureFin)) VALUES (?,?);";

    public List <cours> selectAll(){
        List <cours> Courss= new ArrayList<>();
        try{
            ouvrirConnexion();
            initPrepareStatement(SQL_SELECT_COURS);
            ResultSet rs= executeSelect();
            while(rs.next()){
                cours Cours=new cours();
                Cours.setId(rs.getInt("id"));
                Cours.setDate(rs.getDate("date").toLocalDate());
                Cours.setHeureDb(rs.getTime("heureDb").toLocalTime());
                Cours.setHeureFin(rs.getTime("heureFin").toLocalTime());

                Courss.add(Cours);
            }
            rs.close();
            closeConnexion();
        }
        catch(SQLException e){
            System.out.println("Erreur de connexion a la BD");
        }
        return Courss;

    }
    
    private void closeConnexion() {
    }
    public void insertCours(cours Cours){
        try {
             ouvrirConnexion();
             initPrepareStatement(SQL_INSERT_COURS);
             statement.setDate(1, Date.valueOf(Cours.getDate()));
             statement.setTime(2, Time.valueOf(Cours.getHeureDb()));
             statement.setTime(3, Time.valueOf(Cours.getHeureFin()));
             executeUpdate();
        } catch (SQLException e) {
          
            e.printStackTrace();
        }
    }


    
    
}
