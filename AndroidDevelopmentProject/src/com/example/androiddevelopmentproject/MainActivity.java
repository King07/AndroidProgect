package com.example.androiddevelopmentproject;



import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends FragmentActivity  implements android.view.View.OnClickListener{
	
	public static final String AppHash = "http://www.loodgietersbedrijfvantol.nl/api/verify.php?hash="; 
	Button login;
	EditText id;
	EditText secret;
	String playerId;
	String playerSecret;
	String hashMd5;
	
	 public static final String MyPREFERENCES = "AppUserPrefs" ;
	   public static final String ID = "id"; 
	   public static final String SECRET = "secret"; 
	   public static final String TIMESTAMP_LAST_UPDATE = "timeStampUpdate"; 
	   SharedPreferences sharedpreferences;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Remove title bar before set in the view
	    this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	    setContentView(R.layout.login_screen);
		//get reference of all views
		login = (Button) findViewById(R.id.button_enter);
		login.setOnClickListener(this);
		id = (EditText) findViewById(R.id.playerId);
		secret = (EditText) findViewById(R.id.playerSecret);

		//save the player id and Secret
		sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

	      if (sharedpreferences.contains(ID))
	      {
	         id.setText(sharedpreferences.getString(ID, ""));

	      }
	      
	      if (sharedpreferences.contains(SECRET))
	      {
	         secret.setText(sharedpreferences.getString(SECRET, ""));

	      }
		
		
	}
	
	// if the login button is clicked
	//get the player id and secret
	//hash md5 the secret and a background get request 

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		 playerId  = id.getText().toString();
	     playerSecret  = secret.getText().toString();
	     hashMd5 =md5Java(playerSecret).substring(0, 30);
	     System.out.println("hashMd5: "+hashMd5);
	     new HttpAsyncTask().execute(AppHash+hashMd5);
	    
	
	}

	
	
	
	//background task checking a get request to the given url
	 private class HttpAsyncTask extends AsyncTask<String, Void, String> {
	        @Override
	        protected String doInBackground(String... urls) {
	        	JsonHelper jsonHelper = new JsonHelper();
	            return jsonHelper.GET(urls[0]);
	        }
	        // onPostExecute check if the result of the AsyncTask is true then save the info and 
	        //move to the next screen (MainMenuActivity)
	        //else password was incorrect
	        @Override
	        protected void onPostExecute(String result) {
	        	//Toast.makeText(getBaseContext(), "Received!"+result, Toast.LENGTH_LONG).show();
	        	System.out.println("result hash: "+result);
	        	if (result.contains("true")) {
	        		Player appUser = new Player(playerId, playerSecret);
	        		if(sharedpreferences.contains(MyPREFERENCES) == false)
	        		{
		        		  Editor editor = sharedpreferences.edit();
		        	      editor.putString(ID, playerId);
		        	      editor.putString(SECRET, playerSecret);
		        	      editor.putString(TIMESTAMP_LAST_UPDATE, "0");
		        	      editor.commit(); 
	        		}
	        	      
	        		Intent intent = new Intent(getApplicationContext(),MainMenuActivity.class);
	        		intent.putExtra("appUser", appUser);
	                startActivity(intent);
				}else{
					Toast.makeText(getBaseContext(), "Incorrect ID or Secret", Toast.LENGTH_LONG).show();
					id.setText("");
					secret.setText("");
				}
	        	
	        	
	       }
	 }
	 
	 //Method to has the player secret key to md5 hashing
	 public static String md5Java(String message){ 
			String digest = null; 
			try { MessageDigest md = MessageDigest.getInstance("MD5"); 
			byte[] hash = md.digest(message.getBytes("UTF-8")); 
			//converting byte array to Hexadecimal String 
			StringBuilder sb = new StringBuilder(2*hash.length); 
			for(byte b : hash){ 
				sb.append(String.format("%02x", b&0xff)); 
				} 
			digest = sb.toString();
			} catch (UnsupportedEncodingException ex) 
			{ 
				//Logger.getLogger(StringReplace.class.getName()).log(Level.SEVERE, null, ex); 
				} catch (NoSuchAlgorithmException ex) { 
					//Logger.getLogger(StringReplace.class.getName()).log(Level.SEVERE, null, ex); 
					} 
			return digest; 
			} 
	 
/*	 private String getHashMd5(String password) {
		 String passwordToHash = password;
	     String generatedPassword = null;
	     try {
	         // Create MessageDigest instance for MD5
	         MessageDigest md = MessageDigest.getInstance("MD5");
	         //Add password bytes to digest
	         md.update(passwordToHash.getBytes());
	         //Get the hash's bytes
	         byte[] bytes = md.digest();
	         //This bytes[] has bytes in decimal format;
	         //Convert it to hexadecimal format
	         StringBuilder sb = new StringBuilder();
	         for(int i=0; i< bytes.length ;i++)
	         {
	             sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	         }
	         //Get complete hashed password in hex format
	         generatedPassword = sb.toString();
	     }
	     catch (NoSuchAlgorithmException e)
	     {
	         e.printStackTrace();
	     }
	     
	     return generatedPassword;
	}*/
			
		
	 
	 


}
