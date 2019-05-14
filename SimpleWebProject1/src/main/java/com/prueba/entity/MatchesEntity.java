package com.prueba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Marcamos con @Entity las clases que se corresponden con tablas
//en nuestra BBDD
@Entity
@Table(name ="Matches")
public class MatchesEntity {

//	Marcamos con @Id el atributo que se corresponde con nuestro id en la BBDD.
//	IMPORTANTE: Se tiene que llamar igual que en la BBDD
	@Id
//	Con esta anotación indicamos que nuestro id es autoincremental
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	Cada columna de la BBDD es marcada con el tag @Column
	@Column(name = "idmatch")
	private Long idMatch;

	@Column(name = "namelocal")
	private String nameLocal;

	@Column(name = "namevisitor")
	private String nameVisitor;
	
	@Column(name = "winner")
	private String winner;

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

	
	
}
