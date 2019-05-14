package com.prueba.service;

import java.lang.invoke.MethodHandles;

import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.dto.PlayerDTO;
import com.prueba.dto.TeamDTO;
import com.prueba.entity.MatchesEntity;
import com.prueba.entity.PlayerEntity;
import com.prueba.entity.TeamEntity;
import com.prueba.mapper.MatchMapper;
import com.prueba.mapper.PlayerMapper;
import com.prueba.mapper.TeamMapper;
import com.prueba.repository.MatchRepository;
import com.prueba.repository.PlayerRepository;
import com.prueba.repository.TeamRepository;

@Service
public class SoccerServiceImpl implements SoccerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;
    
    @Autowired 
    private MatchRepository matchRepository;    

    private PlayerMapper playerMapper = Mappers.getMapper(PlayerMapper.class);
    private TeamMapper teamMapper = Mappers.getMapper(TeamMapper.class);
    private MatchMapper matchMapper = Mappers.getMapper(MatchMapper.class);
    
//    PLAYERS
	//READ
	public PlayerDTO readPlayer(long playerId) {
		PlayerEntity player = playerRepository.findOne(playerId);
		PlayerDTO resultDTO = playerMapper.playerToPlayerDTO(player);
//		resultDTO.setTeamName(resultDTO.getTeam().getName());
		
		return resultDTO;
	}
//	CREATE
	public void createPlayer(PlayerDTO playerDTO) {
		PlayerEntity playerEntity = playerMapper.playerDTOToPlayer(playerDTO);
		playerRepository.save(playerEntity);
	}
	
//	UPDATE
    @Override
    public void updatePlayer(PlayerDTO playerDTO) {
    	if(this.readPlayer(playerDTO.getId()) != null) {
			PlayerEntity playerEntity = playerMapper.playerDTOToPlayer(playerDTO);
			playerRepository.save(playerEntity);
		}
    }
    
	//DELETE
	@Override
	public void deletePlayerByName(String playerName) {
		playerRepository.deleteByName(playerName);
	}
	

//		TEAMS
	//CREATE
	public void createTeam(TeamEntity team) {
        teamRepository.save(team);
	}
//    READ
	public TeamDTO readTeam(long teamId) {
		TeamEntity teamEntity = teamRepository.findOne(teamId);
		TeamDTO teamDTO = teamMapper.teamToTeamDTO(teamEntity);
		return teamDTO;
	}
	@Override
	public TeamDTO readTeamByName(String teamName) {
		TeamEntity teamEntity = teamRepository.findByName(teamName);
		TeamDTO teamDTO = teamMapper.teamToTeamDTO(teamEntity);
		return teamDTO;
	}
	//UPDATE
	public void updateTeam(TeamEntity team) {
		teamRepository.save(team);
	}

//  DELETE
    public void deleteTeamByName(String teamName) {
    	teamRepository.deleteByName(teamName);
    };

    @Override
	public void deleteTeamById(long teamId) {
		teamRepository.delete(teamId);
	}

//	  NO IMPLEMENTADO
//  public List<Team> getAllTeams(int teamId){
//  	List<Team> teams = (List<Team>) teamRepository.findAll();
//  	return teams;
//  }

	//  MATCHES
	@Override
	public void createMatch(MatchesEntity match) {
		matchRepository.save(match);
		
	}
	@Override
	public MatchesEntity readMatch(long idMatch) {
		return matchRepository.findOne(idMatch);
	}
	@Override
	public void updateMatch(MatchesEntity match) {
		matchRepository.save(match);
		
	}
	@Override
	public void deleteMatch(long idMatch) {
		matchRepository.delete(idMatch);
		
	}
	
//	IMPLEMENTAR EN CASA
//	@Override
//	public List<String> getAllTeamPlayers(long teamId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	@Override
//	public List<Team> getAllTeams(int teamId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
    

}