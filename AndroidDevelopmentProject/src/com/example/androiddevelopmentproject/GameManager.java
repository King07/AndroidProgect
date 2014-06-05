package com.example.androiddevelopmentproject;

import java.util.ArrayList;
import java.util.Collections;

import android.util.Pair;

public class GameManager {
	private ArrayList<Player> _players;
	private ArrayList<Player> _players2;
	
	public GameManager() {
		LoadPlayers();
	}

	private ArrayList<Player> GetPlayers(){
		
		return _players;
	}
	//player who is going to play next
	public ArrayList<Player> GetPairedPlayers(Player player)
	{
		ArrayList<Player> pairedPlayers = new ArrayList<Player>();
		
		ArrayList<Player> allPlayingPlayers = GetAllPlayingPlayer();//players who will be playing
		Collections.sort(allPlayingPlayers);
		
		ArrayList<Pair<Player,Player>> pairedTwoPlayer = new ArrayList<Pair<Player,Player>>();
		Player tempPlayer = null;
		int counter=0;
		
		//if we have odd then the player will not be in paired
		for(Player p : allPlayingPlayers)//looking at all the soretd players with rating
		{
			counter ++;
			
			if(counter == 2)
			{
				Pair<Player,Player> newPair = new Pair<Player, Player>(tempPlayer, p);
				pairedTwoPlayer.add(newPair);
				counter = 0;
			}
			else
				tempPlayer = p;
		}
		for(Pair<Player,Player> pair : pairedTwoPlayer)
		{
			if(pair.first.id == player.id)
				pairedPlayers.add(pair.second);
			else if(pair.second.id == player.id)
				pairedPlayers.add(pair.first);
		}
		return pairedPlayers;
	}
	
	public Player GetPlayer(String id)
	{
		for(Player p : GetPlayers())
		{
			if(p.id == id)
			{
				return p;
			}
				
		}
		return null;
	}
	
	private ArrayList<Player> GetAllPlayingPlayer()
	{
		ArrayList<Player> PlayingPlayers = new ArrayList<Player>();
		for(Player p : GetPlayers())
		{
			if(p.nextPairing != "E" || p.nextPairing != "A")
			{
				PlayingPlayers.add(p); //only the playing players in next round
			}
		}
		
		return PlayingPlayers;
	}
	
	private void LoadPlayers()
	{	
		//later load players from database or json string
		//load players from database
		/*_players = new ArrayList<Player>();
		_players.add(new Player(1,"Kinson", "Michel", 0 , "E" , 0, 2176));
		_players.add(new Player(2,"Daniel", "Jeantihome",5, "A",5 , 1836));
		_players.add(new Player(3,"Nirajan", "Pokharel",4,null,5, 1110));
		_players.add(new Player(4,"shree", "Michel", 0 , null , 0, 2276));
		_players.add(new Player(5,"lover", "Jeantihome",5, null,5 , 1136));
		_players.add(new Player(6,"hero", "Pokharel",4,null,5, 1520));
		_players.add(new Player(7,"Kris", "Michel", 0 , null , 0, 2356));
		_players.add(new Player(8,"john", "Jeantihome",5, null,5 , 980));
		_players.add(new Player(9,"piet", "Pokharel",4,null,5, 900));*/
		this._players = this._players2;
		
		//create 
	}
	
	public ArrayList<Player>getPlayers(ArrayList<Player> players){
		this._players2 = players;
		
		return players;
		
	}

	
}
