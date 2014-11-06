package info.androidhive.slidingmenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

public class SampleData {
//public String gender= "f";
	public static final int SAMPLE_DATA_ITEM_COUNT = 10;

	public static ArrayList<Data> generateSampleData(String gender) {
		String repeat = " repeat";
		final ArrayList<Data> datas = new ArrayList<Data>();
		List<ParseObject> ob;
		// Locate the class table named "SamsungPhones" in Parse.com
		ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("ankara");
	
		
		// Locate the column named "position" in Parse.com and order list
		// by ascending
		query.orderByDescending("createdAt");
		try {
			query.whereEqualTo("gender", gender);
			ob = query.find(); 
			//query.setLimit(20);
		
			query.fromLocalDatastore();
			for (ParseObject country : ob) {
				ParseFile image = (ParseFile) country.get("picture");
				//ParseFile des = (ParseFile) country.get("description");
				Data data = new Data();
				data.imageUrl = image.getUrl();
				data.description = "Source:"+(String) country.get("Source");
				data.title =(String) country.get("description");
				
				
				datas.add(data);
				
				  country.pinInBackground( new SaveCallback( ) {

				        @Override
				        public void done( ParseException e ) {
				            if( e == null ) {
				                //success
				            } else {
				                //fail
				            }
				        }
				    } );
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return datas;
	}

}
