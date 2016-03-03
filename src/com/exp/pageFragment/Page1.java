package com.exp.pageFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eple.holiday.R;
import com.exp.activity.Page1_itemDetailPage;
import com.exp.activity.Page1_itemDetailPage2;

import android.R.integer;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebView.FindListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class Page1 extends Fragment {

	private View view;
	private ListView homePage1_lv;
	private WebView wv;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.page1, container, false);

//		Button btn = (Button) view.findViewById(R.id.callcar_submitpage_catchbtn);
		homePage1_lv = (ListView) view.findViewById(R.id.homepage1_lv);
		homePage1_lv.setDividerHeight(0);
		homePage1_lv.setAdapter(new SimpleAdapter(getActivity(), getData(),
				R.layout.page1item, new String[] { "date", "startPoint", "pic",
						"askcar", "cartype1", "cartype2" }, new int[] {
						R.id.page1item_date, R.id.page1item_from,
						R.id.page1item_pic, R.id.page1item_askcar,
						R.id.page1item_cartype1, R.id.page1item_cartype2 }));
		msetListViewHeightBasedOnChildren(homePage1_lv);

		wv = (WebView) view.findViewById(R.id.wv);
		wv.loadUrl("file:///android_asset/www/ad.html");

		WebSettings settings = wv.getSettings();
		settings.setJavaScriptEnabled(true);

		return view;
	}

	
	
	
	
	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> lists = new ArrayList<Map<String, Object>>();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("date", "1月1日");
		map.put("startPoint", "北京");
		map.put("pic", R.drawable.ic_launcher);
		map.put("askcar", "求车");
		map.put("cartype1", "大面包车");
		map.put("cartype2", "小面包车");
		lists.add(map);

		map = new HashMap<String, Object>();
		map.put("date", "1月1日");
		map.put("startPoint", "上海");
		map.put("pic", R.drawable.ic_launcher);
		map.put("askcar", "拼车");
		map.put("cartype1", "小面包车");
		map.put("cartype2", "小面包车");
		lists.add(map);

		map = new HashMap<String, Object>();
		map.put("date", "1月1日");
		map.put("startPoint", "广州");
		map.put("pic", R.drawable.ic_launcher);
		map.put("askcar", "回头车");
		map.put("cartype1", "大卡车");
		map.put("cartype2", "小卡车");
		lists.add(map);

		map = new HashMap<String, Object>();
		map.put("date", "1月1日");
		map.put("startPoint", "深圳");
		map.put("pic", R.drawable.ic_launcher);
		map.put("askcar", "拼车");
		map.put("cartype1", "小卡车");
		map.put("cartype2", "小卡车");
		lists.add(map);
		map = new HashMap<String, Object>();
		map.put("date", "1月1日");
		map.put("startPoint", "重庆");
		map.put("pic", R.drawable.ic_launcher);
		map.put("askcar", "拼车");
		map.put("cartype1", "大客车");
		map.put("cartype2", "小客车");
		lists.add(map);
		map = new HashMap<String, Object>();
		map.put("date", "12月12日");
		map.put("startPoint", "大连");
		map.put("pic", R.drawable.ic_launcher);
		map.put("askcar", "拼车");
		map.put("cartype1", "小客车");
		map.put("cartype2", "小客车");
		lists.add(map);
		map = new HashMap<String, Object>();
		map.put("date", "12月12日");
		map.put("startPoint", "厦门");
		map.put("pic", R.drawable.ic_launcher);
		map.put("askcar", "拼车");
		map.put("cartype1", "大面包车");
		map.put("cartype2", "小面包车");
		lists.add(map);
		map = new HashMap<String, Object>();
		map.put("date", "1月1日");
		map.put("startPoint", "胡建");
		map.put("pic", R.drawable.ic_launcher);
		map.put("askcar", "拼车");
		map.put("cartype1", "大面包车");
		map.put("cartype2", "小面包车");
		lists.add(map);

		return lists;
	}

@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onActivityCreated(savedInstanceState);
		homePage1_lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(Page1.this.getActivity(),
						Page1_itemDetailPage2.class);
				startActivity(intent);
			}
		});
	}

	// scrollview嵌套listview
	public void msetListViewHeightBasedOnChildren(ListView listView) {
		// 获取ListView对应的Adapter
		ListAdapter listAdapter = listView.getAdapter();
		if (listAdapter == null) {
			return;
		}

		int totalHeight = 0;
		int len = listAdapter.getCount();
		for (int i = 0; i < len; i++) {
			// listAdapter.getCount()返回数据项的数目
			View listItem = listAdapter.getView(i, null, listView);
			// 计算子项View 的宽高
			listItem.measure(0, 0);
			// 统计所有子项的总高度
			totalHeight += listItem.getMeasuredHeight();
		}

		ViewGroup.LayoutParams params = listView.getLayoutParams();
		params.height = totalHeight
				+ (listView.getDividerHeight() * (listAdapter.getCount() - 1));
		// listView.getDividerHeight()获取子项间分隔符占用的高度
		// params.height最后得到整个ListView完整显示需要的高度
		listView.setLayoutParams(params);
	}

}
