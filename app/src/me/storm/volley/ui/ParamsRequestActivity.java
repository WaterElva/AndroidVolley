/*
 * Created by Storm Zhang, Feb 13, 2014.
 */

package me.storm.volley.ui;

import java.util.Map;

import me.storm.volley.R;
import me.storm.volley.data.ApiParams;
import me.storm.volley.vendor.VolleyApi;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

public class ParamsRequestActivity extends BaseActivity {
	private TextView mTvResult;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_params_request);

		mTvResult = (TextView) findViewById(R.id.tv_result);

		Button btnRequest = (Button) findViewById(R.id.btn_params_request);
		btnRequest.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				executeRequest(new StringRequest(Method.POST, VolleyApi.POST_TEST, responseListener(),
						errorListener()) {
					protected Map<String, String> getParams() {
						return new ApiParams().with("param1", "02").with("param2", "14");
					}
				});
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
