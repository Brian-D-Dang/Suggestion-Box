package com.eworld.server;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequestMapping("/SuggestionForm")
public class SuggestionController {
    @Autowired
    private SuggestionServiceImpl suggestionServiceImpl;

    @RequestMapping(value = "/saveSurvey", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean savingTheSurvey(@RequestParam(value="category") String category, @RequestParam(value="subject") String subject, @RequestParam(value="suggestion") String suggestion, @RequestParam(value="date") Date date, @RequestParam(value="userAccountId") int userAccountId) {
        return suggestionServiceImpl.setSuggestion(category, subject, suggestion, date, userAccountId);
    }
}
