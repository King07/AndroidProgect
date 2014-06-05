package com.example.androiddevelopmentproject;

import java.io.Serializable;

public class Player implements Serializable,Comparable<Player>{
	String firstName = "firstName";
	String lastName = "lastName";
	int rating;
	String nextPairing;
	int points;
	int currentRating;
	int currentValue;
	int status; 
	int isAdmin = 0;
	int active = 0;


	int odd;
	String id;
	String playerSecret;
	
	public Player() {
		
	}

	public Player(String id, String playerSecret) {
		
		this.id = id;
		this.playerSecret = playerSecret;
	}



	public Player(String id, String firstName, String lastName,
			String nextPairing, int points, int currentRating, 
			int currentValue) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nextPairing = nextPairing;
		this.points = points;
		this.currentRating = currentRating;
		this.currentValue = currentValue;
	}

	public Player(String firstName, String lastName, 	int rating,int odd) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.rating = rating;
		this.odd = odd;
	}
	

	public Player( String id,String firstName, String lastName, int rating,
			String nextPairing, int points, int crruntRating) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.rating = rating;
		this.nextPairing = nextPairing;
		this.points = points;
		this.currentRating = crruntRating;
		this.id = id;
	}

	public Player(String firstName, String lastName, int rating) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.rating = rating;
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

	public 	int getRating() {
		return rating;
	}

	public void setRating(	int rating) {
		this.rating = rating;
	}

	public String getNextPairing() {
		return nextPairing;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public void setNextPairing(String nextPairing) {
		this.nextPairing = nextPairing;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getCurrentRating() {
		return currentRating;
	}

	public void setCurrentRating(int currentRating) {
		this.currentRating = currentRating;
	}

	public int getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(int currentValue) {
		this.currentValue = currentValue;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getOdd() {
		return odd;
	}

	public void setOdd(int odd) {
		this.odd = odd;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPlayerSecret() {
		return playerSecret;
	}

	public void setPlayerSecret(String playerSecret) {
		this.playerSecret = playerSecret;
	}

	@Override
	public String toString() {
		return "Player [firstName=" + firstName + ", lastName=" + lastName
				+ ", rating=" + currentRating + "]";
	}
	
	//compare players by ratings

	@Override
	public int compareTo(Player player) {
		// TODO Auto-generated method stub
		
		if (this.currentRating < player.currentRating) {
			return 1;
		}
		return -1;
	}
	
	
	
	
	
	
	
	

}
