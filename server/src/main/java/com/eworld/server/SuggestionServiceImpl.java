package com.eworld.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eworld.server.repository.SuggestionRepository;

@Service
public class SuggestionServiceImpl implements SuggestionService {
    @Autowired
    private SuggestionRepository suggestionRepository;

}
