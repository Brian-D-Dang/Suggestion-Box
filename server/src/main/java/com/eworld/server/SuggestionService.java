package com.eworld.server;

import com.eworld.server.entity.SuggestionEntity;

import java.util.Date;
import java.util.List;

public interface SuggestionService {
    boolean saveSuggestion(Suggestion suggestion);
    List<DisplayedSuggestion> returnSuggestions();
}
