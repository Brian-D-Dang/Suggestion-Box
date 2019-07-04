package com.eworld.server;

public interface SuggestionService {
    boolean setSuggestion(String category, String subject, String description, String date);
}
