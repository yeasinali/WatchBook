package net.hitechwebdesign.watchbook;

import java.io.ObjectOutputStream.PutField;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;



import net.hitechwebdesign.watchbook.Home;
import net.hitechwebdesign.watchbook.Home.AttemptLogin;
import net.hitechwebdesign.watchbook.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends Activity{
	
	private Button btn_log,btn_re;
	private EditText un,pw;
	final Context context = this;
	static View my_re = null;
	
	private ProgressDialog pDialog;
	JSONParser jsonParser = new JSONParser();
	
	private static final String LOGIN_URL = "http://hitechwebdesign.net/watchbook/android/index.php";
	private static final String NAME = "name";
	private static final String ID = "id";
	private static final String EMAIL = "email";
	private static final String AGE = "age";
	private static final String R_DATE = "date";
	private static final String IMG = "img";
	private static final String SEX = "sex";
	private static final String PHONE = "phone";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		 btn_log = (Button) findViewById(R.id.btn_log);
		 un = (EditText) findViewById(R.id.t_un);
		 pw = (EditText) findViewById(R.id.t_pw);
		 
			 
		 btn_log.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new AttemptLogin().execute();
				
			}
		});
		 
		  
		 
		
		
		
		
	}
	
	

	
	

	class AttemptLogin extends AsyncTask<String, String, JSONObject> {

		 /**
        * Before starting background thread Show Progress Dialog
        * */
		boolean failure = false;
		
       @Override
       protected void onPreExecute() {
           super.onPreExecute();
           pDialog = new ProgressDialog(Home.this);
           pDialog.setMessage("Please Wait...");
           pDialog.setIndeterminate(false);
           pDialog.setCancelable(true);
           pDialog.show();
       }
		
		@Override
		protected JSONObject doInBackground(String... args) {
			
           String username = un.getText().toString();
           String password = pw.getText().toString();
           
               // Building Parameters
               List<NameValuePair> params = new ArrayList<NameValuePair>();
               params.add(new BasicNameValuePair("un", username));
               params.add(new BasicNameValuePair("pw", password));

               Log.d("request!", "starting");
               // getting product details by making HTTP request
               JSONObject json = jsonParser.makeHttpRequest(
                      LOGIN_URL, "POST", params);
               
              
          
          return json;

           
			
		}
		/**
        * After completing background task Dismiss the progress dialog
        * **/
       protected void onPostExecute(JSONObject json) {
           // dismiss the dialog once product deleted
           pDialog.dismiss();
           String suc = null;
           String img = null;
           String email = null;
           String id = null;
           String phone = null;
           String sex = null;
           String age = null;
           String r_date = null;
           
           try {
			 suc = json.getString(NAME);
			 id = json.getString(ID);
			 img = json.getString(IMG);
			 phone = json.getString(PHONE);
			 email = json.getString(EMAIL);
			 sex = json.getString(SEX);
			 age = json.getString(AGE);
			 r_date = json.getString(R_DATE);
			
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           

			if(suc != null){
				Intent i = new Intent(Home.this, Account.class);
				i.putExtra("name", suc);
				i.putExtra("id", id);
				i.putExtra("img", img);
				i.putExtra("phone", phone);
				i.putExtra("email", email);
				i.putExtra("sex", sex);
				i.putExtra("age", age);
				i.putExtra("r_date", r_date);
				startActivity(i);
			}
			else{
				Toast.makeText(Home.this, "Login Faild", Toast.LENGTH_LONG).show();
			}

       }
		
	}
		 

}
