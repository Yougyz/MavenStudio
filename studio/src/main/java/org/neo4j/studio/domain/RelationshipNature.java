package org.neo4j.studio.domain;
import org.neo4j.graphdb.Direction;
import org.neo4j.helpers.collection.IteratorUtil;
import org.springframework.data.neo4j.annotation.*;
import org.springframework.data.neo4j.template.Neo4jOperations;

import java.util.Collection;
import java.util.Set;

@RelationshipEntity(type = "NATURE")
public class RelationshipNature {
	@GraphId Long nodeId;
	
    @StartNode
    private TypeOf startNode;

    @EndNode
    private Structure endNode;
	
    public RelationshipNature() {
    }

    public RelationshipNature(TypeOf startNode, Structure endNode) { 
        this.startNode = startNode;
        this.endNode = endNode;
    }
// getters
    public final TypeOf getStartNode() {
        return startNode;
    }

    public final Structure getEndNode() {
        return endNode;
    }

	public long getId() {		
		return nodeId;
	}
    
    @Override
    public int hashCode() {
        return nodeId != null ? nodeId.hashCode() : super.hashCode();
    }	
}
