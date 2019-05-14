package com.prueba.controller;

import java.lang.invoke.MethodHandles;

import javax.validation.Valid;

import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.dto.MatchesDTO;
import com.prueba.dto.TeamDTO;
import com.prueba.entity.MatchesEntity;
import com.prueba.entity.TeamEntity;
import com.prueba.mapper.MatchMapper;
import com.prueba.mapper.TeamMapper;
import com.prueba.service.SoccerService;

@RestController
@RequestMapping(value = "/matches")
public class MatchController {

     private MatchMapper matchMapper = Mappers.getMapper(MatchMapper.class);
     private TeamMapper teamMapper = Mappers.getMapper(TeamMapper.class);
	 private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

		@Autowired 
		private SoccerService soccerService;
		
//		READ buscar player por idPlayer (GET)
		@RequestMapping(method = RequestMethod.GET, params = { "matchId" })
	    @ResponseBody
	    public MatchesEntity readOne(
			@RequestParam(value = "matchId") int matchId) {
			return soccerService.readMatch(matchId);
			}
			
//		CREATE insertar un nuevo Match (POST)
		@RequestMapping(method = RequestMethod.POST)
	    public void createMatch(@RequestBody MatchesDTO matchesDTO) {
	        MatchesEntity matchesEntity = new MatchesEntity();
	        matchesEntity = matchMapper.matchesDTOToMatches(matchesDTO);
			soccerService.createMatch(matchesEntity);
			TeamDTO teamDTOLocal = new TeamDTO();
			TeamDTO teamDTOVisitante = new TeamDTO();
	        if(StringUtils.pathEquals(matchesDTO.getWinner(), matchesDTO.getNameLocal())){
	        	teamDTOLocal = soccerService.readTeamByName(matchesDTO.getNameLocal());
	        	teamDTOLocal.setPoints(teamDTOLocal.getPoints()+3);
	        	TeamEntity teamEntity = teamMapper.teamDTOToTeam(teamDTOLocal);
	        	soccerService.updateTeam(teamEntity);
	        	
	        }else if (StringUtils.pathEquals(matchesDTO.getWinner(),matchesDTO.getNameVisitor())) {
	        	teamDTOVisitante = soccerService.readTeamByName(matchesDTO.getNameVisitor());
	        	teamDTOVisitante.setPoints(teamDTOVisitante.getPoints()+3);
	        	TeamEntity teamEntity = teamMapper.teamDTOToTeam(teamDTOVisitante);
	        	soccerService.updateTeam(teamEntity);
	        	
	        }else {
	        	teamDTOLocal = soccerService.readTeamByName(matchesDTO.getNameLocal());
	        	teamDTOLocal.setPoints(teamDTOLocal.getPoints()+1);
	        	TeamEntity teamEntity = teamMapper.teamDTOToTeam(teamDTOLocal);
	        	soccerService.updateTeam(teamEntity);
	        	
	        	teamDTOVisitante = soccerService.readTeamByName(matchesDTO.getNameVisitor());
	        	teamDTOVisitante.setPoints(teamDTOVisitante.getPoints()+1);
	        	teamEntity = teamMapper.teamDTOToTeam(teamDTOVisitante);
	        	soccerService.updateTeam(teamEntity);	        	
	        }
	    }
		

		//UPDATE: actualizar un team (UPDATE)
	    @RequestMapping(method = RequestMethod.PUT, params = { "matchId" })
	    @ResponseStatus(value = HttpStatus.NO_CONTENT)
	    public void update(@RequestBody @Valid MatchesEntity match,
				@RequestParam(value = "matchId") long matchId) {
	    	match.setIdMatch(matchId);
	    	soccerService.updateMatch(match);
	    }

//		DELETE borrar un match por id (DELETE)
	    @RequestMapping(method = RequestMethod.DELETE)
	    @ResponseStatus(value = HttpStatus.OK)
	    public void delete(@RequestParam ("idMatch") long idMatch) {
	    	soccerService.deleteMatch(idMatch);
	    }	
}
