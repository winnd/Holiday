package com.exp.pageFragment;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eple.holiday.R;
import com.exp.pageFragment.Page2.MyPagerAdapter;

import android.R.integer;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class Page2 extends Fragment {
	View view;
	private View view1, view2, view3, view4, view5;
	LayoutInflater mInflater;
	private List<String> mTitleList = new ArrayList<String>();// ����ϼ�mTitleList.get(postition)
	private List<View> mViewList = new ArrayList<View>();// ҳ����ͼ�ʺϼ�
	TabLayout mTabLayout;
	ViewPager mViewPager;
	String[] from_,to_;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		view = inflater.inflate(R.layout.page2, container, false);

		mTabLayout = (TabLayout) view.findViewById(R.id.tabs);
		mViewPager = (ViewPager) view.findViewById(R.id.vp_view);

		mInflater = LayoutInflater.from(this.getActivity());

		if (mViewList.size() == 0) {
			// ���ҳ����ͼ��ҳ�������tabѡ�
			from_ = new String[]{"����","�㽭"};
			to_ = new String[]{"����","�㽭"};
			mAddTab(view1, "�ѷ���", 0,mAdd_FromTo_Data(mMake_FromToList(from_), mMake_FromToList(to_)));
			from_ = new String[]{"guangzhou","zhejiang","shengzheng"};
			to_ = new String[]{"guangzhou","zhejiang","shengzheng"};
			mAddTab(view2, "�ѽӵ�", 1,mAdd_FromTo_Data(mMake_FromToList(from_), mMake_FromToList(to_)));
			mAddTab(view3, "��ƴ��", 2,mAdd_FromTo_Data(mMake_FromToList(from_), mMake_FromToList(to_)));
			mAddTab(view4, "���ʹ�", 3,mAdd_FromTo_Data(mMake_FromToList(from_), mMake_FromToList(to_)));
			mAddTab(view5, "�����", 4,mAdd_FromTo_Data(mMake_FromToList(from_), mMake_FromToList(to_)));
			mTabLayout.setTabMode(TabLayout.MODE_FIXED);// ����tabģʽ����ǰΪϵͳĬ��ģʽ
		}
		MyPagerAdapter mAdapter = new MyPagerAdapter(mViewList);
		mViewPager.setAdapter(mAdapter);// ��ViewPager����������
		mTabLayout.setupWithViewPager(mViewPager);// ��TabLayout��ViewPager����������
		mTabLayout.setTabsFromPagerAdapter(mAdapter);// ��Tabs����������

		return view;
	}

	private void mAddTab(View view, String tabName, int position,List<Map<String, Object>> data) {
		view = mInflater.inflate(R.layout.page2_listview, null);
		ListView lview = (ListView) view.findViewById(R.id.page2_lv);
		lview.setDividerHeight(10);
		lview.setAdapter(new SimpleAdapter(getActivity(), data,
				R.layout.page2_listview_item, 
				new String[] { "from", "to" },
				new int[] { R.id.page2_from, R.id.page2_to }));
		mViewList.add(view);
		mTitleList.add(tabName);
		mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(position)));
	}
	private List mMake_FromToList(String[] from_to){		//������ĳɸĳɼ��� ������һ������
		List from= Arrays.asList(from_to);
		return from;
	}
	
	
	
	
	private List<Map<String, Object>> mGetData() {
		List<Map<String, Object>> lists = new ArrayList<Map<String, Object>>();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("from", "�㽭");
		map.put("to", "�㶫");
		lists.add(map);
		
		map = new HashMap<String, Object>();
		map.put("page2_from", "�㽭");
		map.put("page2_to", "�㶫");
		lists.add(map);

		return lists;
	}
	private List<Map<String, Object>> mAdd_FromTo_Data(List<String> from,List<String> to) {
		List<Map<String, Object>> lists = new ArrayList<Map<String, Object>>();
		Map<String, Object> map;
		
		for(int i=0;i<from.size();i++){
			map = new HashMap<String, Object>();
			map.put("from", from.get(i));
			map.put("to", to.get(i));
			lists.add(map);
		}

		return lists;
	}
	
	
	// ViewPager������
	class MyPagerAdapter extends PagerAdapter {
		private List<View> mViewList;

		public MyPagerAdapter(List<View> mViewList) {
			this.mViewList = mViewList;
		}

		@Override
		public int getCount() {
			return mViewList.size();// ҳ����
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == object;// �ٷ��Ƽ�д��
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			container.addView(mViewList.get(position));// ���ҳ��
			return mViewList.get(position);
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView(mViewList.get(position));// ɾ��ҳ��
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return mTitleList.get(position);// ҳ������
		}

	}
}