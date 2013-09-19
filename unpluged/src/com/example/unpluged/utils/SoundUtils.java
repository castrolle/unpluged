package com.example.unpluged.utils;

import java.io.IOException;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

public class SoundUtils {

	private static final String PATH_SOUND = "sounds/";
	public static final String DEFAULT = "default.mp3";
	private static MediaPlayer mp;
	
	public static void playSound(Context context, String soud) {
		mp = new MediaPlayer();
		try {
			AssetFileDescriptor descriptor = context.getAssets().openFd(
					PATH_SOUND + soud);
			mp.setDataSource(descriptor.getFileDescriptor(),
					descriptor.getStartOffset(), descriptor.getLength());
			descriptor.close();
			mp.prepare();
			mp.setLooping(true);
			mp.start();
			mp.setVolume(3, 3);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void stop(){
		mp.stop();
	}

}
