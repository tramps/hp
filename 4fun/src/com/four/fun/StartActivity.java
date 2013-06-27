package com.four.fun;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.four.fun.model.Test;
import com.four.fun.task.HandleMessageTask;
import com.four.fun.task.HandleMessageTask.Callback;
import com.four.fun.task.HttpTask;
import com.four.fun.util.BaseHttpsManager;

public class StartActivity extends Activity {
	private TextView tvContent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tvContent = (TextView) findViewById(R.id.tvContent);
		
		BaseHttpsManager.init(this);

		HttpTask task = new HttpTask(this,
				"http://marshal.easymorse.com/wp-content/uploads/2009/10/json_demo3.txt", Test.class);
		task.setCallback(new Callback() {
			
			@Override
			public void onSuccess(HandleMessageTask task, Object t) {
				tvContent.setText(((HttpTask)task).getResult().toString());
			}
			
			@Override
			public void onFail(HandleMessageTask task, Object t) {
				tvContent.setText("fail");
			}
		});
		
		task.execute();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
