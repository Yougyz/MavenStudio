package org.neo4j.studio.domain;
import org.neo4j.graphdb.Direction;
import org.neo4j.helpers.collection.IteratorUtil;
import org.springframework.data.neo4j.annotation.*;
import org.springframework.data.neo4j.template.Neo4jOperations;

import java.util.Collection;
import java.util.Set;

@NodeEntity
public class Category {
	
	@GraphId Long nodeId;
	
    @RelatedTo(type = "TYPED", elementClass = TypeOf.class, direction = Direction.OUTGOING)
    private TypeOf typeOf;
	
	@Indexed
	private String name;		
	
    public Category() {
    }

    public Category(String name) { 
        this.name = name;  
    }
// getters
    public final String getName() {
        return name;
    }    
    public void setName(String name) {
        this.name = name;
    }	
}
