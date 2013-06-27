package com.four.fun.task;

import android.content.Context;
import android.util.Log;

import com.four.fun.exception.CustomException;
import com.four.fun.exception.ECode;
import com.four.fun.json.JSONBean;
import com.four.fun.util.BaseHttpsManager;
import com.four.fun.util.BaseHttpsManager.RequestParam;

public class HttpTask<T extends JSONBean> extends HandleMessageTask {
	private static final String TAG = "HttpTask";
	private String mUrl;
	private RequestParam mParam;
	private Class<T> mClass;
	
	private T mResult;

	public HttpTask(Context context, String url, Class<T> res) {
		super(context);
		mUrl = url;
		mClass = res;
//		mResult = new ArrayList<T>();
	}
	
	public HttpTask(Context context, RequestParam p, Class<T> res) {
		super(context);
		mParam = p;
		mClass = res;
//		mResult = new ArrayList<T>();
	}

	@Override
	protected Object doInBackground(Void... params) {
		try {
			mResult = mClass.newInstance();
		} catch (Exception e) {
			Log.e(TAG, e.getCause().toString());
		}
		
		if (mUrl != null) {
			try {
				mResult = BaseHttpsManager.processApi(mUrl, mResult.getClass());
			} catch (CustomException e) {
				Log.e(TAG, e.getMessage());
				Log.e(TAG, e.getCause().toString());
				return ECode.FAIL;
			}
		} else if (mParam != null) {
			try {
				mResult = BaseHttpsManager.processApi(mParam, mResult.getClass());
			} catch (CustomException e) {
				Log.e(TAG, e.getMessage());
				return ECode.FAIL;
			}
		}
		
		return ECode.SUCCESS;
	}
	
	public T getResult() {
		return mResult;
	}

}
