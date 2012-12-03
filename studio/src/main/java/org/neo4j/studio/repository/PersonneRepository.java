package org.neo4j.studio.repository;




import org.neo4j.studio.domain.Personne;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.NamedIndexRepository;
import org.springframework.data.neo4j.repository.RelationshipOperationsRepository;

/**
 * @author mh
 * @since 02.04.11
 */
public interface PersonneRepository extends GraphRepository<Personne>,
		NamedIndexRepository<Personne>,
        RelationshipOperationsRepository<Personne>{

    Personne findByName(String name);
}
