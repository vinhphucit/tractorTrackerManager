package com.landsoft.tractortracker.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.landsoft.tractortracker.R;
import com.landsoft.tractortracker.widget.WaitingDialog;

public abstract class BaseActivity extends Activity {

	private WaitingDialog waitingdialog;
	@Override
	protected void onCreate(Bundle bundle) {

		getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
				WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
		super.onCreate(bundle);
	}
	
    @Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		dismissWaitingDialog();
	}

    public final void showWaitingDialog(){
    	waitingdialog=new WaitingDialog(this, R.style.PleaseWaitDialog, null);
    	waitingdialog.show();
    }
    public final void dismissWaitingDialog(){
    	if(waitingdialog!=null){
    		waitingdialog.dismiss();
    	}
    }
	public void startIntent()
    {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
        overridePendingTransition(R.anim.splashscreen_fade_in, R.anim.splashscreen_fade_out);
    }
}
