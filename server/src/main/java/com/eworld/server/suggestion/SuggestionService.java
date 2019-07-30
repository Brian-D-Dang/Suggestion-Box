package com.eworld.server.suggestion;

import java.util.List;

public interface SuggestionService {
    boolean saveSuggestion(Suggestion suggestion);
    boolean updateSug(Suggestion updateSuggestion);
    List<DisplayedSuggestion> returnSuggestions();
}
