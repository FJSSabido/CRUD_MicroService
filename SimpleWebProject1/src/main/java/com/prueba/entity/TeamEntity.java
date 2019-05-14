package com.prueba.entity;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="Team")
public class TeamEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "team_Sequence")
//    @SequenceGenerator(name = "team_Sequence", sequenceName = "TEAM_SEQ")
    private Long id;

    @Column(name = "name")
    private String name; 
    
    @Column(name = "points")
    private int points;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "team")
    private List<PlayerEntity> players;

    public TeamEntity() {

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

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public List<PlayerEntity> getPlayers() {
		return players;
	}

	public void setPlayers(List<PlayerEntity> players) {
		this.players = players;
	}


        // getters/setters

}
