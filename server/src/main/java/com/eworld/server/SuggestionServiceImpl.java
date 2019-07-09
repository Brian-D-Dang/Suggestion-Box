package com.eworld.server;

import com.eworld.server.entity.SuggestionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eworld.server.repository.SuggestionRepository;

import java.util.Date;

@Service
public class SuggestionServiceImpl implements SuggestionService {
    @Autowired
    private SuggestionRepository suggestionRepository;

    public SuggestionServiceImpl() {

    }

    @Override
    public boolean setSuggestion(String category, String subject, String suggestion, Date date, int userAccountId) {
        SuggestionEntity suggestionEntity = new SuggestionEntity(category, subject, suggestion, date, userAccountId);
        suggestionEntity = suggestionRepository.save(suggestionEntity);
        return suggestionEntity != null;
    }
}
