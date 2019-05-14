package com.prueba.controller;

import java.lang.invoke.MethodHandles;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.dto.PlayerDTO;
import com.prueba.entity.PlayerEntity;
import com.prueba.repository.PlayerRepository;
import com.prueba.service.SoccerService;

@RestController
//@RequestMapping(value = "/players")
public class PlayerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	// inyectar servicio de player para consumirlo
	@Autowired
	private SoccerService soccerService;

//		CREATE insertar un nuevo Player (POST)
	@RequestMapping(method = RequestMethod.POST, value = "/teams/{teamName}/players")
	@ResponseBody
	public void createPlayer(@PathVariable("teamName") String teamName, @RequestBody @Valid PlayerDTO playerDTO) {
		soccerService.createPlayer(playerDTO);
	}

//		READ buscar player por idPlayer (GET)
	@RequestMapping(method = RequestMethod.GET, value = "/players", params = { "playerId" })
	@ResponseBody
	public PlayerDTO readOne(@RequestParam(value = "playerId") int playerId) {
		return soccerService.readPlayer(playerId);
	}

	@RequestMapping(value = "/players/{playerId}", method = RequestMethod.GET)
	@ResponseBody
	public PlayerDTO read(@PathVariable(value = "playerId") long playerId) {
		PlayerDTO player = soccerService.readPlayer(playerId);
		return player; 
	}

//		UPDATE actualizar un player (UPDATE)
	@RequestMapping(value = "/players/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public PlayerDTO update(@RequestBody @Valid PlayerDTO playerDTO, @PathVariable(value = "id") long id) {
		if(soccerService.readPlayer(id) == null) {
			return null;
		} else {
			playerDTO.setId(id);
			soccerService.updatePlayer(playerDTO);

			return playerDTO;
		}
//		PlayerDTO playerDTO = soccerService.readPlayer(id);
//		playerDTO.setName(playerDetails.getName());
//		playerDTO.setNum(playerDetails.getNum()); 
//		playerDTO.setPosition(playerDetails.getPosition());
//		playerDTO.setTeam(playerDetails.getTeam());

	}

//		DELETE borrar un player por idPlayer (DELETE)
	@RequestMapping(value = "players", method = RequestMethod.DELETE, params = { "playerName" })
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(	
    		@RequestParam(value = "playerName") String playerName) {
		soccerService.deletePlayerByName(playerName);
	}
}
