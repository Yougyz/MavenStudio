package org.neo4j.studio.repository;




import org.neo4j.studio.domain.Structure;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.NamedIndexRepository;
import org.springframework.data.neo4j.repository.RelationshipOperationsRepository;

/**
 * @author mh
 * @since 02.04.11
 */
public interface StructureRepository extends GraphRepository<Structure>,
		NamedIndexRepository<Structure>,
        RelationshipOperationsRepository<Structure>{

	Structure findByLibelle(String libelle);
}
