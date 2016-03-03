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
		map.put("date", "1��1��");
		map.put("startPoint", "����");
		map.put("pic", R.drawable.ic_launcher);
		map.put("askcar", "��");
		map.put("cartype1", "�������");
		map.put("cartype2", "С�����");
		lists.add(map);

		map = new HashMap<String, Object>();
		map.put("date", "1��1��");
		map.put("startPoint", "�Ϻ�");
		map.put("pic", R.drawable.ic_launcher);
		map.put("askcar", "ƴ��");
		map.put("cartype1", "С�����");
		map.put("cartype2", "С�����");
		lists.add(map);

		map = new HashMap<String, Object>();
		map.put("date", "1��1��");
		map.put("startPoint", "����");
		map.put("pic", R.drawable.ic_launcher);
		map.put("askcar", "��ͷ��");
		map.put("cartype1", "�󿨳�");
		map.put("cartype2", "С����");
		lists.add(map);

		map = new HashMap<String, Object>();
		map.put("date", "1��1��");
		map.put("startPoint", "����");
		map.put("pic", R.drawable.ic_launcher);
		map.put("askcar", "ƴ��");
		map.put("cartype1", "С����");
		map.put("cartype2", "С����");
		lists.add(map);
		map = new HashMap<String, Object>();
		map.put("date", "1��1��");
		map.put("startPoint", "����");
		map.put("pic", R.drawable.ic_launcher);
		map.put("askcar", "ƴ��");
		map.put("cartype1", "��ͳ�");
		map.put("cartype2", "С�ͳ�");
		lists.add(map);
		map = new HashMap<String, Object>();
		map.put("date", "12��12��");
		map.put("startPoint", "����");
		map.put("pic", R.drawable.ic_launcher);
		map.put("askcar", "ƴ��");
		map.put("cartype1", "С�ͳ�");
		map.put("cartype2", "С�ͳ�");
		lists.add(map);
		map = new HashMap<String, Object>();
		map.put("date", "12��12��");
		map.put("startPoint", "����");
		map.put("pic", R.drawable.ic_launcher);
		map.put("askcar", "ƴ��");
		map.put("cartype1", "�������");
		map.put("cartype2", "С�����");
		lists.add(map);
		map = new HashMap<String, Object>();
		map.put("date", "1��1��");
		map.put("startPoint", "����");
		map.put("pic", R.drawable.ic_launcher);
		map.put("askcar", "ƴ��");
		map.put("cartype1", "�������");
		map.put("cartype2", "С�����");
		lists.add(map);

		return lists;
	}

@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
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

	// scrollviewǶ��listview
	public void msetListViewHeightBasedOnChildren(ListView listView) {
		// ��ȡListView��Ӧ��Adapter
		ListAdapter listAdapter = listView.getAdapter();
		if (listAdapter == null) {
			return;
		}

		int totalHeight = 0;
		int len = listAdapter.getCount();
		for (int i = 0; i < len; i++) {
			// listAdapter.getCount()�������������Ŀ
			View listItem = listAdapter.getView(i, null, listView);
			// ��������View �Ŀ��
			listItem.measure(0, 0);
			// ͳ������������ܸ߶�
			totalHeight += listItem.getMeasuredHeight();
		}

		ViewGroup.LayoutParams params = listView.getLayoutParams();
		params.height = totalHeight
				+ (listView.getDividerHeight() * (listAdapter.getCount() - 1));
		// listView.getDividerHeight()��ȡ�����ָ���ռ�õĸ߶�
		// params.height���õ�����ListView������ʾ��Ҫ�ĸ߶�
		listView.setLayoutParams(params);
	}

}
