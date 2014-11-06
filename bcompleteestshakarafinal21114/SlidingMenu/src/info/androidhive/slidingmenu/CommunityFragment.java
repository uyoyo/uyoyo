package info.androidhive.slidingmenu;



import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.etsy.android.grid.StaggeredGridView;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class CommunityFragment extends Fragment {
	
	public CommunityFragment(){}
	
	 private StaggeredGridView mGridView;
	    private DataAdapter mAdapter; Context context;
	    ProgressDialog  mProgressDialog;
		List<ParseObject> ob;
		public String gender="w";
		
	@Override
 public View onCreateView(LayoutInflater inflater, ViewGroup container,
         Bundle savedInstanceState) {
		
		View rootViews = inflater.inflate(R.layout.gallery, container, false);
   
		new RemoteDataTask().execute();
    
     return rootViews; 
   
 }
	
	private class RemoteDataTask extends AsyncTask<Void, Void, Void> {
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			// Create a progressdialog
			mProgressDialog = new ProgressDialog(getActivity());
			// Set progressdialog title
			mProgressDialog.setTitle("ejo! just a second.......");
			// Set progressdialog message
			mProgressDialog.setMessage("Loading...");
			mProgressDialog.setIndeterminate(false);
			// Show progressdialog
			mProgressDialog.show();
		}

		@Override
		protected Void doInBackground(Void... params) {
			String repeat = " repeat";
			final ArrayList<Data> datas = new ArrayList<Data>();
		ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("ankara");
		
			try {
				// Locate the class table named "SamsungPhones" in Parse.com
				
				// Locate the column named "position" in Parse.com and order list
				// by ascending
				//query.orderByAscending("createdAt");
				ob = query.find();
				for (ParseObject country : ob) {	
					ParseFile image = (ParseFile) country.get("picture");
					Data data = new Data();
					data.imageUrl = image.getUrl();
					data.title = (String) country.get("title");
					data.description =(String) country.get("description");
					Random ran = new Random();
					int x = ran.nextInt(1 + 9); 
					for (int j = 0; j < x; j++)
						data.description += repeat;
					datas.add(data);
					country.saveInBackground();
				}
			} catch (ParseException e) {
				Log.e("Error", e.getMessage());
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			 
	        mGridView = (StaggeredGridView)getView().findViewById(R.id.grid_view);
			

	        mAdapter = new DataAdapter(getActivity(), R.layout.list_item_sample, SampleData.generateSampleData(gender));
	        
	        	
	        mGridView.setAdapter(mAdapter);
	       
			
			// Close the progressdialog
			mProgressDialog.dismiss();
		
	
		  mGridView.setOnItemClickListener(new OnItemClickListener() {
			  @Override
	 public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
	    	 SampleData a= new SampleData();
	    	
	         ArrayList<Data> pics=   SampleData.generateSampleData(gender);
	         String f= pics.get(position).imageUrl;
	         Intent intent = new Intent(getActivity(),LMainActivity.class);
	        
	         intent.putExtra("url", f);
	        startActivity(intent);
	        
			  } });

}}}
