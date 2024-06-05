import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import entities.module;
import entities.professeur;
import services.coursService;
import services.moduleService;
import services.professeurService;

public class App {
    public static void main(String[] args) throws Exception {
        moduleService ModuleService=new moduleService();
        coursService CoursService=new coursService();
        professeurService ProfesseurService=new professeurService(); 
        int choix;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("1-Ajouter un Module");
            System.out.println("2-Lister les Modules");
            System.out.println("3-Créer un cours");
            System.out.println("4-Lister tous les cours ");
            System.out.println("5-Lister les  les cours  d’un module et d’un professeur");
            System.out.println("6-Quitter");
            choix=sc.nextInt();
            sc.nextLine();
            switch (choix) {
                case 1:
                System.out.println("Entrer le nom du module:");
                String nomModule = sc.nextLine();
                module Mod = new module();
                Mod.setNomModule(nomModule);
                ModuleService.ajouterModule(Mod);
                System.out.println("Module ajoutée avec succès");

                    break;
            
                case 2:
                List<module> listerModule=ModuleService.ListerModule();
                for(module md: listerModule){
                    System.out.println("id: "+md.getId());
                    System.out.println("nomModule: "+md.getNomModule());
                    System.out.println("----------------------------------");
                    
                }
                    
                    break;
                  

                case 3:
                System.out.println("Entrer le nom du professeur:");
                String nom = sc.nextLine();
                System.out.println("Entrer le prénom du professeur:");
                String prenom = sc.nextLine();
                System.out.println("Entrer le numéro de telephone du professeur:");
                int tel = sc.nextInt();
                professeur prof = new professeur();
                prof.setNom(nom);
                prof.setPrenom(prenom);
                prof.setTel(tel);
                ProfesseurService.ajouterProfesseur(prof);
                System.out.println("Professeur ajoutée avec succès");



                System.out.println("Entrer la date du cours:");
                LocalDate date = LocalDate.parse(sc.nextLine());
                System.out.println("Entrer l'heure de début du cours:");
                LocalTime heureDb = LocalTime.parse(sc.nextLine());
                System.out.println("Entrer l'heure de fin du cours:");
                LocalTime heureFin = LocalTime.parse(sc.nextLine());

                
                    break;
                
                case 4:

                    break;

                case 5:
                     
                    break;
            
                
    

                
          
            }
        } while(choix !=6);
}
}
    
