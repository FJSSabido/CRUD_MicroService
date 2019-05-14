package com.prueba.mapper;

import com.prueba.dto.PlayerDTO;
import com.prueba.dto.TeamDTO;
import com.prueba.entity.PlayerEntity;
import com.prueba.entity.TeamEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-05-10T13:56:30+0200",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 1.8.0_45 (Oracle Corporation)"
)
public class TeamMapperImpl implements TeamMapper {

    @Override
    public TeamDTO teamToTeamDTO(TeamEntity teamEntity) {
        if ( teamEntity == null ) {
            return null;
        }

        TeamDTO teamDTO = new TeamDTO();

        teamDTO.setName( teamEntity.getName() );
        teamDTO.setId( teamEntity.getId() );
        teamDTO.setPoints( teamEntity.getPoints() );
        teamDTO.setPlayers( playerEntityListToPlayerDTOList( teamEntity.getPlayers() ) );

        return teamDTO;
    }

    @Override
    public PlayerDTO playersLazy(PlayerEntity playerEntity) {
        if ( playerEntity == null ) {
            return null;
        }

        PlayerDTO playerDTO = new PlayerDTO();

        playerDTO.setId( playerEntity.getId() );
        playerDTO.setName( playerEntity.getName() );
        playerDTO.setNum( playerEntity.getNum() );
        playerDTO.setPosition( playerEntity.getPosition() );

        return playerDTO;
    }

    @Override
    public TeamEntity teamDTOToTeam(TeamDTO teamDTO) {
        if ( teamDTO == null ) {
            return null;
        }

        TeamEntity teamEntity = new TeamEntity();

        teamEntity.setId( teamDTO.getId() );
        teamEntity.setName( teamDTO.getName() );
        teamEntity.setPoints( teamDTO.getPoints() );
        teamEntity.setPlayers( playerDTOListToPlayerEntityList( teamDTO.getPlayers() ) );

        return teamEntity;
    }

    protected List<PlayerDTO> playerEntityListToPlayerDTOList(List<PlayerEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<PlayerDTO> list1 = new ArrayList<PlayerDTO>( list.size() );
        for ( PlayerEntity playerEntity : list ) {
            list1.add( playersLazy( playerEntity ) );
        }

        return list1;
    }

    protected PlayerEntity playerDTOToPlayerEntity(PlayerDTO playerDTO) {
        if ( playerDTO == null ) {
            return null;
        }

        PlayerEntity playerEntity = new PlayerEntity();

        playerEntity.setId( playerDTO.getId() );
        playerEntity.setName( playerDTO.getName() );
        playerEntity.setNum( playerDTO.getNum() );
        playerEntity.setPosition( playerDTO.getPosition() );
        playerEntity.setTeam( teamDTOToTeam( playerDTO.getTeam() ) );

        return playerEntity;
    }

    protected List<PlayerEntity> playerDTOListToPlayerEntityList(List<PlayerDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<PlayerEntity> list1 = new ArrayList<PlayerEntity>( list.size() );
        for ( PlayerDTO playerDTO : list ) {
            list1.add( playerDTOToPlayerEntity( playerDTO ) );
        }

        return list1;
    }
}
