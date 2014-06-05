package com.example.androiddevelopmentproject;



import java.util.ArrayList;

import android.app.ActionBar;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

public class TournamentActivity extends FragmentActivity implements TabListener{
	 ArrayList<Player> PlayerList;
	 Player appUser ;
	 private ActionBar actionBar;
	    private ViewPager viewPager;
	    private TabsPagerAdapter mAdapter;
	    // Tab titles
	    private String[] tabs = { "Likely Opponent", "Player List","News"};
	   
	   

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tournament_pager);
		
		PlayerList =(ArrayList<Player>) getIntent().getSerializableExtra("PlayerList");
		
		System.out.println("Tournamenet in Tournament activity:  "+PlayerList);
	    
	    viewPager = (ViewPager) findViewById(R.id.pager);
	    //viewPager.setOffscreenPageLimit(0);
	    //get the action bar
	    actionBar = getActionBar();
	    mAdapter = new TabsPagerAdapter(getSupportFragmentManager());
	    
	    viewPager.setAdapter(mAdapter);
	    actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
      /* actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_green));
       actionBar.setDisplayShowTitleEnabled(true);
       actionBar.setDisplayShowTitleEnabled(false);*/
        actionBar.setStackedBackgroundDrawable(new ColorDrawable(Color.rgb(26, 188, 156)));
       
        //viewPager.setBackgroundColor(Color.GREEN);
        // 1. get passed intent 
	       Intent intent = getIntent();
	       appUser =  (Player) intent.getSerializableExtra("appUser");
			 
			 System.out.println(" The AppProfile Activity"+appUser.toString());
			 System.out.println("AppUser in Tournament activity:  "+appUser);
	       
	
 
        // Adding Tabs
        for (String tab_name : tabs) {
            actionBar.addTab(actionBar.newTab().setText(tab_name)
                    .setTabListener(this));
        }
        
        
        /**
         * on swiping the view pager make respective tab selected
         * */
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
 
            @Override
            public void onPageSelected(int position) {
                // on changing the page
                // make respected tab selected
                actionBar.setSelectedNavigationItem(position);
            }
 
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }
 
            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
        

		
	}

	public ArrayList<Player> getPlayerList() {
		return PlayerList;
	}


	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction fragmentTransaction) {
		
		viewPager.setCurrentItem(tab.getPosition());
		viewPager.setBackgroundColor(Color.WHITE);
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}
	public Player getPlayer() {
		return appUser;
		
	}
	

}
