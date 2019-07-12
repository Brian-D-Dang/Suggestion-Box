package com.eworld.server;

import com.eworld.server.entity.SuggestionEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@RestController
@RequestMapping("/SuggestionForm")
public class SuggestionController {
    @Autowired
    private SuggestionServiceImpl suggestionServiceImpl;

    @RequestMapping(value = "/getSuggestions", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DisplayedSuggestion> getSuggestions() {
        return suggestionServiceImpl.returnSuggestions();
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "addSuggestion", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean addSuggestion(@RequestBody Suggestion suggestion) {
        return suggestionServiceImpl.saveSuggestion(suggestion);
    }
}
