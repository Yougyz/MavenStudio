package org.neo4j.studio.domain;
import org.neo4j.graphdb.Direction;
import org.neo4j.helpers.collection.IteratorUtil;
import org.springframework.data.neo4j.annotation.*;
import org.springframework.data.neo4j.template.Neo4jOperations;

import java.util.Collection;
import java.util.Set;

@RelationshipEntity(type = "NATURE")
public class RelationshipNatureP {
	@GraphId Long nodeId;
	
    @StartNode
    private TypeOf startNode;

    @EndNode
    private Personne endNode;    

	@Indexed(indexName = "nameRelationP")
	private String name;
    
    public RelationshipNatureP() {
    }

    public RelationshipNatureP(TypeOf startNode, Personne endNode, String name) { 
    	this.startNode = startNode;
    	this.endNode = endNode;
    	this.name = name;
    }
// getters
    public final TypeOf getStartNode() {
        return startNode;
    }
    public final String getName() {
    	return name;
    }

    public final Personne getEndNode() {
        return endNode;
    }
    public void setEndNode(Personne endNode) {
        this.endNode = endNode;
    }

    
	public long getId() {		
		return nodeId;
	}
    
    @Override
    public int hashCode() {
        return nodeId != null ? nodeId.hashCode() : super.hashCode();
    }	
}
