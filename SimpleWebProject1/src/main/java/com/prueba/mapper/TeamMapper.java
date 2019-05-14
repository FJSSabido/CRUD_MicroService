package com.prueba.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import com.prueba.dto.PlayerDTO;
import com.prueba.dto.TeamDTO;
import com.prueba.entity.PlayerEntity;
import com.prueba.entity.TeamEntity;

@Mapper
public interface TeamMapper {
	@Mappings({
        @Mapping(target="id", source="teamEntity.id"),
        @Mapping(target="name", source="teamEntity.name"),
        @Mapping(target="points", source="teamEntity.points"),
        @Mapping(target = "players", qualifiedByName = "playersLazy") })
//    	@Mapping(target = "players", ignore = true) })
    TeamDTO teamToTeamDTO(TeamEntity teamEntity);

	@Named("playersLazy")
	@Mappings({ @Mapping(target = "team", ignore = true)})
	PlayerDTO playersLazy(PlayerEntity playerEntity);

	TeamEntity teamDTOToTeam(TeamDTO teamDTO);
}
