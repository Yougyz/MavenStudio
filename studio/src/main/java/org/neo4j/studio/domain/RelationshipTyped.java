package org.neo4j.studio.domain;
import org.neo4j.graphdb.Direction;
import org.neo4j.helpers.collection.IteratorUtil;
import org.springframework.data.neo4j.annotation.*;
import org.springframework.data.neo4j.template.Neo4jOperations;

import java.util.Collection;
import java.util.Set;

@RelationshipEntity(type = "TYPED")
public class RelationshipTyped {
	@GraphId Long nodeId;
	// Cette relation sert à typer les catégories ou modèles de donnée
    @StartNode
    private Category startNode;

    @EndNode
    private TypeOf endNode;  

    
	@Indexed(indexName = "nameRelation")
	private String name;
    
    public RelationshipTyped() {
    }

    public RelationshipTyped(Category startNode, TypeOf endNode, String name) { 
        this.startNode = startNode;
        this.endNode = endNode;
        this.name = name;
    }

// getters
    public final Category getStartNode() {
        return startNode;
    }
    public final String getName() {
    	return name;
    }

    public final TypeOf getEndNode() {
        return endNode;
    }
    
    public void setEndNode(TypeOf endNode) {
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
