package services;

import java.util.List;

import entities.cours;
import repositories.coursRepository;

public class coursService {
    coursRepository CoursRepository=new coursRepository();

    public void ajouterCours(cours Cours){
        CoursRepository.insertCours(Cours);
    }

    public List<cours>ListerCours(){
        return CoursRepository.selectAll();
    }
    
}
