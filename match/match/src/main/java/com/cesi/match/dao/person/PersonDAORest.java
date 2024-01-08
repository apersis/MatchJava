package com.cesi.match.dao.person;

import com.cesi.match.controller.person.model.NewPerson;
import com.cesi.match.controller.person.model.Person;
import com.cesi.match.dao.person.model.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PersonDAORest {


    private final RestTemplate restTemplate;

    @Autowired
    public PersonDAORest(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Person create(NewPerson person) {
        this.read(null,null);
        return new Person();
    }

    public boolean delete(int id) {
        ResponseEntity<Person[]> response;
        String url = "https://8080-cesi2022-spring3-zsh5qtnx8qn.ws-eu106.gitpod.io/api/v1/persons";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        response = restTemplate.exchange(url, HttpMethod.DELETE, entity, Person[].class);
        Person[] body = response.getBody();
        return true;
    }

    public Person update(int id, NewPerson person) {
        return new Person();
    }

    public Person read(int id){
        ResponseEntity<Person[]> response;
        String url = "https://8080-cesi2022-spring3-zsh5qtnx8qn.ws-eu106.gitpod.io/api/v1/persons";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        response = restTemplate.exchange(url, HttpMethod.GET, entity, Person[].class);
        Person[] body = response.getBody();

        Person person = new Person();

        for (int j =0; j<body.length;j++){
            if (body[j].getId()==id){
                person.setId(body[j].getId());
                person.setPrenom(body[j].getPrenom());
                person.setNom(body[j].getNom());
                person.setAge(body[j].getAge());
                return person;
            }
        }
        return new Person();
    }


    public List<Person> read(String nom, String prenom) {

        ResponseEntity<Person[]> response;
        String url = "https://8080-cesi2022-spring3-zsh5qtnx8qn.ws-eu106.gitpod.io/api/v1/bdd/persons";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        response = restTemplate.exchange(url, HttpMethod.GET, entity, Person[].class);
        Person[] body = response.getBody();

        if(nom != null && prenom==null){
            List<Person>listTri = new ArrayList<>();
            int taille = body.length;
            for (int i=0;i<taille;i++){
                if(body[i].getNom().equalsIgnoreCase(nom)){
                    Person resp = new Person();
                    resp.setId(body[i].getId());
                    resp.setNom(body[i].getNom());
                    resp.setPrenom(body[i].getPrenom());
                    resp.setAge(body[i].getAge());
                    listTri.add(resp);
                }
            }
            return listTri;
        }
        if(prenom != null && nom==null) {
            List<Person> listTri = new ArrayList<>();
            int taille = body.length;
            for (int i = 0; i < taille; i++) {
                if (body[i].getPrenom().equalsIgnoreCase(prenom)) {
                    Person resp = new Person();
                    resp.setId(body[i].getId());
                    resp.setNom(body[i].getNom());
                    resp.setPrenom(body[i].getPrenom());
                    resp.setAge(body[i].getAge());
                    listTri.add(resp);
                }
            }
            return listTri;
        }
        if(prenom != null && nom!=null){
            List<Person>listTri = new ArrayList<>();
            int taille = body.length;
            for (int i=0;i<taille;i++){
                if(body[i].getPrenom().equalsIgnoreCase(prenom) && body[i].getNom().equalsIgnoreCase(nom)){
                    Person resp = new Person();
                    resp.setId(body[i].getId());
                    resp.setNom(body[i].getNom());
                    resp.setPrenom(body[i].getPrenom());
                    resp.setAge(2023-body[i].getAge());
                    listTri.add(resp);
                }
            }
            return listTri;
        }
        return Arrays.asList(body);
    }

}
