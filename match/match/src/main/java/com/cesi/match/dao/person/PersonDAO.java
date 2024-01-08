package com.cesi.match.dao.person;

import com.cesi.match.controller.person.model.NewPerson;
import com.cesi.match.controller.person.model.Person;
import com.cesi.match.dao.person.model.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
@Repository
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public PersonDAO(DataSource dataSource){

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    private static final String ID_FIELD = "id";
    private static final String NOM_FIELD = "nom";
    private static final String PRENOM_FIELD = "prenom";
    private static final String ANNEENAISSANCE_FIELD = "anneeNaissance";
    private static final String NATIONALITE_FIELD = "nationalite";
    private final RowMapper<PersonDTO> rowMapper = (rs, rowNum) -> {
        final PersonDTO person = new PersonDTO();
        person.setId(rs.getInt(ID_FIELD));
        person.setNom(rs.getString(NOM_FIELD));
        person.setPrenom(rs.getString(PRENOM_FIELD));
        person.setAnneeNaissance(rs.getInt(ANNEENAISSANCE_FIELD));
        person.setNationalite(rs.getString(NATIONALITE_FIELD));
        return person;};
    public Person create(NewPerson person){
        int anneeNaissance = 2023 - person.getAge();
        String requete = "insert into person (nom, prenom, anneenaissance) values " +
                "("+person.getNom()+","+person.getPrenom()+","+anneeNaissance+")";
        this.jdbcTemplate.query(requete,this.rowMapper);
        return new Person();
    }
    public Person read(int id){
        String requete = "select * from person where id="+id;
        List<PersonDTO> personDTO = this.jdbcTemplate.query(requete, this.rowMapper);
        if (personDTO != null && personDTO.size()<2) {
            Person person = new Person();
            person.setId(personDTO.get(0).getId());
            person.setNom(personDTO.get(0).getNom());
            person.setPrenom(personDTO.get(0).getPrenom());
            person.setAge(2023 - personDTO.get(0).getAnneeNaissance());
            return person;
        }
        return new Person();
    }
    public List<Person> read(String nom, String prenom){
        List<Person> listPerson = null;
        List<PersonDTO> dtos = this.jdbcTemplate.query("select * from person", this.rowMapper);
        if(dtos != null && dtos.size()>0){
            listPerson = new ArrayList<Person>();
            for(PersonDTO dto : dtos){
                Person resp = new Person();
                resp.setId(dto.getId());
                resp.setNom(dto.getNom());
                resp.setPrenom(dto.getPrenom());
                resp.setAge(2023-dto.getAnneeNaissance());
                listPerson.add(resp);
            }
        }
        if(nom != null && prenom==null){
            List<Person>listTri = new ArrayList<>();
            int taille = dtos.size();
            for (int i=0;i<taille;i++){
                if(dtos.get(i).getNom().equalsIgnoreCase(nom)){
                    Person resp = new Person();
                    resp.setId(dtos.get(i).getId());
                    resp.setNom(dtos.get(i).getNom());
                    resp.setPrenom(dtos.get(i).getPrenom());
                    resp.setAge(2023-dtos.get(i).getAnneeNaissance());
                    listTri.add(resp);
                }
            }
            return listTri;
        }
        if(prenom != null && nom==null){
            List<Person>listTri = new ArrayList<>();
            int taille = dtos.size();
            for (int i=0;i<taille;i++){
                if(dtos.get(i).getPrenom().equalsIgnoreCase(prenom)){
                    Person resp = new Person();
                    resp.setId(dtos.get(i).getId());
                    resp.setNom(dtos.get(i).getNom());
                    resp.setPrenom(dtos.get(i).getPrenom());
                    resp.setAge(2023-dtos.get(i).getAnneeNaissance());
                    listTri.add(resp);
                }
            }
            return listTri;
        }
        if(prenom != null && nom!=null){
            List<Person>listTri = new ArrayList<>();
            int taille = dtos.size();
            for (int i=0;i<taille;i++){
                if(dtos.get(i).getPrenom().equalsIgnoreCase(prenom) && dtos.get(i).getNom().equalsIgnoreCase(nom)){
                    Person resp = new Person();
                    resp.setId(dtos.get(i).getId());
                    resp.setNom(dtos.get(i).getNom());
                    resp.setPrenom(dtos.get(i).getPrenom());
                    resp.setAge(2023-dtos.get(i).getAnneeNaissance());
                    listTri.add(resp);
                }
            }
            return listTri;
        }
        return listPerson;
    }
    public Person update(int id, NewPerson newPerson){
        int anneeNaissance = 2023 - newPerson.getAge();
        String requete = "update person set nom ='"+newPerson.getNom()
                +"', prenom ='"+newPerson.getPrenom()
                +"', anneenaissance ='"+anneeNaissance
                +"' where id ="+id;
        this.jdbcTemplate.update(requete);
        return this.read(id);
    }
    public boolean delete(int id){
        String requete = "delete from person where id="+id;
        int i = this.jdbcTemplate.update(requete);
        return (i==1);
    }
}
