package aiss.model;

import java.util.ArrayList;
import java.util.List;

public class Team {

	private String id;
	private String name;
	private String league;
	private List<Player> players;
	
	public Team(){}
	
	public Team(String name){
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLeague() {
		return league;
	}

	public void setLeague(String league) {
		this.league = league;
	}

	public List<Player> getPlayers() {
		return players;
	}

	protected void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	public Player getPlayer(String id) {
		if (players==null)
			return null;
		
		Player Player =null;
		for(Player s: players)
			if (s.getId().equals(id))
			{
				Player=s;
				break;
			}
		
		return Player;
	}
	
	public void addPlayer(Player s) {
		if (players==null)
			players = new ArrayList<Player>();
		players.add(s);
	}
	
	public void deletePlayer(Player s) {
		players.remove(s);
	}
	
	public void deletePlayer(String id) {
		Player s = getPlayer(id);
		if (s!=null)
			players.remove(s);
	}
	
}