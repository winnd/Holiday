package com.exp.fragment;

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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Page1 extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		View view = inflater.inflate(R.layout.page1, container, false);
		return view;
	}
/*
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);

		ListView page1_lv = (ListView) this.getActivity().findViewById(
				R.id.page1_lv);
		page1_lv.setAdapter(new SimpleAdapter(getActivity(), getData(),
				R.layout.page1item, new String[] { "title","content","pic" },
				new int[] { R.id.page1item_title,R.id.page1item_content,R.id.page1item_pic }));
	}

	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> lists = new ArrayList<Map<String, Object>>();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", "�ҵĵ�һ����Ŀ");
		map.put("content", "��������");
		map.put("pic", R.drawable.ic_launcher);
		lists.add(map);
		
		map = new HashMap<String, Object>();
		map.put("title", "�ҵĵ�һ����Ŀ");
		map.put("content", "��������");
		map.put("pic", R.drawable.ic_launcher);
		lists.add(map);
		
		map = new HashMap<String, Object>();
		map.put("title", "�ҵĵ�һ����Ŀ");
		map.put("content", "��������");
		map.put("pic", R.drawable.ic_launcher);
		lists.add(map);

		return lists;
	}*/
}
