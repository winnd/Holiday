package com.exp.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.R;
import android.R.integer;
import android.R.layout;
import android.net.LocalSocketAddress.Namespace;
import android.widget.Adapter;
import android.widget.SimpleAdapter;

public class Item_page1 {
	private int pic;
	private String title;
	private String commit;

	public int getPic() {
		return pic;
	}

	public void setPic(int pic) {
		this.pic = pic;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCommit() {
		return commit;
	}

	public void setCommit(String commit) {
		this.commit = commit;
	}

}
