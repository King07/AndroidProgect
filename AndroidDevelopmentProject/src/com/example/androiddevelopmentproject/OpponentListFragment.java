package com.example.androiddevelopmentproject;
import java.util.ArrayList;





import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;



public class OpponentListFragment extends ListFragment {
	ArrayList<Player> playerList;
	MyListAdapterView myListAdapter;
	View v;
	Context context;
	ArrayList<Player> PlayerList;
	ArrayList<Player> PlayerPair;
	
	/*@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		 v = (View) inflater.inflate(R.layout.opponent_listview,container,false);
		return v;
	}*/
	
	
	/*@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		playerList = new ArrayList<Player>();
		
	    
		playerList.add(new Player("Kinson", "Michel", "2176", 0, 76));
		playerList.add(new Player("Daniel", "Jeantihome", "1136", 1, 32));
		playerList.add(new Player("Nirajan", "Pokharel", "1110", 0,89 ));
	    myListAdapter = new MyListAdapterView(getActivity(), R.layout.opponent_listview, playerList);
		
		setListAdapter(myListAdapter);
		myListAdapter.notifyDataSetChanged();
	}*/
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		
		Intent intent = new Intent(getActivity(),OpponentProfilePlayer.class);
		Player player = (Player) getListView().getItemAtPosition(position);
		intent.putExtra("Player", player);
        startActivity(intent);
		
	}

	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		savedInstanceState = this.getArguments();
		try {
			 //get the player and set the views
			context = (TournamentActivity)getActivity();
			PlayerList = ((TournamentActivity)context).getPlayerList();
			System.out.println(" PlayerList in Opponent list view"+PlayerList);
			/*
			GameManager gm = new GameManager();
			gm.getPlayers(PlayerList);
			Player appUser = ((TournamentActivity)context).getPlayer();
			PlayerPair = gm.GetPairedPlayers(appUser);
			System.out.println(" PlayerList"+PlayerList);
			System.out.println(" PlayerPair"+PlayerPair);
			System.out.println(" appUser in Opponent list view"+appUser);*/
			
			if(PlayerList.isEmpty()){
				PlayerList.add(new Player());
			}
			
			  myListAdapter = new MyListAdapterView(getActivity(), R.layout.opponent_listview, PlayerList);
				setListAdapter(myListAdapter);
				myListAdapter.notifyDataSetChanged();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		 super.onActivityCreated(savedInstanceState);
	}


}
