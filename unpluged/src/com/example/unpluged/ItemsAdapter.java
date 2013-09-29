package com.example.unpluged;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.unpluged.model.AlarmType;
import com.example.unpluged.model.Item;
import com.example.unpluged.model.Tone;
import com.example.unpluged.model.Vibration;
import com.example.unpluged.model.Volume;

public class ItemsAdapter extends ArrayAdapter<Item> {
	private ArrayList<Item> items;
	private Context context;

	public ItemsAdapter(Context context, int textViewResourceId,
			ArrayList<Item> items) {
		super(context, textViewResourceId, items);
		this.context = context;
		this.items = items;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		Item item = items.get(position);

		return getListItem(v, item);
	}

	private View getListItem(View v, Item item) {

		if (item instanceof Vibration) {
			v = getVibrationItem(v, item);
		} else if (item instanceof Tone) {
			v = getToneItem(v, item);
		} else if (item instanceof AlarmType) {
			v = getAlarmTypeItem(v, item);
		} else if (item instanceof Volume) {
			v = getVolumeItem(v, item);
		}

		return v;
	}

	private View getVolumeItem(View v, Item item) {
		if (v == null) {
			LayoutInflater vi = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.volume_item, null);
		}

		/*if (item != null) {
			TextView username = (TextView) v.findViewById(R.id.username);
			TextView email = (TextView) v.findViewById(R.id.email);

			if (username != null) {
				username.setText(item.getTitle());
			}

			if (email != null) {
				email.setText("Email: " + item.getTitle());
			}
		}*/

		return v;

	}

	private View getAlarmTypeItem(View v, Item item) {
		if (v == null) {
			LayoutInflater vi = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.alarm_type_item, null);
		}

		if (item != null) {
			TextView username = (TextView) v.findViewById(R.id.username);
			TextView email = (TextView) v.findViewById(R.id.email);

			if (username != null) {
				username.setText(item.getTitle());
			}

			if (email != null) {
				email.setText("Email: " + item.getTitle());
			}
		}

		return v;
	}

	private View getToneItem(View v, Item item) {
		if (v == null) {
			LayoutInflater vi = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.tone_item, null);
		}

		if (item != null) {
			TextView username = (TextView) v.findViewById(R.id.username);
			TextView email = (TextView) v.findViewById(R.id.email);

			if (username != null) {
				username.setText(item.getTitle());
			}

			if (email != null) {
				email.setText("Email: " + item.getTitle());
			}
		}

		return v;

	}

	private View getVibrationItem(View v, Item item) {
		if (v == null) {
			LayoutInflater vi = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.vibration_item, null);
		}

		if (item != null) {
			TextView username = (TextView) v.findViewById(R.id.username);
			TextView email = (TextView) v.findViewById(R.id.email);

			if (username != null) {
				username.setText(item.getTitle());
			}

			if (email != null) {
				email.setText("Email: " + item.getTitle());
			}
		}

		return v;

	}
}
