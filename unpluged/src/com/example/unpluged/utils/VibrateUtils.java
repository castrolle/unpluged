package com.example.unpluged.utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;

public class VibrateUtils {
	
	public static void start(Context context){
		
		NotificationManager nManager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE); 
		Notification n = new Notification();

		// Now we set the vibrate member variable of our Notification
		// After a 100ms delay, vibrate for 200ms then pause for another
		//100ms and then vibrate for 500ms
		n.vibrate = new long[]{3000, 200, 300, 500}; 
		nManager.notify(0, n);
		
	}

}
