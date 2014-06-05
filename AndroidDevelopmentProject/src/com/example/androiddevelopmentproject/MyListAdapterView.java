package com.example.androiddevelopmentproject;

import java.util.ArrayList;

import android.content.Context;
import android.view.*;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyListAdapterView extends ArrayAdapter<Player> {
	private ArrayList<Player> objects;
	
	public MyListAdapterView(Context context, int textViewResourceId, ArrayList<Player> objects) {
		super(context, textViewResourceId, objects);
		this.objects = objects; 
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View itemView = convertView;
		
		//Check if the view exist, if not create it to work with
		if(itemView == null){
			LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			itemView = inflater.inflate(R.layout.opponent_listview, null);
		}
		
		//find the list to work with
		Player player = objects.get(position);
		//fill the view
		
		
		TextView fullName = (TextView) itemView.findViewById(R.id.textViewPlayerFullName);
	
		fullName.setText(player.getFirstName()+" "+player.getLastName());
		
		TextView rating = (TextView) itemView.findViewById(R.id.textViewPlayerRating);
		rating.setText(player.getCurrentRating()+"");
		
		// chance of winning
		TextView playerWinChance = (TextView) itemView.findViewById(R.id.textViewPlayerWinChance);
		playerWinChance.setText(player.getOdd()+"%");
		
		
	
	
		
		return itemView;
	}
}
