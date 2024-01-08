package com.cesi.match.buisness.match;

import com.cesi.match.controller.match.model.Match;
import com.cesi.match.controller.meet.model.Meet;
import com.cesi.match.controller.person.model.Person;
import com.cesi.match.dao.meet.MeetDAO;
import com.cesi.match.dao.person.PersonDAO;
import com.cesi.match.dao.person.PersonDAORest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchBuisness {
    private final MeetDAO meetDAO;
    private final PersonDAORest personDAORest;
    @Autowired
    public MatchBuisness(MeetDAO meetDAO, PersonDAORest personDAORest){
        this.meetDAO = meetDAO;
        this.personDAORest = personDAORest;
    }
    public List<Match> readAllMatchBuisness(){


        List<Meet> listMeet = meetDAO.read();
        List<Person> listPerson = personDAORest.read(null,null);
        List<Match> listMatch = new ArrayList<Match>();
        for (Meet meet : listMeet){
            Match match = new Match();
            int idVainqueur = meet.getIdGagnant();
            int idPerdant = meet.getIdPerdant();
            String lieu = meet.getLieu();
            int annee = meet.getAnnee();
            match.setTournoi(lieu + " " + String.valueOf(annee));
            for (Person person : listPerson){
                if (person.getId()==idVainqueur){
                    match.setVainqueur(person.getPrenom() + " " + person.getNom());
                }if (person.getId()==idPerdant){
                    match.setPerdant(person.getPrenom() + " " + person.getNom());
                }
            }
            listMatch.add(match);
        }
        return listMatch;
    }
}
