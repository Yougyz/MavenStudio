package org.neo4j.studio.domain;
import org.neo4j.graphdb.Direction;
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
	
	@RelatedToVia(type="NATURE",direction=Direction.OUTGOING)
	private Set<RelationshipNature> relationshipsNature;
	 
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
	/* public void natures(Structure s) {
		  nature.add(new RelationshipNature(this, s));
	  }  */
	
	public Iterable<RelationshipNature> getMemberships() { return relationshipsNature; }
	
	public RelationshipNature natureOf(Structure structure) {
		RelationshipNature nature = new RelationshipNature(this, structure);	
		relationshipsNature.add(nature);	
		return nature;	
	}	
	
    @Override
    public int hashCode() {
        return nodeId != null ? nodeId.hashCode() : super.hashCode();
    }	
}
