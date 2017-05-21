package aiss.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


import aiss.model.Team;
import aiss.model.Player;


public class MapTeamRepository implements TeamRepository{

	Map<String, Team> teamMap;
	Map<String, Player> playerMap;
	private static MapTeamRepository instance=null;
	private int index=0;			// Index to create teams and players' identifiers.
	
	
	public static MapTeamRepository getInstance() {
		
		if (instance==null) {
			instance = new MapTeamRepository();
			instance.init();
		}
		
		return instance;
	}
	
	public void init() {
		
		teamMap = new HashMap<String,Team>();
		playerMap = new HashMap<String,Player>();
		
		// Create players
		Player jukes=new Player();
		jukes.setFirstName("Guillermo");
		jukes.setLastName("Bandres");
		jukes.setSponsor("ETSII");
		jukes.setNick("Jukes");
		jukes.setAge("19");
		addPlayer(jukes);
		
		Player darnek=new Player();
		darnek.setFirstName("Julio");
		darnek.setLastName("Troncoso");
		darnek.setSponsor("ETSII");
		darnek.setNick("Darnek");
		darnek.setAge("20");
		addPlayer(darnek);
		
		Player meskion=new Player();
		meskion.setFirstName("Manuel");
		meskion.setLastName("Fernández");
		meskion.setSponsor("Melee Hispalis");
		meskion.setNick("Meskion");
		meskion.setAge("23");
		addPlayer(meskion);
		
		Player saix=new Player();
		saix.setFirstName("Carlos");
		saix.setLastName("Manchón");
		saix.setSponsor("Melee Hispalis");
		saix.setNick("SaiX");
		saix.setAge("26");
		addPlayer(saix);
		
		Player gatsu=new Player();
		gatsu.setFirstName("David");
		gatsu.setLastName("Diaz");
		gatsu.setSponsor("GANTZ");
		gatsu.setNick("Gatsu");
		gatsu.setAge("24");
		addPlayer(gatsu);
		
		
		// Create teams
		Team etsii=new Team();
		etsii.setName("ETSII");
		etsii.setLeague("Sevilla");
		addTeam(etsii);
		
		Team hispalis = new Team();
		hispalis.setName("Melee Hispalis");
		hispalis.setLeague("Sevilla");
		addTeam(hispalis);
		
		Team gantz = new Team();
		gantz.setName("GANTZ");
		gantz.setLeague("Madrid");
		addTeam(gantz);
		
		// Add players to teams
		addPlayer(etsii.getId(), jukes.getId());
		addPlayer(etsii.getId(), darnek.getId());
		
		addPlayer(hispalis.getId(), meskion.getId());
		addPlayer(hispalis.getId(), saix.getId());
		
		addPlayer(gantz.getId(),gatsu.getId());
	}
	
	// Team related operations
	@Override
	public void addTeam(Team t) {
		String id = "p" + index++;	
		t.setId(id);
		teamMap.put(id,t);
	}
	
	@Override
	public Collection<Team> getAllTeams() {
			return teamMap.values();
	}

	@Override
	public Team getTeam(String id) {
		return teamMap.get(id);
	}
	
	@Override
	public void updateTeam(Team t) {
		teamMap.put(t.getId(),t);
	}

	@Override
	public void deleteTeam(String id) {	
		teamMap.remove(id);
	}
	

	@Override
	public void addPlayer(String teamId, String playerId) {
		Team team = getTeam(teamId);
		team.addPlayer(playerMap.get(playerId));
	}

	@Override
	public Collection<Player> getAll(String teamId) {
		return getTeam(teamId).getPlayers();
	}

	@Override
	public void removePlayer(String teamId, String playerId) {
		getTeam(teamId).deletePlayer(playerId);
	}

	
	// Player related operations
	
	@Override
	public void addPlayer(Player p) {
		String id = "s" + index++;
		p.setId(id);
		playerMap.put(id,p);
	}
	
	@Override
	public Collection<Player> getAllPlayers() {
			return playerMap.values();
	}

	@Override
	public Player getPlayer(String playerId) {
		return playerMap.get(playerId);
	}

	@Override
	public void updatePlayer(Player p) {
		Player player = playerMap.get(p.getId());
		player.setFirstName(p.getFirstName());
		player.setLastName(p.getLastName());
		player.setSponsor(p.getSponsor());
		player.setAge(p.getAge());
		player.setNick(p.getNick());
	}

	@Override
	public void deletePlayer(String playerId) {
		playerMap.remove(playerId);
	}
	
}
