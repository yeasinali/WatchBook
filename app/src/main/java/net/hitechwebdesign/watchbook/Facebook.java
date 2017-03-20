package net.hitechwebdesign.watchbook;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import net.hitechwebdesign.watchbook.R;

public class Facebook extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.facebook);
		
		WebView we = (WebView) findViewById(R.id.webView1);
        
        
        we.getSettings().setJavaScriptEnabled(true);
        we.loadUrl("http://facebook.com/");
        
        we.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
               view.loadUrl(url);
                return false;
            }
        });
	}
	
	

}
