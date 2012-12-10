package org.neo4j.studio.service;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.studio.domain.Category;
import org.neo4j.studio.domain.RelationshipNature;
import org.neo4j.studio.domain.RelationshipTyped;
import org.neo4j.studio.domain.Structure;
import org.neo4j.studio.domain.Personne;
import org.neo4j.studio.domain.RelationshipNatureP;
import org.neo4j.studio.domain.TypeOf;
import org.neo4j.studio.repository.CategoryRepository;
import org.neo4j.studio.repository.TypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
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
public class CategoryService {

    @Autowired CategoryRepository categoryRepository;
    @Autowired TypeRepository typeRepository;
    @Autowired Neo4jOperations template; 

    
   @Transactional
    public Category addCategoryTyped(String nameCat, String nametype) {   
       
	    //Creation de la categorie
	   String nameCategory = nameCat!=null ? nameCat.trim() : null;
       Category category = new Category(nameCategory);
       categoryRepository.save(category);   
       
       //Recherche du noeud type
       String nameTyped = nametype!=null ? nametype.trim() : null;            
       TypeOf typeOf = typeRepository.findByName(nameTyped);                      
       
       // creation de la relation typed
       RelationshipTyped rTyped = categoryRepository.createRelationshipBetween(category, typeOf, RelationshipTyped.class, "TYPED");
       template.save(rTyped); 
       return category;
    }
   
}
