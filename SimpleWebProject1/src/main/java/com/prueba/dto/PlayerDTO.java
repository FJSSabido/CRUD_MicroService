package com.prueba.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PlayerDTO {
	private Long id;

	private String name;

	private int num;

	private String position;

	private TeamDTO team;
	
	private String teamName;
	@JsonIgnore
	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public TeamDTO getTeam() {
		return team;
	}

	public void setTeam(TeamDTO team) {
		this.team = team;
	}
}
