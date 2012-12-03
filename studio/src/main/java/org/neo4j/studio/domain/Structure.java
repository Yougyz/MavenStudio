package org.neo4j.studio.domain;
import org.neo4j.graphdb.Direction;
import org.neo4j.helpers.collection.IteratorUtil;
import org.springframework.data.neo4j.annotation.*;
import org.springframework.data.neo4j.template.Neo4jOperations;

import java.util.Collection;
import java.util.Set;

@NodeEntity
public class Structure {
	@GraphId Long nodeId;
	
	@Indexed(indexName = "structure")
	private String libelle;
	
    public Structure() {
    }

    public Structure(String libelle) { 
        this.libelle = libelle;  
    }
// getters
    public final String getLibelle() {
        return libelle;
    }    
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

	public long getId() {		
		return nodeId;
	} 
    
    @Override
    public int hashCode() {
        return nodeId != null ? nodeId.hashCode() : super.hashCode();
    }	
}
