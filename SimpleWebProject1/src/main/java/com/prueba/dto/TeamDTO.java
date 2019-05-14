package com.prueba.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class TeamDTO {
    private Long id;

    private String name; 
    
    private int points;

    private List<PlayerDTO> players;

    public TeamDTO() {

    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@JsonIgnore
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	public List<PlayerDTO> getPlayers() {
		return players;
	}

	public void setPlayers(List<PlayerDTO> players) {
		this.players = players;
	}

	
}
