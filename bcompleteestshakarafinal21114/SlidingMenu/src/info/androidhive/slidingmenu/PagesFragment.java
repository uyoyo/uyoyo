package info.androidhive.slidingmenu;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class PagesFragment extends Fragment {
	
	public PagesFragment(){}
	WebView webview;
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_pages, container, false);
        webview= (WebView) (rootView).findViewById(R.id.webView1);
		webview.getSettings().setJavaScriptEnabled(true);
		
		WebSettings ws = webview.getSettings();

		
		webview.loadUrl("file:///android_asset/wedding.html");
        return rootView;
    }
}
