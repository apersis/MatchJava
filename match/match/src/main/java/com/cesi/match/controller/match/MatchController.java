package com.cesi.match.controller.match;

import com.cesi.match.buisness.match.MatchBuisness;
import com.cesi.match.controller.match.model.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
public class MatchController {
    private final String versionRest = "/api/v1";
    private final MatchBuisness matchBuisness;
    @Autowired
    public MatchController(MatchBuisness matchBuisness){
        this.matchBuisness = matchBuisness;
    }
    @GetMapping(versionRest+"/matchs")
    public List<Match> readAllMatchRest(){
        return this.matchBuisness.readAllMatchBuisness();
    }
}
