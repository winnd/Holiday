package com.exp.activity;

import com.eple.holiday.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class Page1_itemDetailPage extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.page1itemdetailpage);
	}
	
	public void out(View view){
		this.finish();
	}
}
