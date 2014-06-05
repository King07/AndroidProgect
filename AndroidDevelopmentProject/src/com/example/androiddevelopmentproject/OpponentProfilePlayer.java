package com.example.androiddevelopmentproject;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;


public class OpponentProfilePlayer extends FragmentActivity {

	
Player player;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.opponent_player_profile);
		
		 // 1. get passed intent 
	       Intent intent = getIntent();
	       player =  (Player) intent.getSerializableExtra("Player");
			 
			 System.out.println(" The OpponentProfilePlayer Activity"+player.toString());
	}
	
	public Player getPlayer() {
		return player;
	}

}
