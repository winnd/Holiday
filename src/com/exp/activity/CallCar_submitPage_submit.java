package com.exp.activity;

import java.util.zip.Inflater;

import com.eple.holiday.R;
import com.exp.pageFragment.Page1;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class CallCar_submitPage_submit extends Activity {
	Button Btn;
	Page1 page1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.page5_submitsubmit);
		findId();
	}

	private void findId() {
		Btn = (Button) findViewById(R.id.callCar_submitPage_submitBtn);
	}

	public void callCar_submitPageClick(View view){
		Intent intent = new Intent(this,MainActivity.class);
		startActivity(intent);
		this.finish();
	}
}
