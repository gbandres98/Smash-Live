package aiss.model;

import twitter4j.Twitter;

public class User {
	
	private Twitter twitter;
	private static User instance = null;
	
	public static User getInstance() {
		
		if (instance==null) {
			instance = new User();
		}
		
		return instance;
	}
	
	public Twitter getTwitter(){
		return twitter;
	}
	
	public void setTwitter(Twitter twitter){
		this.twitter = twitter;
	}

}
