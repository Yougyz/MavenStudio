package org.neo4j.studio.domain;
import org.neo4j.graphdb.Direction;
import org.neo4j.helpers.collection.IteratorUtil;
import org.springframework.data.neo4j.annotation.*;
import org.springframework.data.neo4j.template.Neo4jOperations;

import java.util.Collection;
import java.util.Set;

@NodeEntity
public class MetaDataCat {
	@GraphId Long nodeId;
	
	@Indexed
	private String name;
	
    public MetaDataCat() {
    }

    public MetaDataCat(String name) { 
        this.name = name;  
    }
// getters
    public final String getName() {
        return name;
    }    
	
}
