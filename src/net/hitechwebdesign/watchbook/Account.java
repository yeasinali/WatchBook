package net.hitechwebdesign.watchbook;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Account extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.account);
		
		
		
		TextView name,email,sex,phone,full_name,age,full_sex;
		
		
		
		name = (TextView) findViewById(R.id.p_name);
		sex = (TextView) findViewById(R.id.p_sex);
		age = (TextView) findViewById(R.id.p_age);
		full_name = (TextView) findViewById(R.id.p_f_name);
		email = (TextView) findViewById(R.id.p_email);
		full_sex = (TextView) findViewById(R.id.p_f_sex);
		phone = (TextView) findViewById(R.id.p_phone);
		
		
		name.setText(getIntent().getExtras().getString("name"));
		sex.setText(getIntent().getExtras().getString("sex"));
		age.setText(getIntent().getExtras().getString("age"));
		full_name.setText(getIntent().getExtras().getString("name"));
		email.setText(getIntent().getExtras().getString("email"));
		full_sex.setText(getIntent().getExtras().getString("sex"));
		phone.setText(getIntent().getExtras().getString("phone"));
		
		ImageView p_image = (ImageView) findViewById(R.id.p_img);
		ImageView sett = (ImageView) findViewById(R.id.sett);
		
		String image = getIntent().getExtras().getString("img");
		
		
		try {			
			 byte[] rawImage = Base64.decode(image, Base64.DEFAULT);
             Bitmap bmp = BitmapFactory.decodeByteArray(rawImage, 0, rawImage.length); 

	        p_image.setImageBitmap(bmp);
	        
	    } catch (Exception e) {
	        e.getMessage();
	        
	    }
		
		
		
		

		
		sett.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {				
				Intent i = new Intent(Account.this, Menulist.class);
				i.putExtra("id", getIntent().getExtras().getString("id"));
			    startActivity(i);
			}
		});
		
		
	
	
	}	
	
	
	
	
	

}
