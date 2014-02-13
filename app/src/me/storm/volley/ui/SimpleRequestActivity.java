/*
 * Created by Storm Zhang, 2014.
 */

package me.storm.volley.ui;

import vendor.Api;
import me.storm.volley.R;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

public class SimpleRequestActivity extends BaseActivity {
	private TextView mTvResult;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple_request);

		mTvResult = (TextView) findViewById(R.id.tv_result);

		Button btnSimpleRequest = (Button) findViewById(R.id.btn_simple_request);
		btnSimpleRequest.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				executeRequest(new StringRequest(Method.GET, Api.BAIDU, responseListener(),
						errorListener()));
			}
		});
	}

	private Response.Listener<String> responseListener() {
		return new Response.Listener<String>() {
			@Override
			public void onResponse(String response) {
				mTvResult.setText(response);
			}
		};
	}
}
