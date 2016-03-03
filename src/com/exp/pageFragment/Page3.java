package com.exp.pageFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eple.holiday.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Page3 extends Fragment {
	ListView page3_lv;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		View view = inflater.inflate(R.layout.page3, container,false);
		page3_lv = (ListView)view.findViewById(R.id.page3_lv);
		page3_lv.setAdapter(new SimpleAdapter(getActivity(), getData(), R.layout.page3item,
				new String[]{"data"},
				new int[]{R.id.page3item_lv}));
		return view;
	}

	private List<Map<String, Object>> getData(){
		List<Map<String, Object>> lists = new ArrayList<Map<String, Object>>();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", "请回复");
		lists.add(map);
		
		map = new HashMap<String, Object>();
		map.put("data", "请回复");
		lists.add(map);
		
		map = new HashMap<String, Object>();
		map.put("data", "请回复");
		lists.add(map);
		
		map = new HashMap<String, Object>();
		map.put("data", "请回复");
		lists.add(map);
		
		map = new HashMap<String, Object>();
		map.put("data", "请回复");
		lists.add(map);
		
		return lists;

	}
}
