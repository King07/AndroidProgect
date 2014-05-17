package com.example.androiddevelopmentproject;



import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends FragmentActivity  implements android.view.View.OnClickListener{
	Button enter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_screen);
		
		//get reference of the enter button
		enter = (Button) findViewById(R.id.button_enter);
		enter.setOnClickListener(this);
		
		

		

		
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(getApplicationContext(),MainMenuActivity.class);
        startActivity(intent);
	}

	



}
