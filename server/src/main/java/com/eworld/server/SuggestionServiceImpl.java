package com.eworld.server;

import com.eworld.server.entity.SuggestionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eworld.server.repository.SuggestionRepository;

import java.util.*;

@Service
public class SuggestionServiceImpl implements SuggestionService {
    @Autowired
    private SuggestionRepository suggestionRepository;
    private Suggestion suggestion;
    public SuggestionServiceImpl() {

    }

    @Override
    public List<DisplayedSuggestion> returnSuggestions() {
        Iterable<SuggestionEntity> suggestions = suggestionRepository.findAll();
        Iterator<SuggestionEntity> iterator = suggestions.iterator();
        List<DisplayedSuggestion> showSuggestionData = new ArrayList<>();
        while (iterator.hasNext()) {
            SuggestionEntity nextElement = iterator.next();
            DisplayedSuggestion suggestionData = new DisplayedSuggestion();
            suggestionData.setCategory(nextElement.getCategory());
            suggestionData.setSubject(nextElement.getSubject());
            suggestionData.setSuggestion(nextElement.getSuggestion());
            showSuggestionData.add(suggestionData);
        }
        return showSuggestionData;
    }

    @Override
    public boolean saveSuggestion(Suggestion suggestion) {
        Date todayDate = new Date();
        SuggestionEntity suggestionEntity = new SuggestionEntity(suggestion.getCategory(), suggestion.getSubject(), suggestion.getSuggestion(), todayDate, suggestion.getUserAccountId());
        suggestionEntity = suggestionRepository.save(suggestionEntity);
        return suggestionEntity != null;
    }
}
