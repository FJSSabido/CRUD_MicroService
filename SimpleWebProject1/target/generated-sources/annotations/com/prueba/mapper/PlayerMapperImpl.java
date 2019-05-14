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
public class PlayerMapperImpl implements PlayerMapper {

    @Override
    public PlayerDTO playerToPlayerDTO(PlayerEntity playerEntity) {
        if ( playerEntity == null ) {
            return null;
        }

        PlayerDTO playerDTO = new PlayerDTO();

        String name = playerEntityTeamName( playerEntity );
        if ( name != null ) {
            playerDTO.setTeamName( name );
        }
        playerDTO.setNum( playerEntity.getNum() );
        playerDTO.setName( playerEntity.getName() );
        playerDTO.setId( playerEntity.getId() );
        playerDTO.setPosition( playerEntity.getPosition() );
        playerDTO.setTeam( teamLazy( playerEntity.getTeam() ) );

        return playerDTO;
    }

    @Override
    public TeamDTO teamLazy(TeamEntity teamEntity) {
        if ( teamEntity == null ) {
            return null;
        }

        TeamDTO teamDTO = new TeamDTO();

        teamDTO.setId( teamEntity.getId() );
        teamDTO.setName( teamEntity.getName() );
        teamDTO.setPoints( teamEntity.getPoints() );

        return teamDTO;
    }

    @Override
    public PlayerEntity playerDTOToPlayer(PlayerDTO playerDTO) {
        if ( playerDTO == null ) {
            return null;
        }

        PlayerEntity playerEntity = new PlayerEntity();

        playerEntity.setId( playerDTO.getId() );
        playerEntity.setName( playerDTO.getName() );
        playerEntity.setNum( playerDTO.getNum() );
        playerEntity.setPosition( playerDTO.getPosition() );
        playerEntity.setTeam( teamDTOToTeamEntity( playerDTO.getTeam() ) );

        return playerEntity;
    }

    private String playerEntityTeamName(PlayerEntity playerEntity) {
        if ( playerEntity == null ) {
            return null;
        }
        TeamEntity team = playerEntity.getTeam();
        if ( team == null ) {
            return null;
        }
        String name = team.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    protected List<PlayerEntity> playerDTOListToPlayerEntityList(List<PlayerDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<PlayerEntity> list1 = new ArrayList<PlayerEntity>( list.size() );
        for ( PlayerDTO playerDTO : list ) {
            list1.add( playerDTOToPlayer( playerDTO ) );
        }

        return list1;
    }

    protected TeamEntity teamDTOToTeamEntity(TeamDTO teamDTO) {
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
}
