package com.prueba.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="Player")
public class PlayerEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_Sequence")
//	@SequenceGenerator(name = "player_Sequence", sequenceName = "PLAYER_SEQ")
	@Column(name = "id_player")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "num")
	private int num;

	@Column(name = "position")
	private String position;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team_id", nullable = false)
	private TeamEntity team;

	public PlayerEntity() {
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

	public TeamEntity getTeam() {
		return team;
	}

	public void setTeam(TeamEntity team) {
		this.team = team;
	}

	// getters/setters

}