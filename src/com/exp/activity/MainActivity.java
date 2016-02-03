package com.exp.activity;

import com.eple.holiday.R;
import com.exp.pageFragment.*;

import android.R.integer;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
	LinearLayout btn1_bottom ;
	LinearLayout btn2_bottom ;
	LinearLayout btn3_bottom ;
	LinearLayout btn4_bottom ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		FragmentManager fm = this.getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		Page1 page1 = new Page1();
		ft.replace(R.id.main_content, page1);
		ft.commit();
		
	}

	public void findId(View view){			//自定义函数 将所有Id一次性找齐
		btn1_bottom = (LinearLayout)findViewById(R.id.bottom_click1);
		btn2_bottom = (LinearLayout)findViewById(R.id.bottom_click1);
		btn3_bottom = (LinearLayout)findViewById(R.id.bottom_click1);
		btn4_bottom = (LinearLayout)findViewById(R.id.bottom_click1);	//主页btn_bottom
	}
	
	public void btn_bottom_click(View view){
		FragmentManager fm = this.getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		
		switch (view.getId()) {
		case R.id.bottom_click1:
			Page1 page1 = new Page1();
			ft.replace(R.id.main_content, page1);
			ft.commit();
			break;
		case R.id.bottom_click2:
			Page2 page2 = new Page2();
			ft.replace(R.id.main_content, page2);
			ft.commit();
			break;
		case R.id.bottom_click3:
			Page3 page3 = new Page3();
			ft.replace(R.id.main_content, page3);
			ft.commit();
			break;
		case R.id.bottom_click4:
			Page4 page4 = new Page4();
			ft.replace(R.id.main_content, page4);
			ft.commit();
			break;
		}
	}
}