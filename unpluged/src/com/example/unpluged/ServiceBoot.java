package com.example.unpluged;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class ServiceBoot extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();

		Toast.makeText(this, "Servicio creado", Toast.LENGTH_LONG).show();
		Log.d("SERVICEBOOT", "Servicio creado");
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		Toast.makeText(this, "Servicio destruido", Toast.LENGTH_LONG).show();
		Log.d("SERVICEBOOT", "Servicio destruido");
	}
}
