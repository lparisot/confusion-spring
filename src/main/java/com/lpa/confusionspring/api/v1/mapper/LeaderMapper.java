package com.lpa.confusionspring.api.v1.mapper;

import com.lpa.confusionspring.api.v1.model.LeaderDTO;
import com.lpa.confusionspring.domain.Leader;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LeaderMapper {
    LeaderMapper INSTANCE = Mappers.getMapper(LeaderMapper.class);

    LeaderDTO leaderToLeaderDTO(Leader leader);

    Leader leaderDTOToLeader(LeaderDTO leaderDTO);
}
