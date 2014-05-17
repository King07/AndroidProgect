package com.example.androiddevelopmentproject;

import java.io.Serializable;

public class Player implements Serializable{
	String firstName;
	String lastName;
	int rating;
	int status;
	int odd;
	
	public Player() {
		
	}

	public Player(String firstName, String lastName, int rating, int status,int odd) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.rating = rating;
		this.status = status;
		this.odd = odd;
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
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
	
	
	
	
	
	
	
	

}
