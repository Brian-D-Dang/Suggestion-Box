package com.eworld.server.suggestion;

import com.eworld.server.exception.suggestionExceptions;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@RestController
@RequestMapping("/SuggestionForm")
public class SuggestionController {
    @Autowired
    private SuggestionServiceImpl suggestionServiceImpl;

    @RequestMapping(method = RequestMethod.PUT, value = "/updateSuggestion", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean updateSuggestion(@RequestBody Suggestion updateSuggestion) throws suggestionExceptions {
        return suggestionServiceImpl.updateSug(updateSuggestion);
    }

    @RequestMapping(value = "/getSuggestions", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DisplayedSuggestion> getSuggestions() {
        return suggestionServiceImpl.returnSuggestions();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addSuggestion", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean addSuggestion(@RequestBody Suggestion suggestion) {
        return suggestionServiceImpl.saveSuggestion(suggestion);
    }
}
