package info.androidhive.slidingmenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class LMainActivity extends Activity {
	String image;
	ImageLoader imageLoader = new ImageLoader(this);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lmain);
		
	

		Intent i = getIntent();
		// Get the intent from ListViewAdapter
		image= i.getStringExtra("url");

		// Locate the ImageView in singleitemview.xml
		ImageView imgphone = (ImageView) findViewById(R.id.imageView1);
		// Load image into the ImageView
		 
	        
		imageLoader.DisplayImage(image,imgphone);
	}
}
