package com.eworld.server.repository;

import com.eworld.server.SuggestionServiceImpl;
import com.eworld.server.entity.SuggestionEntity;
import com.eworld.server.entity.SuggestionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuggestionRepository extends CrudRepository<SuggestionEntity, Integer> {

}
