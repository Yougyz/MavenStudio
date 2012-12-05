package org.neo4j.studio.domain;
import org.neo4j.studio.domain.RelationshipNature;
import org.neo4j.studio.domain.Structure;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.helpers.collection.IteratorUtil;
import org.springframework.data.neo4j.annotation.*;
import org.springframework.data.neo4j.template.Neo4jOperations;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class TypeOf {
	@GraphId Long nodeId;
	
	@Indexed(indexName = "typeOf")
	private String name;
	
    /*@RelatedTo
    Collection<RelationshipNature> relationshipNatures;*/
    
    @RelatedTo(elementClass = Structure.class, type = "NATURE")
    private Set<Structure> structures=new HashSet<Structure>(); 
    
    @RelatedTo(elementClass = Personne.class, type = "NATURE")
    private Set<Personne> personnes=new HashSet<Personne>();    

	 
    public TypeOf() {
    }

    public TypeOf(String name) { 
        this.name = name;  
    }
// getters
    public final String getName() {
        return name;
    }    
    public void setName(String name) {
        this.name = name;
    }

	public long getId() {		
		return nodeId;
	} 

 /*   public Iterable<RelationshipNature> getRelationshipNatures() {
        return relationshipNatures;
    }
    public Iterable<RelationshipNatureP> getRelationshipNaturesP() {
    	return relationshipNaturesp;
    }

    public RelationshipNature natureStructure(Structure structure, String Name) {
        final RelationshipNature nature = new RelationshipNature(this, structure, Name);
        relationshipNatures.add(nature);
        return nature;
    }
   public RelationshipNatureP naturePersonne(Personne personne, String Name) {
        final RelationshipNatureP natureP = new RelationshipNatureP(this, personne, Name);
        relationshipNaturesp.add(natureP);
        return natureP;
    }*/
	
    public Set<Structure> getStructures() {
        return structures;
    }

    public void natureStructure(Structure structure) {
        this.structures.add(structure);
    }
    public Set<Personne> getPersonnes() {
    	return personnes;
    }
    
    public void naturePersonne(Personne personne) {
    	this.personnes.add(personne);
    }
	
    @Override
    public int hashCode() {
        return nodeId != null ? nodeId.hashCode() : super.hashCode();
    }	
}
