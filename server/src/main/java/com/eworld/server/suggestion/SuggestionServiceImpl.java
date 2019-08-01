package com.eworld.server.suggestion;

import com.eworld.server.exception.SuggestionExceptions;
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

    // This function was made to update the users suggestion
    @Override
    public boolean updateSuggestion(Suggestion updateSuggestion) throws SuggestionExceptions {
        // This line of code classifies which suggestion the user was refering to
        SuggestionEntity suggestionEntity = suggestionRepository.getSuggestionEntityBySuggestionId(updateSuggestion.getSuggestionId());
        // This if statement double checks if the correct suggestion was called by comparing UserIds
        if (suggestionEntity != null) {
                Date todayDate = new Date();
                suggestionEntity.setCategory(updateSuggestion.getCategory());
                suggestionEntity.setSubject(updateSuggestion.getSubject());
                suggestionEntity.setSuggestion(updateSuggestion.getSuggestion());
                suggestionEntity.setCreatedDate(todayDate);
                suggestionEntity = suggestionRepository.save(suggestionEntity);
                return suggestionEntity != null;
            }
        // Returns false if the user does not have the correct suggestionid or the correct userAccountId
            throw new SuggestionExceptions("Suggestion edit did not send properly");

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
            suggestionData.setDate(simpleDateFormat.format(nextElement.getCreatedDate()));
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
