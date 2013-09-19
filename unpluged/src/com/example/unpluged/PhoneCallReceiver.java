package com.example.unpluged;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import com.example.unpluged.utils.SoundUtils;

/**
 * Sample of BroadcastReceiver, every time the phone get a phone this Receiver
 * should be called. It'll just log a message but It could save info in a
 * database, to a file, somewhere on the cloud...
 * 
 * @author Pello Xabier Altadill Izura
 * @greetz Rem�rez
 */
public class PhoneCallReceiver extends BroadcastReceiver {

	/**
	 * default constructor
	 */
	public PhoneCallReceiver() {
		Log.d("PELLODEBUG", "BR> Instance creaed");
	}

	/**
	 * this handler will be fired when w receive an Intent for us
	 */
	@Override
	public void onReceive(Context context, Intent intent) {
		Bundle intentExtras = intent.getExtras();

		// is intent a REBOOT?
		if (intent.getAction().equals(Intent.ACTION_REBOOT)) {
			Log.d("PELLODEBUG", "BR> Received intent: system rebooted");
		}

		// or maybe a headphone plug/unplug?
		if (intent.getAction().equals("android.intent.action.HEADSET_PLUG")) {

			if (intent.getAction().equals(Intent.ACTION_HEADSET_PLUG)) {
				int state = intent.getIntExtra("state", -1);
				switch (state) {
				case 0:
					SoundUtils.playSound(context, SoundUtils.DEFAULT);
					break;
				case 1:
					//SoundUtils.stop();
					Toast toast = Toast.makeText(context,
							"Received intent: headsetPlugged", 10);
					toast.show();
					break;
				default:
					toast = Toast.makeText(context,
							"I have no idea what the headset state is", 10);
					toast.show();

				}
			}

		}

		// or maybe phone is ringing?
		if (intent.getAction().equals("android.intent.action.PHONE_STATE")) {
			Log.d("PELLODEBUG", "BR> Received intent: RING RING!!");
			// Now we extract number from intent extras

			if (null != intentExtras) {
				String state = intentExtras
						.getString(TelephonyManager.EXTRA_STATE);
				if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
					String callingNumber = intentExtras
							.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);

					saveInformation("BR> Call received: " + state + " ,"
							+ callingNumber);
				}
			}
		}

		Log.d("PELLODEBUG", "BR> Received intent: " + intent.getAction());

	}

	/**
	 * method called from onReceive to store information
	 * 
	 * @param info
	 * @return
	 */
	private boolean saveInformation(String info) {
		Log.d("PELLODEBUG", "BR> saving info: " + info);
		return true;
	}

}