package com.eworld.server.repository;

import com.eworld.server.entity.SuggestionEntity;
import com.eworld.server.entity.SuggestionEntity;
import org.springframework.data.repository.CrudRepository;

public interface SuggestionRepository extends CrudRepository<SuggestionEntity, Integer> {
//    SuggestionEntity setSuggestion(String category, String subject, String description, String date);
//    Article savedArticle = SuggestionRepository.save(setSuggestion);
    SuggestionEntity suggestion = new SuggestionEntity("Brian doodoo", hello);
    suggestion = repo.save(suggestion);
}
