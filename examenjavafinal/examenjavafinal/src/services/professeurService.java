package services;

import entities.professeur;
import repositories.professeurRepository;

public class professeurService {
    professeurRepository ProfesseurRepository=new professeurRepository();

    public void ajouterProfesseur(professeur Professeur){
        ProfesseurRepository.insertProfesseur(Professeur);
    }
    
}
