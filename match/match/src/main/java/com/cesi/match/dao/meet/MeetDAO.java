package com.cesi.match.dao.meet;

import com.cesi.match.controller.match.model.Match;
import com.cesi.match.controller.meet.model.Meet;
import com.cesi.match.controller.person.model.Person;
import com.cesi.match.dao.meet.model.MeetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import com.cesi.match.utils.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class MeetDAO {
    private final RestTemplate restTemplate;
    private final MapperMeetMeetDTO mapperMeetMeetDTO;

    @Autowired
    public MeetDAO(RestTemplate restTemplate, MapperMeetMeetDTO mapperMeetMeetDTO) {
        this.restTemplate = restTemplate;
        this.mapperMeetMeetDTO = mapperMeetMeetDTO;
    }


    public List<Meet> read(){
        ResponseEntity<MeetDTO[]> response;
        String url = "https://8080-cesi2022-spring3-zsh5qtnx8qn.ws-eu106.gitpod.io/api/v1/meets";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        response = restTemplate.exchange(url, HttpMethod.GET, entity, MeetDTO[].class);
        MeetDTO[] body = response.getBody();
        List<Meet> listMeet = mapperMeetMeetDTO.ListDTOToListMeet(body);
        return listMeet;
    }
}
