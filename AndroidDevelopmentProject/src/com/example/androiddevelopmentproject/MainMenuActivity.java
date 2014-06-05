package com.example.androiddevelopmentproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.text.SimpleDateFormat;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainMenuActivity extends FragmentActivity implements OnClickListener {
	Button touuranment;
	Button HelpFaq;
	Button playerSearch;
	Button playerProfile;
	Button sync;
	ImageButton connect;
	ProgressBar progressBar;
	Player appUser;
	DBHelper dbHelper;
	ArrayList<Player> listPlayers;
	ProgressDialog pDialog;
	SharedPreferences sharedpreferences;
	public static final String TIMESTAMP_LAST_UPDATE = "timeStampUpdate"; 
	public static final String MyPREFERENCES = "AppUserPrefs" ;
	public static final String AppUrl = "http://www.loodgietersbedrijfvantol.nl/api/upd_players_matches.php?t="; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_screen);
		
		//get reference of the views
		progressBar = (ProgressBar) findViewById(R.id.ProgressBar);
		//get reference of the views
		touuranment = (Button) findViewById(R.id.btn_tournament);
		touuranment.setOnClickListener(this);
		
		//get reference of the views
		connect = (ImageButton) findViewById(R.id.imageBtnConnected);
				
		//get reference of the views and set the onclick listener
		sync = (Button) findViewById(R.id.btn_sync);
		sync.setOnClickListener(this);
		
		//get reference of the help button and set the onclick listener
		HelpFaq = (Button) findViewById(R.id.btn_help);
		HelpFaq.setOnClickListener(this);
		
		//get reference of the player search button and set the onclick listener
		playerSearch = (Button) findViewById(R.id.btn_searchPlayer);
		playerSearch.setOnClickListener(this);
		
		//get reference of the player profile button and set the onclick listener
		playerProfile = (Button) findViewById(R.id.btn_profile);
		playerProfile.setOnClickListener(this);
		
		// check if you are connected or not
        if(isConnected()){
        	connect.setImageResource(R.drawable.circle_green);
            
        }
        else{
        	connect.setImageResource(R.drawable.circle_red);
        }
    
		
     // 1. get passed intent 
        Intent intent = getIntent();
       appUser =  (Player) intent.getSerializableExtra("appUser");
       Log.d("The palyer", appUser.toString());
       
		
     //save the player id and Secret
     		sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent;
		switch (v.getId()) {
		case R.id.btn_tournament:
			 Bundle bundle = new Bundle();
			 Intent intentTournament = new Intent(getApplicationContext(),TournamentActivity.class);
			 bundle.putSerializable("PlayerList", listPlayers);
			 intentTournament.putExtra("appUser", appUser);
			 System.out.println("btn_tournament: "+listPlayers);
			 intentTournament.putExtras(bundle);
			 startActivity(intentTournament);
	        break;
		case R.id.btn_sync:
			String unixTimeStamp = "0";
			 if (sharedpreferences.contains(TIMESTAMP_LAST_UPDATE))
		      {
		         unixTimeStamp = sharedpreferences.getString(TIMESTAMP_LAST_UPDATE, "");

		      }
			
			System.out.println("The current time is:  "+unixTimeStamp);
			System.out.println(AppUrl+unixTimeStamp);
			new HttpAsyncTask().execute(AppUrl+unixTimeStamp);
			unixTimeStamp = ""+System.currentTimeMillis()/1000;
			Editor editor = sharedpreferences.edit();
  	        editor.putString(TIMESTAMP_LAST_UPDATE, unixTimeStamp);
  	        editor.commit();
	        
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
			Intent intent_profile = new Intent(getApplicationContext(),AppProfilePlayer.class);
			 intent_profile.putExtra("appUser", appUser);
			 System.out.println("btn_profile has click: "+appUser.toString());
	        startActivity(intent_profile);
	        break;

		default:
			break;
		}
		
		
	}
	
	 
	 
	    public boolean isConnected(){
	        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE);
	            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
	            if (networkInfo != null && networkInfo.isConnected()) 
	                return true;
	            else
	                return false;   
	    }
	    private class HttpAsyncTask extends AsyncTask<String, Integer, String> {
	        @Override
	        protected String doInBackground(String... urls) {
	        	JsonHelper jsonHelper = new JsonHelper();
	        	String result = jsonHelper.GET(urls[0]);
	        	try {
	        		
	        		//Toast.makeText(getBaseContext(), result, Toast.LENGTH_LONG).show();
					JSONObject json = new JSONObject(result);
					JSONObject playerlist = json.getJSONObject("players");
					listPlayers = new ArrayList<Player>();
					
					//Log.d("The palyers", json.toString(1));

					//Toast.makeText(getBaseContext(), "Received!", Toast.LENGTH_LONG).show();
					
					//Toast.makeText(getBaseContext(), json.getJSONArray("players").toString(), Toast.LENGTH_LONG).show();
					//Log.d("The palyers", json.toString());
					//Log.d("The palyers", json.getJSONObject("0").getString("fname"));
					//Log.d("The palyers", json.toString());
					
					for (int i = 0; i < playerlist.length();i++) {
						
						JSONObject playerInfo = json.getJSONObject("players").getJSONObject(""+i+"");
						//System.out.println(playerInfo.toString());
						 //playerInfo.getString("fname"), playerInfo.getString("lname"), Integer.parseInt(playerInfo.getString("current_rating"))
						Player player = new Player(playerInfo.getString("id"), playerInfo.getString("fname"), playerInfo.getString("lname"), playerInfo.getString("next_pairing"), Integer.parseInt(playerInfo.getString("points")), Integer.parseInt(playerInfo.getString("current_rating")), 0);
						dbHelper = new DBHelper(getApplicationContext());
						dbHelper.createPlayer(player);
						if((appUser.getId().equals(player.getId())))
						{
							appUser = player;
							System.out.println(appUser.toString());
						}
						listPlayers.add(player);
						//onProgressUpdate((int) ((i * 100) / playerlist.length()));
						publishProgress((int) ((i * 100) / playerlist.length()));
					}
					//Toast.makeText(getBaseContext(), "Sync completed!", Toast.LENGTH_LONG).show();
					
		        	//etResponse.setText(json.toString(1));

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					Log.d("JSON error", "Error in the json");
				}
	        	//
	            return "COMPLETEDS";
	        }
	        
	        @Override
	        protected void onProgressUpdate(Integer... values) {
	        	// TODO Auto-generated method stub
	        	super.onProgressUpdate(values);
	        	progressBar.setProgress(values[0]);
	        	
	        }
	        @Override
	        protected void onPreExecute() {
	        	// TODO Auto-generated method stub
	        	super.onPreExecute();
	        	/*pDialog = new ProgressDialog(MainMenuActivity.this);
	            pDialog.setMessage("Getting Data ...");
	            pDialog.setIndeterminate(false);
	            pDialog.setCancelable(true);
	            pDialog.show();*/
	        }
	        // onPostExecute displays the results of the AsyncTask.
	        @Override
	        protected void onPostExecute(String result) {
	        	Toast.makeText(getBaseContext(), result, Toast.LENGTH_LONG).show();
	        	//pDialog.dismiss();
	        	/*try {
	        		
	        		//Toast.makeText(getBaseContext(), result, Toast.LENGTH_LONG).show();
					JSONObject json = new JSONObject(result);
					JSONObject playerlist = json.getJSONObject("players");
					listPlayers = new ArrayList<Player>();
					
					//Log.d("The palyers", json.toString(1));

					//Toast.makeText(getBaseContext(), "Received!", Toast.LENGTH_LONG).show();
					
					//Toast.makeText(getBaseContext(), json.getJSONArray("players").toString(), Toast.LENGTH_LONG).show();
					//Log.d("The palyers", json.toString());
					//Log.d("The palyers", json.getJSONObject("0").getString("fname"));
					//Log.d("The palyers", json.toString());
					
					for (int i = 0; i < playerlist.length();i++) {
						
						JSONObject playerInfo = json.getJSONObject("players").getJSONObject(""+i+"");
						//System.out.println(playerInfo.toString());
						 //playerInfo.getString("fname"), playerInfo.getString("lname"), Integer.parseInt(playerInfo.getString("current_rating"))
						Player player = new Player(playerInfo.getString("id"), playerInfo.getString("fname"), playerInfo.getString("lname"), playerInfo.getString("next_pairing"), Integer.parseInt(playerInfo.getString("points")), Integer.parseInt(playerInfo.getString("current_rating")), 0);
						dbHelper = new DBHelper(getApplicationContext());
						dbHelper.createPlayer(player);
						if((appUser.getId().equals(player.getId())))
						{
							appUser = player;
							System.out.println(appUser.toString());
						}
						listPlayers.add(player);
						
					}
					Toast.makeText(getBaseContext(), "Sync completed!", Toast.LENGTH_LONG).show();
					
		        	//etResponse.setText(json.toString(1));

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					Log.d("JSON error", "Error in the json");
				}*/
	       }
	    }



}
