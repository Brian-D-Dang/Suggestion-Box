package com.eworld.server.suggestion;

import com.eworld.server.suggestion.SuggestionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuggestionRepository extends CrudRepository<SuggestionEntity, Integer> {

}
