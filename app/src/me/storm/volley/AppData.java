/*
 * Created by Storm Zhang, 2014.
 */

package me.storm.volley;

import me.storm.volley.data.RequestManager;
import android.app.Application;

public class AppData extends Application {
	@Override
    public void onCreate() {
        super.onCreate();
        
        init();
    }


    private void init() {
        RequestManager.init(this);
    }
}
