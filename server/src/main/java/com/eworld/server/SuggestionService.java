package com.eworld.server;

import java.util.Date;

public interface SuggestionService {
    boolean setSuggestion(String category, String subject, String description, int userAccountId);
}
