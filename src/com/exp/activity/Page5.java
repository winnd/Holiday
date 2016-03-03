package com.exp.activity;

import com.eple.holiday.R;
import com.exp.pageFragment.Page5_publish1;
import com.exp.pageFragment.Page5_publish2;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class Page5 extends Activity {
	Page5_publish1 page5_publish1;
	Page5_publish2 page5_publish2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.page5_submit);

		FragmentManager fm = this.getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		if (page5_publish1 == null) {
			page5_publish1 = new Page5_publish1();
			ft.replace(R.id.page5_submit_fml, page5_publish1);
			ft.commit();
		}
	}
	
	public void page5_click(View view){
		FragmentManager fm = this.getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		
		switch (view.getId()) {
		case R.id.page5_next_btn:
			if(page5_publish2 == null)
				page5_publish2 = new Page5_publish2();
			ft.replace(R.id.page5_submit_fml, page5_publish2);
			ft.commit();
			break;
		case R.id.page5_submit_btn:
			Intent intent = new Intent(Page5.this,CallCar_submitPage_submit.class);
			startActivity(intent);
			finish();
			break;
		}
	}
}
