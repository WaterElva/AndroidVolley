/*
 * Created by Storm Zhang, Feb 11, 2014.
 */

package me.storm.volley.ui;

import java.util.Arrays;
import java.util.List;

import me.storm.volley.R;
import me.storm.volley.R.id;
import me.storm.volley.model.ActivityInfo;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends BaseActivity implements OnItemClickListener {
	private ListView mListView;
	private List<ActivityInfo> mData = Arrays.asList(
			new ActivityInfo("SimpleRequest", SimpleRequestActivity.class),
			new ActivityInfo("JsonRequest", JsonRequestActivity.class),
			new ActivityInfo("PostParamsRequest", ParamsRequestActivity.class),
			new ActivityInfo("GsonRequest", GsonRequestActivity.class),
			new ActivityInfo("ImageLoading", ImageLoadingActivity.class));

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mListView = (ListView) findViewById(id.listView);
		mListView.setAdapter(new ArrayAdapter<ActivityInfo>(this,
				android.R.layout.simple_list_item_1, mData));
		mListView.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		Intent intent = new Intent(activity, mData.get(arg2).name);
		startActivity(intent);
	}
}
