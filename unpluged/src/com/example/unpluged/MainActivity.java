package com.example.unpluged;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

/**
 * MainActivity that simply register a BroadcastReceiver. It's important to
 * unregister on Stop event or we will get an Exception.
 * 
 * @author Pello Xabier Altadill Izura
 * @greetz For those who dare to mix Android and Threads
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean moveTaskToBack(boolean nonRoot) {
		return super.moveTaskToBack(nonRoot);
	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	/**
	 * We must override this to avoid Are you missing a call to
	 * unRegisterReceiver() exception
	 * */
	@Override
	protected void onStop() {
		super.onStop();
	}

	// Method to start the service
	public void startService(View view) {
		startService(new Intent(getBaseContext(), MyService.class));
	}

	// Method to stop the service
	public void stopService(View view) {
		stopService(new Intent(getBaseContext(), MyService.class));
	}

}