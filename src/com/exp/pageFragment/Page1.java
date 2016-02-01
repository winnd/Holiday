package com.exp.pageFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eple.holiday.R;

import com.exp.java.Item_page1;

import android.R.integer;
import android.app.Fragment;
import android.app.DownloadManager.Request;
import android.content.ClipData.Item;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Page1 extends Fragment {

	private View view;
	private ListView page1_lv;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		view = inflater.inflate(R.layout.page1, container, false);
		page1_lv = (ListView) view.findViewById(R.id.page1_lv);
		page1_lv.setAdapter(new SimpleAdapter(getActivity(), getData(),R.layout.page1item, 
				new String[] { "title", "content", "pic" },
				new int[] { R.id.page1item_title, R.id.page1item_content,R.id.page1item_pic }));
		return view;
	}

	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> lists = new ArrayList<Map<String, Object>>();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", "我的第一个条目");
		map.put("content", "这是描述");
		map.put("pic", R.drawable.ic_launcher);
		lists.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "我的第二个条目");
		map.put("content", "这是描述");
		map.put("pic", R.drawable.ic_launcher);
		lists.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "我的第三个条目");
		map.put("content", "这是描述");
		map.put("pic", R.drawable.ic_launcher);
		lists.add(map);

		return lists;
	}
}
