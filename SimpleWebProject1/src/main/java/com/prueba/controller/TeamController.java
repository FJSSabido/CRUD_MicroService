package com.prueba.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.prueba.dto.TeamDTO;
import com.prueba.entity.TeamEntity;
import com.prueba.service.SoccerService;

@RestController
@RequestMapping(value = "/teams")
public class TeamController {
	// exponer metodos mediante REST del crud
	// inyectar servicio de team para consumirlo
	@Autowired 
	private SoccerService soccerService;

	
	//CREATE: insertar un nuevo Team (POST)
	@RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void createTeam(@RequestBody @Valid TeamEntity team) {
        soccerService.createTeam(team);
    }
	
	//READ: buscar team por idTeam (GET)
	@RequestMapping(method = RequestMethod.GET, params = { "teamId" })
    @ResponseBody
    public TeamDTO readOne(
    		@RequestParam(value = "teamId", defaultValue = "1") int teamId) {
		return soccerService.readTeam(teamId);
		}
	@RequestMapping(value = "/{teamId}", method = RequestMethod.GET)
	@ResponseBody
	public TeamDTO read(@PathVariable(value = "teamId") long userId) {
		TeamDTO team = soccerService.readTeam(userId);
		return team;
		}
	

	//UPDATE: actualizar un team (UPDATE)
    @RequestMapping(value = "/putTeam", method = RequestMethod.PUT)
//    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody @Valid TeamEntity team) {
    	soccerService.updateTeam(team);
    }	

//	DELETE: borrar un team por nombre (DELETE)
    @RequestMapping(params = {"teamName"}, method = RequestMethod.DELETE)

    @ResponseStatus(value = HttpStatus.OK)
    public void delete(
    		@RequestParam(value = "teamName") String teamName) {
    	soccerService.deleteTeamByName(teamName);
    }	
}

//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ResponseBody
//    public String handleServerErrors(Exception ex) {
//        return ex.getMessage();
//    }
//}