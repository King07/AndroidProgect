package com.example.androiddevelopmentproject;

public class NextFiveRound 
{

	int id;
	String first;
	String second;
	String third;
	String fourth;
	String fifth;
	
	public NextFiveRound()
	{
		
	}
	
	public NextFiveRound(int id, String first, String second,   String third, String fourth, String fifth) 
	{
		this.id = id;
		this.first = first;
		this.second = second;
		this.third = third;
		this.fourth = fourth;
		this.fifth = fifth;
	}
	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	public String getFirst() 
	{
		return first;
	}
	
	public void setFirst(String first) 
	{
		this.first = first;
	}
	
	public String getSecond() 
	{
		return second;
	}
	
	public void setSecond(String second) 
	{
		this.second = second;
	}
	
	public String getThird()
	{
		return third;
	}
	
	public void setThird(String third)
	{
		this.third = third;
	}
	
	public String getFourth() 
	{
		return fourth;
	}
	
	public void setFourth(String fourth) 
	{
		this.fourth = fourth;
	}
	
	public String getFifth() 
	{
		return fifth;
	}
	
	public void setFifth(String fifth) 
	{
		this.fifth = fifth;
	}
	
	
}
