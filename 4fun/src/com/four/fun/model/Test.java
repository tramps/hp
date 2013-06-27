package com.four.fun.model;

import com.four.fun.json.JSONBean;

public class Test implements JSONBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1918360427515034783L;
	private String mProduct_name;
	private String mcreate_time;
	
	public String getProduct_name() {
		return mProduct_name;
	}
	public void setProduct_name(String mProduct_name) {
		this.mProduct_name = mProduct_name;
	}
	public String getcreate_time() {
		return mcreate_time;
	}
	public void setcreate_time(String mcreate_time) {
		this.mcreate_time = mcreate_time;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("product_name").append(":").append(mProduct_name);
		sb.append("create_time").append(":").append(mcreate_time);
		return sb.toString();
	}
}
