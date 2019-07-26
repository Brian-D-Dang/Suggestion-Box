package com.eworld.server.suggestion;

import com.eworld.server.user.UserAccountEntity;
import com.eworld.server.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class SuggestionServiceImpl implements SuggestionService {
    @Autowired
    private SuggestionRepository suggestionRepository;

    @Autowired
    private UserRepository userRepository;

    public SuggestionServiceImpl() {
    }

    @Override
    public boolean updateSug(UpdateSuggestion updateSuggestion) {
        Iterable<SuggestionEntity> suggestionEntities = suggestionRepository.findAll();
        Iterator<SuggestionEntity> iterator = suggestionEntities.iterator();
        SuggestionEntity suggestionEntity = suggestionRepository.getSuggestionEntityBySuggestionId(updateSuggestion.getSuggestionId());
        while (iterator.hasNext()) {
            SuggestionEntity updatingSuggestion = iterator.next();
            System.out.println(suggestionEntity.getSuggestionId());
            if (suggestionEntity.getSuggestionId() == updatingSuggestion.getSuggestionId()) {
                System.out.println(suggestionEntity.getUserAccountId());
                Date todayDate = new Date();
                updatingSuggestion.setCategory(updateSuggestion.getCategory());
                updatingSuggestion.setSubject(updateSuggestion.getSubject());
                updatingSuggestion.setSuggestion(updateSuggestion.getSuggestion());
                updatingSuggestion.setDate(todayDate);
                suggestionEntity = suggestionRepository.save(updatingSuggestion);
            }
        }
        return suggestionEntity != null;
    }



    @Override
    public List<DisplayedSuggestion> returnSuggestions() {
        Iterable<SuggestionEntity> suggestions = suggestionRepository.findAll();
        Iterator<SuggestionEntity> iterator = suggestions.iterator();
        List<DisplayedSuggestion> showSuggestionData = new ArrayList<>();
        while (iterator.hasNext()) {
            String pattern = "MM-dd-yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            SuggestionEntity nextElement = iterator.next();
            DisplayedSuggestion suggestionData = new DisplayedSuggestion();
            suggestionData.setCategory(nextElement.getCategory());
            suggestionData.setSubject(nextElement.getSubject());
            suggestionData.setSuggestion(nextElement.getSuggestion());
            suggestionData.setDate(simpleDateFormat.format(nextElement.getDate()));
            suggestionData.setSuggestionId(nextElement.getSuggestionId());
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
