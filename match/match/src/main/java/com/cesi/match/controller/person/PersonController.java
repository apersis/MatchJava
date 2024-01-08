package com.cesi.match.controller.person;

import com.cesi.match.buisness.person.PersonBuisness;
import com.cesi.match.controller.person.model.NewPerson;
import com.cesi.match.controller.person.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.cesi.match.controller.exception.*;

import java.util.List;

@RestController
@Validated
public class PersonController {
    private final String version = "bdd/api/v1";
    private final String versionRest = "rest/api/v1";
    private final PersonBuisness personBuisness;
    @Autowired
    public PersonController(PersonBuisness personBuisness){
        this.personBuisness = personBuisness;
    }
    @PostMapping(version+"/persons")
    public Person createPerson(@RequestBody NewPerson person){
        return personBuisness.createPersonBuisness(person,false);
    }
    @PostMapping(versionRest+"/persons")
    public Person createPersonRest(@RequestBody NewPerson person){
        return personBuisness.createPersonBuisness(person,true);
    }
    @GetMapping(version+"/persons/{id}")
    public Person readPerson(@PathVariable int id){
        return personBuisness.readPersonBuisness(id,false);
    }
    @GetMapping(versionRest+"/persons/{id}")
    public Person readPersonRest(@PathVariable int id){
        return personBuisness.readPersonBuisness(id,true);
    }
    @GetMapping(version+"/persons/all")
    public List<Person> readAllPerson(@RequestParam(value = "nom",required = false) String nom,
                                      @RequestParam(value = "prenom",required = false) String prenom){
        return personBuisness.readAllPersonBuisness(nom, prenom,false);
    }
    @GetMapping(versionRest+"/persons/all")
    public List<Person> readAllPersonRest(@RequestParam(value = "nom",required = false) String nom,
                                      @RequestParam(value = "prenom",required = false) String prenom){
        List<Person> personList = personBuisness.readAllPersonBuisness(nom, prenom,true);
        if (personList == null || personList.isEmpty()) {
            throw new RessourceIntrouvableException("Le produit recherché n'existe pas");
        }
        return personList;
    }
    @PutMapping(version+"/persons/{id}")
    public Person updatePerson(@PathVariable int id,@RequestBody NewPerson newPerson){
        return personBuisness.updatePersonBuisness(id,newPerson);
    }
    @DeleteMapping(version+"/persons/{id}")
    public boolean deletePerson(@PathVariable int id){
        return personBuisness.deletePersonBuisness(id,false);
    }
    @DeleteMapping(versionRest+"/persons/{id}")
    public boolean deletePersonRest(@PathVariable int id){
        return personBuisness.deletePersonBuisness(id,true);
    }
}
