package com.example.unpluged.utils;

import java.io.IOException;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

public class SoundUtils {

	private static final String PATH_SOUND = "sounds/";
	public static final String DEFAULT = "default.mp3";

	private static MediaPlayer mp;

	private static void init(Context context, String soud) {

		try {

			mp = new MediaPlayer();

			AssetFileDescriptor descriptor = context.getAssets().openFd(
					PATH_SOUND + soud);
			mp.setDataSource(descriptor.getFileDescriptor(),
					descriptor.getStartOffset(), descriptor.getLength());
			descriptor.close();
			mp.prepare();
			mp.setLooping(true);
			mp.setVolume(1.0F, 1.0F);
		} catch (IOException e) {
			// Toast toast = Toast.makeText(context, e.toString(), 30);
			// toast.show();
		}
	}

	public static void playSound(Context context, String soud) {

		stop(context);
		init(context, soud);
		mp.start();
	}

	public static void stop(Context context) {
		try {

			if (mp != null && mp.isPlaying()) {
				mp.stop();
				mp.release();
			}
			mp = null;
		} catch (Exception e) {
//			Toast toast = Toast.makeText(context, e.toString(), 30);
//			toast.show();
		}
	}

}
