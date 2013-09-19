package com.example.unpluged;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
	
	PhoneCallReceiver myPhoneCallReceiver = new PhoneCallReceiver();
	
   @Override
   public IBinder onBind(Intent arg0) {
      return null;
   }

   @Override
   public int onStartCommand(Intent intent, int flags, int startId) {
     
	   
	   myPhoneCallReceiver = new PhoneCallReceiver();
		IntentFilter myFilter = new IntentFilter();

		intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		startActivity(intent);

		myFilter.addAction("android.intent.action.HEADSET_PLUG");
		myFilter.addAction("android.intent.action.PHONE_STATE");
		myFilter.addAction("android.intent.action.BOOT_COMPLETED");
		myFilter.addAction("android.intent.action.QUICKBOOT_POWERON");

		// We register the receiver...
		// and off we go...
		this.registerReceiver(myPhoneCallReceiver, myFilter);

		Log.d("PELLODEBUG", "Activity> receiver registered");
	   
	   
      Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
      return START_STICKY;
   }
   @Override
   public void onDestroy() {
      super.onDestroy();
      
      Log.d("PELLODEBUG", "MainActivity> unregistering Receiver");
		if (null != myPhoneCallReceiver)
			//Log.d("PELLODEBUG", "MainActivity> unregistering Receiver");
			this.unregisterReceiver(myPhoneCallReceiver);
		else
			Log.d("PELLODEBUG", "MainActivity> is null already");
      
      Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
   }
}