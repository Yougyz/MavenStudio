package org.neo4j.studio.domain;
import org.neo4j.graphdb.Direction;
import org.neo4j.helpers.collection.IteratorUtil;
import org.springframework.data.neo4j.annotation.*;
import org.springframework.data.neo4j.template.Neo4jOperations;

import java.util.Collection;
import java.util.Set;

@NodeEntity
public class AttributMDM {
	@GraphId Long nodeId;
	
	@Indexed
	private String name;		

	private String typeatt;		
	
    public AttributMDM() {
    }

    public AttributMDM(String name) { 
        this.name = name;  
    }
    
    // getters
    public final String getName() {
        return name;
    }    
    public void setName(String name) {
        this.name = name;
    }	
    public final String getTypeatt() {
        return typeatt;
    }    
    public void setTypeatt(String typeatt) {
        this.typeatt = typeatt;
    }	
}
