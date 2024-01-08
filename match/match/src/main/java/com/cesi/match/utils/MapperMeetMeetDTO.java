package com.cesi.match.utils;

import com.cesi.match.controller.meet.model.Meet;
import com.cesi.match.dao.meet.model.MeetDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapperMeetMeetDTO {

    public MeetDTO MeetToDTO(Meet meet, int id){
        MeetDTO dto =  new MeetDTO();
        if (id != 0) {
            dto.setId(id);
        }
        dto.setNuGagnant(meet.getIdGagnant());
        dto.setNuPerdant(meet.getIdPerdant());
        dto.setLieuTournoi(meet.getLieu());
        dto.setAnnee(meet.getAnnee());
        return dto;
    }

    public Meet DtoToMeet(MeetDTO dto){
        Meet meet = new Meet();
        meet.setIdGagnant(dto.getNuGagnant());
        meet.setIdPerdant(dto.getNuPerdant());
        meet.setLieu(dto.getLieuTournoi());
        meet.setAnnee(dto.getAnnee());
        return meet;
    }

    public List<Meet> ListDTOToListMeet(MeetDTO[] meetDTOSTableau){
        List<MeetDTO > meetDTOS =  Arrays.asList(meetDTOSTableau);
        List<Meet> meets = new ArrayList<>();
        for(MeetDTO meetDTO : meetDTOS){
            Meet meet;
            meet=DtoToMeet(meetDTO);
            meets.add(meet);
        }
        return meets;
    }
}