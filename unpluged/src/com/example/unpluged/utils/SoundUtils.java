package com.example.unpluged.utils;

import java.io.IOException;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.widget.Toast;

public class SoundUtils {

	private static final String PATH_SOUND = "sounds/";
	public static final String DEFAULT = "default.mp3";
	private static MediaPlayer mp;
	private static Context context;

	public static void playSound(Context context, String soud) {
		mp = new MediaPlayer();
		try {
			AssetFileDescriptor descriptor = context.getAssets().openFd(
					PATH_SOUND + soud);
			mp.setDataSource(descriptor.getFileDescriptor(),
					descriptor.getStartOffset(), descriptor.getLength());
			descriptor.close();
			mp.prepare();
			mp.setLooping(false);
			mp.start();
			mp.setVolume(9, 9);
			SoundUtils.context = context;
		} catch (IOException e) {
			Toast toast = Toast.makeText(context, e.toString(), 30);
			toast.show();
		}
	}

	public static void stop() {
		try {
			mp.stop();
		} catch (Exception e) {
			Toast toast = Toast.makeText(context, e.toString(), 30);
			toast.show();
		}
	}

}
