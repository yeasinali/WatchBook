package net.hitechwebdesign.watchbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class Friends extends ListActivity{
	
	private static final String LOGIN_URL = "http://hitechwebdesign.net/watchbook/android/friend.php";
	private static final String NAME = "name";
	private static final String EMAIL = "email";
	private static final String AGE = "age";
	private static final String NUM = "number";
	private static final String SEX = "sex";
	private static final String ADD = "add";
	
	
	private ProgressDialog pDialog;
	JSONParser jsonParser = new JSONParser();
	
	private ArrayList<HashMap<String, String>> friendlist;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friends);
		
		new AttemptLogin().execute();
	}
	
	
	
	
	
	
	
	
	private void updateList() {
		final ListAdapter adapter = new SimpleAdapter(this, friendlist,
				R.layout.friend_list, new String[] { NAME,
						NUM, AGE, SEX }, new int[] { R.id.nm,
						R.id.em, R.id.ag, R.id.se });
          
		
		setListAdapter(adapter);
		
		final ListView lv = getListView();	
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {			
				Toast.makeText(Friends.this, ""+lv.getItemAtPosition(position), Toast.LENGTH_LONG).show();
			}
		});
		
		
	}
	
	
	
	
	





	class AttemptLogin extends AsyncTask<Void, Void, Boolean> {

		 /**
       * Before starting background thread Show Progress Dialog
       * */
		boolean failure = false;
		String result = "";
		
      @Override
      protected void onPreExecute() {
          super.onPreExecute();
          pDialog = new ProgressDialog(Friends.this);
          pDialog.setMessage("Please Wait...");
          pDialog.setIndeterminate(false);
          pDialog.setCancelable(true);
          pDialog.show();
      }
		
		@Override
		protected Boolean doInBackground(Void... arg0) {
		friendlist = new ArrayList<HashMap<String, String>>();
          String u_id = getIntent().getExtras().getString("id");
          
              // Building Parameters
              List<NameValuePair> params = new ArrayList<NameValuePair>();
              params.add(new BasicNameValuePair("un", u_id));

              Log.d("request!", "starting");
              // getting product details by making HTTP request
              JSONObject json = jsonParser.makeHttpRequest(
                     LOGIN_URL, "POST", params);
              
              
              
              
              try {
            	 JSONArray jArray = json.getJSONArray("friend");
    			
            	 
            	 for (int i = 0; i < jArray.length(); i++) {
     				JSONObject c = jArray.getJSONObject(i);

     				// gets the content of each tag
     				String name = c.getString("name");
     				String number = c.getString("number");
     				String email = c.getString("email"); 
     				String sex = c.getString("sex"); 
     				String age = c.getString("age"); 
     				String add = c.getString("add"); 
     				
     				
     				

     				// creating new HashMap
     				HashMap<String, String> map = new HashMap<String, String>();

     				map.put(NAME, name);
     				map.put(NUM, number);
     				map.put(SEX, sex);
     				map.put(AGE, age);
     				
     				
     				


     				friendlist.add(map);

     			}
    			
    			} catch (JSONException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
         
         return null;

          
			
		}
		/**
       * After completing background task Dismiss the progress dialog
       * **/
      protected void onPostExecute(Boolean result) {
    	  super.onPostExecute(result);
          pDialog.dismiss();          
          
          updateList();         

      }
		
	}
	

}
