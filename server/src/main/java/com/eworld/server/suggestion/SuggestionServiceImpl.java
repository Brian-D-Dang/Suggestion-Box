package com.eworld.server.suggestion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class SuggestionServiceImpl implements SuggestionService {
    @Autowired
    private SuggestionRepository suggestionRepository;

    public SuggestionServiceImpl() {
    }

    @Override
    public boolean updateSug(UpdateSuggestion updateSuggestion) {
        // This function was made to update the users suggestion
        SuggestionEntity suggestionEntity = suggestionRepository.getSuggestionEntityBySuggestionId(updateSuggestion.getSuggestionId());
        // This line of code classifies which suggestion the user was refering to
        if ((updateSuggestion.getUserAccountId() == suggestionEntity.getUserAccountId())&&(updateSuggestion.getSuggestionId() == suggestionEntity.getSuggestionId())) {
            // This if statement double checks if the correct suggestion was called by comparing UserIds
                Date todayDate = new Date();
                suggestionEntity.setCategory(updateSuggestion.getCategory());
                suggestionEntity.setSubject(updateSuggestion.getSubject());
                suggestionEntity.setSuggestion(updateSuggestion.getSuggestion());
                suggestionEntity.setDate(todayDate);
                suggestionEntity = suggestionRepository.save(suggestionEntity);
                return suggestionEntity != null;
            }
            return false;
        // Returns false if the user does not have the correct suggestionid or the correct userAccountId
        }



    @Override
    public List<DisplayedSuggestion> returnSuggestions() {
        Iterable<SuggestionEntity> suggestions = suggestionRepository.findAll();
        Iterator<SuggestionEntity> iterator = suggestions.iterator();
        List<DisplayedSuggestion> showSuggestionData = new ArrayList<>();
        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        while (iterator.hasNext()) {
            SuggestionEntity nextElement = iterator.next();
            DisplayedSuggestion suggestionData = new DisplayedSuggestion();
            suggestionData.setCategory(nextElement.getCategory());
            suggestionData.setSubject(nextElement.getSubject());
            suggestionData.setSuggestion(nextElement.getSuggestion());
            suggestionData.setDate(simpleDateFormat.format(nextElement.getDate()));
            suggestionData.setSuggestionId(nextElement.getSuggestionId());
            suggestionData.setUserAccountId(nextElement.getUserAccountId());
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
