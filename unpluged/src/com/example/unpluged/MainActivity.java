package com.example.unpluged;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.example.unpluged.utils.SoundUtils;

/**
 * MainActivity that simply register a BroadcastReceiver. It's important to
 * unregister on Stop event or we will get an Exception.
 * 
 * @author Pello Xabier Altadill Izura
 * @greetz For those who dare to mix Android and Threads
 */
public class MainActivity extends Activity implements OnSeekBarChangeListener {

	private SeekBar mediaVlmSeekBar = null;
	private AudioManager audioManager = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		setContentView(R.layout.dashboard_layout);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		this.setVolumeControlStream(AudioManager.STREAM_MUSIC);

		initControls();
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void initControls() {
		// Return the handle to a system-level service - 'AUDIO'.
		audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

		// Find the seekbar 1
		mediaVlmSeekBar = (SeekBar) findViewById(R.id.seekBar1);
		// Set the max range(Volume in this case) of seekbar
		// for Media player volume
		mediaVlmSeekBar.setMax(audioManager
				.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
		// Set the progress with current Media Volume
		mediaVlmSeekBar.setProgress(audioManager
				.getStreamVolume(AudioManager.STREAM_MUSIC));

		try {
			// Listener to receive changes to the SeekBar1's progress level
			mediaVlmSeekBar
					.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
						public void onStopTrackingTouch(SeekBar arg0) {
						}

						public void onStartTrackingTouch(SeekBar arg0) {
						}

						// When progress level of seekbar1 is changed
						public void onProgressChanged(SeekBar arg0,
								int progress, boolean arg2) {
							audioManager.setStreamVolume(
									AudioManager.STREAM_MUSIC, progress, 0);
						}
					});

		} catch (Exception e) {
			e.printStackTrace();
		}
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
		Button btnStopService = (Button) findViewById(R.id.btnStopService);
		btnStopService.setVisibility(Button.VISIBLE);

		Button btnStartService = (Button) findViewById(R.id.btnStartService);
		btnStartService.setVisibility(Button.INVISIBLE);

		startService(new Intent(this, MyService.class));
	}

	// Method to stop the service
	public void stopService(View view) {
		Button btnStopService = (Button) findViewById(R.id.btnStopService);
		btnStopService.setVisibility(Button.INVISIBLE);

		Button btnStartService = (Button) findViewById(R.id.btnStartService);
		btnStartService.setVisibility(Button.VISIBLE);

		stopService(new Intent(this, MyService.class));
	}

	public void stopSound(View view) {
		SoundUtils.stop(this);
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}

}