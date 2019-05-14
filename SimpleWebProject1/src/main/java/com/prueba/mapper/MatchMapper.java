package com.prueba.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import com.prueba.dto.MatchesDTO;
import com.prueba.dto.PlayerDTO;
import com.prueba.dto.TeamDTO;
import com.prueba.entity.MatchesEntity;
import com.prueba.entity.PlayerEntity;
import com.prueba.entity.TeamEntity;

@Mapper
public interface MatchMapper {
    @Mappings({
        @Mapping(target="id", source="playerEntity.id"),
        @Mapping(target="name", source="playerEntity.name"),
        @Mapping(target="num", source="playerEntity.num"),
        @Mapping(target="position", source="playerEntity.position"),
        @Mapping(target="teamName", source="playerEntity.team.name"),
//        @Mapping(ignore = true, target = "team"),
        @Mapping(target = "team", qualifiedByName = "teamLazy") })
    PlayerDTO playerToPlayerDTO(PlayerEntity playerEntity);
    
	@Named("teamLazy")
	@Mappings({ @Mapping(target = "players", ignore = true)})
	TeamDTO teamLazy(TeamEntity teamEntity);
    
    PlayerEntity playerDTOToPlayer(PlayerDTO playerDTO);
    
    MatchesDTO matchToMatchDTO(MatchesEntity match);
    MatchesEntity matchesDTOToMatches(MatchesDTO matchesDTO);
}
