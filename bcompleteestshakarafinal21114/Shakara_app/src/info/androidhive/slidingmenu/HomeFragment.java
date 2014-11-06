package info.androidhive.slidingmenu;










import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

@SuppressLint("JavascriptInterface") public class HomeFragment extends Fragment  {
	public WebView webView; LayoutInflater inflaters; ViewGroup containers;
	Context context;
	public static class Example {
	    public static String url="file:///android_asset/index.html";
	    public static int b;
	}
	public HomeFragment(){}

	@Override
	public View onCreateView( LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		

		// this snippet of code obtains from webview and activates javapage
		View rootView = inflater.inflate(R.layout.fragment_home, container, false);
		webView= (WebView) (rootView).findViewById(R.id.webView2);
		webView.getSettings().setJavaScriptEnabled(true);
		
		WebSettings ws = webView.getSettings();

		ws.setJavaScriptEnabled(true);
		webView.addJavascriptInterface(new Object()
		{
			           // For API 17+
			public void performClick(String strl)
			{                   Fragment fragment;                              // load female gallery
				String Variable = strl;
				if (Variable.toLowerCase().contains("female"))
				{ 
					    
					fragment = new FindPeopleFragment();;
		        	FragmentManager fragmentManager = getFragmentManager();
					fragmentManager.beginTransaction()
							.replace(R.id.frame_container, fragment).commit();
					fragmentManager.addOnBackStackChangedListener(null);


					
					// Replace whatever is in the fragment_container view with this fragment,
					// and add the transaction to the back stack

				}

				else if (Variable.toLowerCase().contains("wedding"))
				{
					fragment = new CommunityFragment();;
		        	FragmentManager fragmentManagerw = getFragmentManager();
		        
		        	fragmentManagerw.addOnBackStackChangedListener(null);
					fragmentManagerw.beginTransaction()
							.replace(R.id.frame_container, fragment).commit();

				}

				else if (Variable.toLowerCase().contains("male"))
				{
					fragment = new PhotosFragment();;
		        	FragmentManager fragmentManagerm = getFragmentManager();
		        	fragmentManagerm.addOnBackStackChangedListener(null);
					fragmentManagerm.beginTransaction()
							.replace(R.id.frame_container, fragment).commit();


				}

			}
		}, "ok");
		webView.loadUrl(Example.url);
		return rootView;
	}

	public static class FemaleFragment extends Fragment {
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootViews = inflater.inflate(R.layout.fragment_find_people, container, false);
			WebView webView= (WebView) (rootViews).findViewById(R.id.webView2);
			webView.loadUrl("file:///android_asset/page.html");
			WebSettings ws = webView.getSettings();
			webView.getSettings().setJavaScriptEnabled(true);
			return rootViews;
		}

	}
	
	// Generate male html page
	public static class maleFragment extends Fragment {
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootViewm = inflater.inflate(R.layout.fragment_photos, container, false);
			WebView webView= (WebView) (rootViewm).findViewById(R.id.webView2);

			webView.loadUrl("file:///android_asset/malepage.html");
			WebSettings ws = webView.getSettings();
			webView.getSettings().setJavaScriptEnabled(true);
			return rootViewm;
		}

	}
	
	// Generate wedding html page
	public static class weddingFragment extends Fragment {
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootVieww = inflater.inflate(R.layout.fragment_photos, container, false);
			WebView webView= (WebView) (rootVieww).findViewById(R.id.webView2);
			webView.getSettings().setLoadsImagesAutomatically(true);
			 
			webView.loadUrl("file:///android_asset/wedding.html");
			WebSettings ws = webView.getSettings();
			webView.getSettings().setJavaScriptEnabled(true);
			return rootVieww;
		}

	}
	@Override
	public void onSaveInstanceState(Bundle outState)
	  {
	    super.onSaveInstanceState(outState);
	 
	    // Save the state of the WebView
	    webView.saveState(outState);
	  }
	   
	  protected void onRestoreInstanceState(Bundle savedInstanceState)
	  {
	    super.onSaveInstanceState(savedInstanceState);
	 
	    // Restore the state of the WebView
	    webView.restoreState(savedInstanceState);
	  }

}
