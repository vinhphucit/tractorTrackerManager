package com.landsoft.tractortracker.activity;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.landsoft.tractortracker.R;

public abstract class BaseDialogActivity extends BaseActivity {
	protected ViewGroup contentwrapper;
	private TextView titletextview;
	private RelativeLayout dialogwrapper;
	private ImageView closeimage;

	public BaseDialogActivity() {
	}

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.custom_popup_dialog);
		init();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	private void init() {
		dialogwrapper = (RelativeLayout) findViewById(R.id.custom_dialog_wrapper);
		titletextview = (TextView) findViewById(R.id.custom_dialog_title);
		contentwrapper = (ViewGroup) findViewById(R.id.custom_dialog_content_wrapper);
		findViewById(R.id.custom_dialog_close_image).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						finish();
					}
				});
	}

	protected final void addContentView(View view) {
		addContentView(view, new Rect());
	}

	protected final void addContentView(View view, int padding) {
		addContentView(view, new Rect(padding, padding, padding, padding));

	}

	protected final void addContentView(View view, Rect rect) {
		contentwrapper.removeAllViews();
		contentwrapper.setPadding(rect.left, rect.top, rect.right, rect.bottom);
		contentwrapper.addView(view);
		contentwrapper.setVisibility(View.VISIBLE);
	}

	protected final void setDialogTitle(int titleId) {
		titletextview.setText(titleId);
		titletextview.setVisibility(View.VISIBLE);
	}
}
