package com.example.androiddevelopmentproject;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainMenuActivity extends FragmentActivity implements OnClickListener {
	Button touuranment;
	Button HelpFaq;
	Button playerSearch;
	Button playerProfile;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_screen);
		
		//get reference of the views
		touuranment = (Button) findViewById(R.id.btn_tournament);
		touuranment.setOnClickListener(this);
		
		//get reference of the enter button
		HelpFaq = (Button) findViewById(R.id.btn_help);
		HelpFaq.setOnClickListener(this);
		
		//get reference of the enter button
		playerSearch = (Button) findViewById(R.id.btn_searchPlayer);
		playerSearch.setOnClickListener(this);
		
		//get reference of the enter button
		playerProfile = (Button) findViewById(R.id.btn_profile);
		playerProfile.setOnClickListener(this);
		

		
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent;
		switch (v.getId()) {
		case R.id.btn_tournament:
			 intent = new Intent(getApplicationContext(),TournamentActivity.class);
	        startActivity(intent);
	        break;
		case R.id.btn_help:
			 intent = new Intent(getApplicationContext(),AppHelp.class);
	        startActivity(intent);
	        break;
		case R.id.btn_searchPlayer:
			 intent = new Intent(getApplicationContext(),AppSearchPlayer.class);
	        startActivity(intent);
	        break;
		case R.id.btn_profile:
			 intent = new Intent(getApplicationContext(),AppProfilePlayer.class);
	        startActivity(intent);
	        break;

		default:
			break;
		}
		
		
	}



}
