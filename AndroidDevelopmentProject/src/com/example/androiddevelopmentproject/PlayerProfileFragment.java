package com.example.androiddevelopmentproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * 
 */
public class PlayerProfileFragment extends Fragment {
	View v;

	public PlayerProfileFragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		 v = (View) inflater.inflate(R.layout.fragment_player_profile,container,false);
		//
			return v;
	}

}
