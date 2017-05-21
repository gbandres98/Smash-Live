package aiss.model;

import java.util.Random;

public class Player {
	
	private String id;
	private String firstName;
	private String lastName;
	private String sponsor;
	private String age;
	private String nick;
	
	public Player(){
	}

	public Player(String firstName, String lastName, String sponsor, String age, String nick) {
		Random rn = new Random();
		this.id = Integer.toString(rn.nextInt(1000));
		this.firstName = firstName;
		this.lastName = lastName;
		this.sponsor = sponsor;
		this.age = age;
		this.nick = nick;
	}
	
	public Player(String id,String firstName, String lastName, String sponsor, String age, String nick) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.sponsor = sponsor;
		this.age = age;
		this.nick = nick;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSponsor() {
		return sponsor;
	}

	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}
	
	
	

}
