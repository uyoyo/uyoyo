package info.androidhive.slidingmenu;



import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class TestActivity extends Activity {
WebView webView;Context context;   private final int SPLASH_DISPLAY_LENGTH = 1000;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
		                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
		 setContentView(R.layout.activity_test);
	         
	// METHOD 1     
	         
	         /****** Create Thread that will sleep for 5 seconds *************/        
	        Thread background = new Thread() {
	            public void run() {
	                 
	                try {
	                    // Thread will sleep for 5 seconds
	                    sleep(5*1000);
	                     
	                    // After 5 seconds redirect to another intent
	                    Intent i=new Intent(getBaseContext(),MainActivity.class);
	                    startActivity(i);
	                     
	                    //Remove activity
	                    finish();
	                     
	                } catch (Exception e) {
	                 
	                }
	            }
	        };
	         
	        // start thread
	        background.start();
	         
	//METHOD 2  
	         
	        /*
	        new Handler().postDelayed(new Runnable() {
	              
	            // Using handler with postDelayed called runnable run method
	  
	            @Override
	            public void run() {
	                Intent i = new Intent(MainSplashScreen.this, FirstScreen.class);
	                startActivity(i);
	  
	                // close this activity
	                finish();
	            }
	        }, 5*1000); // wait for 5 seconds
	        */
	    }
	     
	    @Override
	    protected void onDestroy() {
	         
	        super.onDestroy();
	         
	    }
	}