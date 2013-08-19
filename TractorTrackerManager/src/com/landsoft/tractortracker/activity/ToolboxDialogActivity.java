package com.landsoft.tractortracker.activity;

import com.landsoft.tractortracker.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

public class ToolboxDialogActivity extends BaseDialogActivity {

	public ToolboxDialogActivity() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setDialogTitle(R.string.toolbox_title);
		RelativeLayout relativelayout = (RelativeLayout) ((LayoutInflater) getSystemService("layout_inflater"))
				.inflate(R.layout.wrapper_toolbox_content, null);
		addContentView(relativelayout);
	}
}
