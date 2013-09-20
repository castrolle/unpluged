package com.example.unpluged.utils;

import java.io.IOException;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.widget.Toast;

public class SoundUtils {

	private static final String PATH_SOUND = "sounds/";
	public static final String DEFAULT = "default.mp3";

	public static void playSound(MediaPlayer mp, Context context, String soud) {
		
		try {
			AssetFileDescriptor descriptor = context.getAssets().openFd(
					PATH_SOUND + soud);
			mp.setDataSource(descriptor.getFileDescriptor(),
					descriptor.getStartOffset(), descriptor.getLength());
			descriptor.close();
			mp.prepare();
			mp.setLooping(true);
			mp.start();
			mp.setVolume(1.0F, 1.0F);
		} catch (IOException e) {
			Toast toast = Toast.makeText(context, e.toString(), 30);
			toast.show();
		}
	}

	public static void stop(MediaPlayer mp, Context context) {
		try {
			if(mp != null){
				mp.stop();
			}
		} catch (Exception e) {
			Toast toast = Toast.makeText(context, e.toString(), 30);
			toast.show();
		}
	}

}
