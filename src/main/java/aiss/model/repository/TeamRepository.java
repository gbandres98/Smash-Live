package aiss.model.repository;

import java.util.Collection;

import aiss.model.Team;
import aiss.model.Player;

public interface TeamRepository {
	
	
	// Players
	public void addPlayer(Player s);
	public Collection<Player> getAllPlayers();
	public Player getPlayer(String playerId);
	public void updatePlayer(Player s);
	public void deletePlayer(String playerId);
	
	// Teams
	public void addTeam(Team p);
	public Collection<Team> getAllTeams();
	public Team getTeam(String teamId);
	public void updateTeam(Team p);
	public void deleteTeam(String teamId);
	public Collection<Player> getAll(String teamId);
	public void addPlayer(String teamId, String playerId);
	public void removePlayer(String teamId, String playerId); 
	
}