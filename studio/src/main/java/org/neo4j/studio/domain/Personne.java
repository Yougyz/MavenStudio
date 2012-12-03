package org.neo4j.studio.domain;
import org.neo4j.graphdb.Direction;
import org.neo4j.helpers.collection.IteratorUtil;
import org.springframework.data.neo4j.annotation.*;
import org.springframework.data.neo4j.support.index.IndexType;
import org.springframework.data.neo4j.template.Neo4jOperations;

import java.util.Collection;
import java.util.Set;

@NodeEntity
public class Personne {
	@GraphId Long nodeId;
	
	@Indexed(indexName = "personne")
	private String name;
	
    public Personne() {
    }

    public Personne(String name) { 
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

    
    @Override
    public int hashCode() {
        return nodeId != null ? nodeId.hashCode() : super.hashCode();
    }
}
