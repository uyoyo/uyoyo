package info.androidhive.slidingmenu;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;
import android.app.Application;
import com.parse.ParseFile;

public class ParseApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		 Parse.enableLocalDatastore(this);
		// / Add your initialization code here
		Parse.initialize(this, "RYBRDnR5gVhVTfWQv0WFVjQHvTGr1VfAQHlnHRZZ", "1rNAIUqp4I0MNAtWsMwHAOT5yH9usSWgzsFxAlPn");

		ParseUser.enableAutomaticUser();
		ParseACL defaultACL = new ParseACL();

		// If you would like all objects to be private by default, remove this
		// line.
		defaultACL.setPublicReadAccess(true);

		ParseACL.setDefaultACL(defaultACL, true);
	}

}
