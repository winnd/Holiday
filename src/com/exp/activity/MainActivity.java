package com.exp.activity;

import com.eple.holiday.R;
import com.eple.holiday.R.id;
import com.exp.data.*;
import com.exp.pageFragment.*;

import android.R.integer;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	LinearLayout btn1_bottom;
	LinearLayout btn2_bottom;
	LinearLayout btn3_bottom;
	LinearLayout btn4_bottom;
	Page1 page1;
	Page3 page3;
	Page2 page2;
	Page4 page4;
	Page5_publish1 page5_submit1;
	Page5_publish2 page5_submit2;
	TextView tv_mainTitle;
	TextView tv_Page1DetailSubmitTitle;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		findId();
		FragmentManager fm = this.getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		if (page1 == null) {
			page1 = new Page1();
			ft.replace(R.id.main_content, page1);
			ft.commit();
		}
	}

	private void findId() { // 自定义函数 将所有Id一次性找齐
		btn1_bottom = (LinearLayout) findViewById(R.id.bottom_click1);
		btn2_bottom = (LinearLayout) findViewById(R.id.bottom_click1);
		btn3_bottom = (LinearLayout) findViewById(R.id.bottom_click1);
		btn4_bottom = (LinearLayout) findViewById(R.id.bottom_click1); // 主页btn_bottom
		tv_mainTitle = (TextView) findViewById(R.id.main_title);
		tv_Page1DetailSubmitTitle = (TextView) findViewById(R.id.page1detailsubmittitle);
		
	}

	public void btn_bottom_click(View view) {
		FragmentManager fm = this.getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();

		switch (view.getId()) {
		case R.id.bottom_click1:
			tv_mainTitle.setText("主页");
			if (page1 == null) {
				page1 = new Page1();
			}
			ft.replace(R.id.main_content, page1);
			ft.commit();
			break;
		case R.id.bottom_click2:
			tv_mainTitle.setText("订单");
			if (page2 == null) {
				page2 = new Page2();
			}
			ft.replace(R.id.main_content, page2);
			ft.commit();
			break;
		case R.id.bottom_click3:
			tv_mainTitle.setText("消息");
			if (page3 == null) {
				page3 = new Page3();
			}
			ft.replace(R.id.main_content, page3);
			ft.commit();
			break;
		case R.id.bottom_click4:
			tv_mainTitle.setText("个人");
			if (page4 == null) {
				page4 = new Page4();
			}
			ft.replace(R.id.main_content, page4);
			ft.commit();
			break;
		case R.id.bottom_click5:
			Intent intent1 = new Intent(MainActivity.this,Page5.class);
			startActivity(intent1);
			finish();
			break;
		}
	}
}