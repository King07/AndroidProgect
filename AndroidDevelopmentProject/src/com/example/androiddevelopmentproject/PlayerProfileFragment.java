package com.example.androiddevelopmentproject;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * 
 */
public class PlayerProfileFragment extends Fragment {
	View v;
	Player appUser;
	TextView playerName;
	TextView playerRating;
	TextView playerRecord;
	TextView playerDescription;
	
	Context context;

	public PlayerProfileFragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		 v = (View) inflater.inflate(R.layout.fragment_player_profile,container,false);
		 
		//get references to all views.
		 playerName = (TextView) v.findViewById(R.id.textViewPlayerName);
		 playerRating = (TextView) v.findViewById(R.id.textViewPlayerRating);
		 playerRecord = (TextView) v.findViewById(R.id.textViewRecord);
		 playerDescription = (TextView) v.findViewById(R.id.textViewDescription);
		//
			return v;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		savedInstanceState = this.getArguments();
		 //get the player and set the views
		try {
			context = (AppProfilePlayer)getActivity();
			 appUser = ((AppProfilePlayer)context).getPlayer();
		     playerName.setText(appUser.getFirstName()+" "+appUser.getLastName());
			 playerRating.setText(appUser.getCurrentRating()+""); 
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		
		try {
			context = (OpponentProfilePlayer)getActivity();
			 appUser = ((OpponentProfilePlayer)context).getPlayer();
		     playerName.setText(appUser.getFirstName()+" "+appUser.getLastName());
			 playerRating.setText(appUser.currentRating+"");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		 super.onActivityCreated(savedInstanceState);
	}

}
