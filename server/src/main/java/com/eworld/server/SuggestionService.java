package com.eworld.server;

import com.eworld.server.entity.SuggestionEntity;

import java.util.Date;

public interface SuggestionService {
    boolean saveSuggestion(Suggestion suggestion);
    String returnSuggestions(SuggestionEntity suggestionEntity);
}
