package com.cesi.match.buisness.person;

import com.cesi.match.controller.person.model.NewPerson;
import com.cesi.match.controller.person.model.Person;
import com.cesi.match.dao.person.PersonDAO;
import com.cesi.match.dao.person.PersonDAORest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonBuisness {
    private final PersonDAO personDAO;
    private final PersonDAORest personDAORest;
    @Autowired
    public PersonBuisness(PersonDAO personDAO, PersonDAORest personDAORest){
        this.personDAO = personDAO;
        this.personDAORest = personDAORest;
    }
    public Person createPersonBuisness(NewPerson person, boolean rest){
        if (!rest){
            return personDAO.create(person);
        }else{
            return personDAORest.create(person);
        }
    }

    public Person readPersonBuisness(int id, boolean rest) {
        if (!rest) {
            return personDAO.read(id);
        }else{
            return personDAORest.read(id);
        }
    }
    public List<Person> readAllPersonBuisness(String nom, String prenom, boolean rest){
        if (!rest) {
            return personDAO.read(nom, prenom);
        }else{
            return personDAORest.read(nom, prenom);
        }
    }
    public Person updatePersonBuisness(int id, NewPerson newPerson){
        return personDAO.update(id,newPerson);
    }
    public boolean deletePersonBuisness(int id,boolean rest) {
        if (!rest) {
            return personDAO.delete(id);
        }else{
            return personDAORest.delete(id);
        }
    }
}
