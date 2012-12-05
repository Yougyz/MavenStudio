package org.neo4j.studio.controller;


import org.neo4j.studio.domain.Structure;
import org.neo4j.studio.service.DatabasePopulator;
import org.neo4j.helpers.collection.IteratorUtil;
import org.neo4j.studio.domain.*;
import org.neo4j.studio.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.transaction.annotation.Transactional;


import java.util.Collection;
import java.util.Collections;

import javax.jws.WebParam.Mode;


@Controller
public class PersonneController {
	
	@Autowired
	protected PersonneRepository personneRepository;
	   
	@Autowired
	protected StructureRepository structureRepository;
	   
	@Autowired
	protected TypeRepository typeRepository;
	
	@Autowired
	private Neo4jTemplate template;   
	
	@Autowired
	private DatabasePopulator populator;
	
    @RequestMapping( value = "/ajouterPersonne", method = RequestMethod.GET)
    public String addPersonne(Model model) {
    	Personne personne = personneRepository.save(new Personne("Ryo"));
    	model.addAttribute("variable", personne);
        return "personne/result";
    }
    
    @RequestMapping(value = "/createPersonne", method = RequestMethod.POST, headers = "Accept=text/html")
    public String createPersonne(Model model, @RequestParam(value = "name",required = false) String name) {
            String name1 = name!=null ? name.trim() : null;
            Personne personne = personneRepository.save(new Personne(name1));
            model.addAttribute("variable", personne);          	          	
        return "personne/result";


    }
    
    
    @RequestMapping(value = "/populate", headers = "Accept=text/html")
    public String createData(Model model) {
        String StructureLibelle = "Structure";
        String TypeStructure1 = "Administrative";
        String TypeStructure2 = "Fonctionnelle";
        
        //Création de l'element structure       
        Structure structure = structureRepository.save(new Structure(StructureLibelle));
        
        //Création des types        
        TypeOf type1 = typeRepository.save(new TypeOf(TypeStructure1));
        
        
        TypeOf type2 = typeRepository.save(new TypeOf(TypeStructure2));
        
        //Création des relations             
        //type1.natures (structure);               
        //type2.natures (structure);  
        
        //type1.natureOf(structure);
        
        //template.save(new RelationshipNature(type1, structure));
        //template.save(new RelationshipNature(type2, structure));
        // sauvegarde des liens       
        //template.save(type1);                
        //template.save(type2);            	
    	
        //Personne personne = personneRepository.save(new Personne(name1));
            //model.addAttribute("variable", personne);          	          	
        return "personne/result";


    }
    
    @RequestMapping(value = "/populateStructure", method = RequestMethod.GET)
    public String populateStructure(Model model) {                   
        populator.populateNode();
        //populator.populateRelation();
        return "personne/result";
    }
    /*@RequestMapping(value = "/populatePersonne", method = RequestMethod.GET)
    public String populatePersonne(Model model) {            
        populator.populatePersonne();
        return "personne/result";
    }*/
    
}
