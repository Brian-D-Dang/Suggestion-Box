package com.eworld.server;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/SuggestionForm")
public class SuggestionController {
    @Autowired
    private SuggestionServiceImpl suggestionServiceImpl;

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "addSuggestion", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean addSuggestion(@RequestBody Suggestion suggestion) {
        return suggestionServiceImpl.saveSuggestion(suggestion);
    }
}
