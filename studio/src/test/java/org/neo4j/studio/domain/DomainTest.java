package org.neo4j.studio.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.neo4j.studio.repository.PersonneRepository;
import org.neo4j.studio.repository.TypeRepository;
import org.neo4j.studio.repository.StructureRepository;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.data.neo4j.support.node.Neo4jHelper;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * @author mh
 * @since 04.03.11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/personne-test-context.xml"})
@Transactional
public class DomainTest {
	
   @Autowired
   protected PersonneRepository personneRepository;
   
   @Autowired
   protected StructureRepository structureRepository;
   
   @Autowired
   protected TypeRepository typeRepository;
   
   @Autowired
   private Neo4jTemplate template;
   @Rollback(false)
   @BeforeTransaction
   public void clearDatabase() {
       Neo4jHelper.cleanDb(template);
   }
   
  /* @Test
   @Transactional
   public void testPersistPersonne() {	   
       Personne ryo = template.save(new Personne("Iori"));
       Personne takuma = template.save(new Personne("takuma"));
       Personne ryu = template.save(new Personne("ryu"));
       Personne moi = template.save(new Personne("moi"));
       System.out.println("ID " + ryo.getId());       
       Personne retrieveRyo1 = template.findOne(ryo.getId(), Personne.class);
       Personne retrieveRyo2 = template.findOne(takuma.getId(), Personne.class);
       //assertEquals(ryo.name, retrieveRyo.name);
       System.out.println("Name : " + retrieveRyo1.getName());
       System.out.println("Name : " + retrieveRyo2.getName());       
   }*/
   

   @Test
   public void testIndex() {	   
       String name = "KYO";
       String name2 = "ryo";
       Personne ryo = personneRepository.save(new Personne(name));
       Personne ryo2 = personneRepository.save(new Personne(name2));
       System.out.println("ID" + ryo.getId());
       System.out.println("ID" + ryo2.getId());
       //GraphRepository<Personne> personneRepository = template.repositoryFor(Personne.class);
       Personne retrieveRyo = personneRepository.findByPropertyValue("name", name);
       System.out.println(retrieveRyo.getName());
       Personne retrieveRyo2 = personneRepository.findByPropertyValue("name", name2);
       System.out.println(retrieveRyo2.getName());
    
   }
   
   @Test
   public void testRelationshipNature() {	   
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
       
       // sauvegarde des liens
       type1.natureOf(structure);
       //RelationshipNature R2=template.save(new RelationshipNature(type2, structure));
       
       // ## recherche pour le test ##
       // recherche de structure
       Structure retrieveStructure = structureRepository.findByPropertyValue("libelle", "Structure");
       System.out.println("Libelle de la structure : " + retrieveStructure.getLibelle());
       
       // recherche des types
       TypeOf retrieveType1 = typeRepository.findByPropertyValue("name", "Administrative");
       System.out.println("Libelle du type 1 : " + retrieveType1.getName());
       TypeOf retrieveType2 = typeRepository.findByPropertyValue("name", "Fonctionnelle");
       System.out.println("Libelle du type 2 : " + retrieveType2.getName());           
   }
   
}
