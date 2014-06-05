package com.example.androiddevelopmentproject;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;


public class AppProfilePlayer extends FragmentActivity {

	 Player appUser ;

		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.player_profile);
			
			 // 1. get passed intent 
	       Intent intent = getIntent();
	       appUser =  (Player) intent.getSerializableExtra("appUser");
			 
			 System.out.println(" The AppProfile Activity"+appUser.toString());
	       
		}
		
		public Player getPlayer() {
			return appUser;
			
		}
		
}