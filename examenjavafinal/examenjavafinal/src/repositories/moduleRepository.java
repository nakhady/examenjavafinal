package repositories;
import entities.module;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class moduleRepository extends Database{
    private final String SQL_SELECT_MODULE="select * from module";
    private final String SQL_INSERT_MODULE="INSERT INTO `module` (`nom`) VALUES (?);";

    public List <module> selectAll(){
        List <module> Modules= new ArrayList<>();
        try{
            ouvrirConnexion();
            initPrepareStatement(SQL_SELECT_MODULE);
            ResultSet rs= executeSelect();
            while(rs.next()){
                module Module=new module();
                Module.setId(rs.getInt("id"));
                Module.setNomModule(rs.getString("nom"));

                Modules.add(Module);
            }
            rs.close();
            closeConnexion();
        }
        catch(SQLException e){
            System.out.println("Erreur de connexion a la BD");
        }
        return Modules;

    }
    private void closeConnexion() {
    }
    public void insertModule(module Module){
        try {
             ouvrirConnexion();
             initPrepareStatement(SQL_INSERT_MODULE);
            statement.setString(1,Module.getNomModule());
             executeUpdate();
        } catch (SQLException e) {
          
            e.printStackTrace();
        }
    }
    
}