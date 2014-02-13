/*
 * Created by Storm Zhang, Feb 13, 2014.
 */

package me.storm.volley.ui;

import me.storm.volley.R;
import me.storm.volley.data.RequestManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

public class ImageLoadingActivity extends BaseActivity {
	private NetworkImageView mImageView;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_loading);

		mImageView = (NetworkImageView) findViewById(R.id.iv_image);

		Button btnImageLoadingRequest = (Button) findViewById(R.id.btn_image_loading);
		btnImageLoadingRequest.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				ImageLoader imageLoader = RequestManager.getImageLoader();
				mImageView
						.setImageUrl(
								"http://c.hiphotos.baidu.com/image/w%3D1280%3Bcrop%3D0%2C0%2C1280%2C800/sign=2abcf809eb24b899de3c7d3a563626f6/43a7d933c895d143afcf362a71f082025aaf0779.jpg",
								imageLoader);
			}
		});
	}
}
