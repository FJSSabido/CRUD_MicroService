package com.prueba.dto;

public class MatchesDTO {
	private Long idMatch;

	private String nameLocal;

	private String nameVisitor;
	
	public Long getIdMatch() {
		return idMatch;
	}

	public void setIdMatch(Long idMatch) {
		this.idMatch = idMatch;
	}

	public String getNameLocal() {
		return nameLocal;
	}

	public void setNameLocal(String nameLocal) {
		this.nameLocal = nameLocal;
	}

	public String getNameVisitor() {
		return nameVisitor;
	}

	public void setNameVisitor(String nameVisitor) {
		this.nameVisitor = nameVisitor;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	private String winner;
}
