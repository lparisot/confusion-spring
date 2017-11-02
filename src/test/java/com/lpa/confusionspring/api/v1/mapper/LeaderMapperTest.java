package com.lpa.confusionspring.api.v1.mapper;

import com.lpa.confusionspring.api.v1.model.LeaderDTO;
import com.lpa.confusionspring.domain.Leader;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeaderMapperTest {
    private String NAME = "Doe";
    private String ID = "ID";
    private LeaderMapper leaderMapper = LeaderMapper.INSTANCE;

    @Test
    public void leaderToLeaderDTO() throws Exception {
        //given
        Leader leader = new Leader();
        leader.setId(ID);
        leader.setName(NAME);

        //when
        LeaderDTO leaderDTO = leaderMapper.leaderToLeaderDTO(leader);

        //then
        assertEquals(ID, leaderDTO.getId());
        assertEquals(NAME, leaderDTO.getName());
    }

    @Test
    public void leaderDTOToLeader() throws Exception {
        //given
        LeaderDTO leaderDTO = new LeaderDTO();
        leaderDTO.setId(ID);
        leaderDTO.setName(NAME);

        //when
        Leader leader = leaderMapper.leaderDTOToLeader(leaderDTO);

        //then
        assertEquals(ID, leader.getId());
        assertEquals(NAME, leader.getName());
    }

}