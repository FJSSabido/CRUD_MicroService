package com.prueba.service;
import com.prueba.dto.PlayerDTO;
import com.prueba.dto.TeamDTO;
import com.prueba.entity.MatchesEntity;
import com.prueba.entity.PlayerEntity;
import com.prueba.entity.TeamEntity;

public interface SoccerService {
//    public List<String> getAllTeamPlayers(long teamId);
	public PlayerDTO readPlayer(long playerId);
	public void createPlayer(PlayerDTO player);
//    public void addPlayer(String name, String position, int number);
    public void updatePlayer(PlayerDTO player);
	public void deletePlayerByName(String playerName);

//    public List<Team> getAllTeams(int teamId);
	public TeamDTO readTeam(long teamId);
	public TeamDTO readTeamByName(String name);
	public void createTeam(TeamEntity team);
    public void updateTeam(TeamEntity team);
    public void deleteTeamByName(String teamName);
	public void deleteTeamById(long teamId);

	public void createMatch(MatchesEntity match);
	public MatchesEntity readMatch(long idMatch);
    public void updateMatch(MatchesEntity match);
    public void deleteMatch(long idMatch);
	
	
    
    
    
    /*public void addTeam(String name);
    public Player getPlayer(long playerId);
    public Team getTeam(long teamId);*/
    
    
    
}