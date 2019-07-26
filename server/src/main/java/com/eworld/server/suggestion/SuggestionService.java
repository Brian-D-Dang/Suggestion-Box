package com.eworld.server.suggestion;

import java.util.List;

public interface SuggestionService {
    boolean saveSuggestion(Suggestion suggestion);
    boolean updateSug(UpdateSuggestion updateSuggestion);
    List<DisplayedSuggestion> returnSuggestions();
}
