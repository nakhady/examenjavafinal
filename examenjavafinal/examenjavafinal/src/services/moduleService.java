package services;

import java.util.List;

import entities.module;
import repositories.moduleRepository;

public class moduleService {
    moduleRepository ModuleRepository=new moduleRepository();

    public void ajouterModule(module Module){
        ModuleRepository.insertModule(Module);
    }

    public List<module>ListerModule(){
        return ModuleRepository.selectAll();
    }
    
}
