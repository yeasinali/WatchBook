package net.hitechwebdesign.watchbook;


import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import net.hitechwebdesign.watchbook.R;

public class Twitter extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.twitter);
		
		WebView wes = (WebView) findViewById(R.id.webView2);
        
        
        wes.getSettings().setJavaScriptEnabled(true);
        wes.loadUrl("http://twitter.com/");
        
        wes.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
               view.loadUrl(url);
                return false;
            }
        });
	}
	
	

}

