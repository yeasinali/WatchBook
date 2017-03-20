package net.hitechwebdesign.watchbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Menulist extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_menu);
		
		
		Button con,fr,fac,twi;
		
		con = (Button) findViewById(R.id.con);
		fr = (Button) findViewById(R.id.fr);
		fac = (Button) findViewById(R.id.fac);
		twi = (Button) findViewById(R.id.twitter);
	
		
		
		
		
		con.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {				
				Intent i = new Intent(Menulist.this, Contacts.class);
				i.putExtra("id", getIntent().getExtras().getString("id"));
			    startActivity(i);
			}
		});
		
		
		fr.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {				
				Intent i = new Intent(Menulist.this, Friends.class);
				i.putExtra("id", getIntent().getExtras().getString("id"));
			    startActivity(i);
			}
		});
		
		fac.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {				
				Intent i = new Intent(Menulist.this, Facebook.class);
				i.putExtra("id", getIntent().getExtras().getString("id"));
			    startActivity(i);
			}
		});
		
		twi.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {				
				Intent i = new Intent(Menulist.this, Twitter.class);
				i.putExtra("id", getIntent().getExtras().getString("id"));
			    startActivity(i);
			}
		});
		
		
	}

	
}
