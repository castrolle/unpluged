package com.example.unpluged;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.unpluged.model.Item;

public class ItemsAdapter extends ArrayAdapter<Item> {
		private ArrayList<Item> items;
private Context context;
		public ItemsAdapter(Context context, int textViewResourceId, ArrayList<Item> items) {
			super(context, textViewResourceId, items);
			this.context = context;
			this.items = items;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View v = convertView;
			if (v == null) {
				LayoutInflater vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				v = vi.inflate(R.layout.list_item, null);
			}
			
			Item item = items.get(position);
			if (item != null) {
				TextView username = (TextView) v.findViewById(R.id.username);
				TextView email = (TextView) v.findViewById(R.id.email);

				if (username != null) {
					username.setText(item.getTitle());
				}

				if(email != null) {
					email.setText("Email: " + item.getTitle() );
				}
			}
			return v;
		}
	}
	