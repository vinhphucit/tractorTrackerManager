package com.landsoft.tractortracker.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.landsoft.tractortracker.R;

public class WaitingDialog extends Dialog {
	private Activity parentActivity;

	public WaitingDialog(Context context, int theme, String titleWaiting) {
		super(context, theme);

		setContentView(R.layout.please_wait);
		if (titleWaiting != null)
			((TextView) findViewById(R.id.please_wait_text))
					.setText(titleWaiting);
		Animation animation = AnimationUtils.loadAnimation(context,
				R.anim.rotation);
		((ImageView) findViewById(R.id.waiting_circle))
				.startAnimation(animation);
		parentActivity = (Activity) context;
	}

	public static void showWaitingDialog(ViewGroup viewgroup) {
		viewgroup.removeAllViews();
		Context context = viewgroup.getContext();
		View view = ((LayoutInflater) context
				.getSystemService("layout_inflater")).inflate(R.layout.please_wait,
				viewgroup);
		view.findViewById(R.id.waiting_root).setBackgroundColor(
				context.getResources().getColor(0x106000d));
		viewgroup.startAnimation(AnimationUtils.loadAnimation(context,
				R.anim.please_wait_fade_in));
		Animation animation = AnimationUtils.loadAnimation(context, R.anim.rotation);
		ImageView imageview = (ImageView) view.findViewById(R.id.waiting_circle);
		imageview.startAnimation(animation);
	}

	@Override
	public void onBackPressed() {
		if (parentActivity != null)
			parentActivity.onBackPressed();
	}

}
