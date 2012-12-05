package org.neo4j.studio.repository;




import org.neo4j.studio.domain.TypeOf;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.NamedIndexRepository;
import org.springframework.data.neo4j.repository.RelationshipOperationsRepository;

/**
 * @author mh
 * @since 02.04.11
 */
public interface TypeRepository extends GraphRepository<TypeOf>,
        RelationshipOperationsRepository<TypeOf>{

	TypeOf findByName(String name);
}
