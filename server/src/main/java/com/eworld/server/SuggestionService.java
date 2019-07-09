package com.eworld.server;

import java.time.LocalDateTime;
import java.util.Date;

public interface SuggestionService {
    boolean setSuggestion(String category, String subject, String description, Date date, int userAccountId);
}
