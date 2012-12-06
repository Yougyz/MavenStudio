package org.neo4j.studio.service;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.studio.domain.RelationshipNature;
import org.neo4j.studio.domain.Structure;
import org.neo4j.studio.domain.Personne;
import org.neo4j.studio.domain.RelationshipNatureP;
import org.neo4j.studio.domain.TypeOf;
import org.neo4j.studio.repository.StructureRepository;
import org.neo4j.studio.repository.PersonneRepository;
import org.neo4j.studio.repository.TypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.node.Neo4jHelper;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;


/**
 * @author mh
 * @since 04.03.11
 */
@Service
public class DatabasePopulator {

    @Autowired TypeRepository typeRepository;
    @Autowired TypeRepository typeRepositoryP;
    @Autowired StructureRepository structureRepository;
    @Autowired PersonneRepository personneRepository;
    @Autowired Neo4jOperations template;
    

    
   @Transactional
    public void populateNode() {   
	   /*
            Structure structure = new Structure("Structure");
            structureRepository.save(structure);        
            TypeOf type1 = new TypeOf("Administrative");
            typeRepository.save(type1);
            type1.natureStructure(structure);
            typeRepository.save(type1);        
            
                   
            TypeOf type2 = new TypeOf("Fonctionnelle");
            typeRepository.save(type2);
            type2.natureStructure(structure);
            typeRepository.save(type2);  
            
                   
            TypeOf type3 = new TypeOf("Compentence");
            typeRepository.save(type3);
            type3.natureStructure(structure);
            typeRepository.save(type3); 
            
            Personne personne = new Personne("Personne");
            personneRepository.save(personne);  
             
            TypeOf type4 = new TypeOf("Physique");
            typeRepositoryP.save(type4);                      
            RelationshipNatureP r4 = typeRepositoryP.createRelationshipBetween(type4, personne, RelationshipNatureP.class, "NATURE");
            template.save(r4);
            
           
            TypeOf type5 = new TypeOf("Morale");
            typeRepositoryP.save(type5);  
            RelationshipNatureP r5 = typeRepositoryP.createRelationshipBetween(type5, personne, RelationshipNatureP.class, "NATURE");
            template.save(r5);
            
            
            TypeOf type6 = new TypeOf("Tiers");              
            typeRepositoryP.save(type6);    
            RelationshipNatureP r6 = typeRepositoryP.createRelationshipBetween(type6, personne, RelationshipNatureP.class, "NATURE");
            template.save(r6);  */ 
    }
    
   @Transactional
    public void populateRelation() {
	   
/*	   Personne personne = personneRepository.findByPropertyValue("name", "personne");
	   Structure structure = structureRepository.findByPropertyValue("libelle", "structure");
	   TypeOf type1 = typeRepository.findByPropertyValue("name", "Administrative");
	   TypeOf type2 = typeRepository.findByPropertyValue("name", "Fonctionnelle");
	   TypeOf type3 = typeRepository.findByPropertyValue("name", "Compentence");
	   TypeOf type4 = typeRepositoryP.findByPropertyValue("name", "Physique");
	   TypeOf type5 = typeRepositoryP.findByPropertyValue("name", "Morale");
	   TypeOf type6 = typeRepositoryP.findByPropertyValue("name", "Tiers");
   	   
	   System.out.println("Libelle de la structure : " + structure.getLibelle());
	   System.out.println("Libelle de la personne : " + personne.getName());
	   System.out.println("Libelle de la type : " + type1.getName());
	   System.out.println("Libelle de la type : " + type2.getName());
	   System.out.println("Libelle de la type : " + type3.getName());
	   System.out.println("Libelle de la type : " + type4.getName());
	   System.out.println("Libelle de la type : " + type5.getName());
*/
    }
   /* @Transactional
    public void cleanDb() {
        new Neo4jDatabaseCleaner(template).cleanDb();
    }*/
}
