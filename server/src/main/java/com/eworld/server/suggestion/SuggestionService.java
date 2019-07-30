package com.eworld.server.suggestion;

import com.eworld.server.exception.SuggestionExceptions;
import java.util.List;

public interface SuggestionService {
    boolean saveSuggestion(Suggestion suggestion);
    boolean updateSug(Suggestion updateSuggestion) throws SuggestionExceptions;
    List<DisplayedSuggestion> returnSuggestions();
}
