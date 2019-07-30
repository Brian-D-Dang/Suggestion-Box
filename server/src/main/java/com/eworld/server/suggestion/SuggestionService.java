package com.eworld.server.suggestion;

import com.eworld.server.exception.suggestionExceptions;
import java.util.List;

public interface SuggestionService {
    boolean saveSuggestion(Suggestion suggestion);
    boolean updateSug(Suggestion updateSuggestion) throws suggestionExceptions;
    List<DisplayedSuggestion> returnSuggestions();
}
