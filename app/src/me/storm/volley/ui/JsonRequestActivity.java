/*
 * Created by Storm Zhang, Feb 11, 2014.
 */

package me.storm.volley.ui;

import me.storm.volley.R;

import org.json.JSONException;
import org.json.JSONObject;

import vendor.Api;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

public class JsonRequestActivity extends BaseActivity {
	private TextView mTvResult;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_json_request);

		mTvResult = (TextView) findViewById(R.id.tv_result);

		Button btnSimpleRequest = (Button) findViewById(R.id.btn_simple_request);
		btnSimpleRequest.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				executeRequest(new JsonObjectRequest(Method.GET, Api.JSON_TEST, null,
						responseListener(), errorListener()));
			}
		});
	}

	private Response.Listener<JSONObject> responseListener() {
		return new Response.Listener<JSONObject>() {
			@Override
			public void onResponse(JSONObject response) {
				try {
					mTvResult.setText(response.getString("one"));
				} catch (JSONException e) {
					mTvResult.setText("Parse error");
				}
			}
		};
	}
}
