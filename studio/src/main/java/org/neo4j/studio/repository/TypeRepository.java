package org.neo4j.studio.repository;




import java.util.List;

import org.neo4j.studio.domain.TypeOf;
import org.springframework.data.domain.Page;
import org.springframework.data.neo4j.annotation.Query;
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
	
    @Query("start n=node:__types__(className='org.neo4j.studio.domain.Structure')" +
            " match n<-[r:NATURE]-typeOf " +
            " return typeOf " +
            " order by typeOf.name")
    List<TypeOf> findTypeOfStructure();
	
}
