package com.example.junior.volleyapp.adater;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.junior.volleyapp.R;
import com.example.junior.volleyapp.model.Movie;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
	private Activity activity;
	private LayoutInflater inflater;
	private List<Movie> movieItems;
	private ImageButton btnVer;
	//ImageLoader imageLoader = AppController.getInstance().getImageLoader();



	public CustomListAdapter(Activity activity, List<Movie> movieItems) {
		this.activity = activity;
		this.movieItems = movieItems;


	}


	@Override
	public int getCount() {
		return movieItems.size();
	}

	@Override
	public Object getItem(int location) {
		return movieItems.get(location);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (inflater == null)
			inflater = (LayoutInflater) activity
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		if (convertView == null)
			convertView = inflater.inflate(R.layout.list_row, null);
		/*
		if (imageLoader == null)
			imageLoader = AppController.getInstance().getImageLoader();
		NetworkImageView thumbNail = (NetworkImageView) convertView
				.findViewById(R.id.thumbnail);
		*/
		TextView idp = (TextView) convertView.findViewById(R.id.row_idp);
		TextView desc = (TextView) convertView.findViewById(R.id.row_desc);
		TextView produto = (TextView) convertView.findViewById(R.id.row_produto);
		TextView nnotas = (TextView) convertView.findViewById(R.id.row_nnotas);
		TextView data = (TextView) convertView.findViewById(R.id.row_data);


		// getting movie data for the row
		Movie m = movieItems.get(position);

		// thumbnail image
		/*
		thumbNail.setImageUrl(m.getThumbnailUrl(), imageLoader);
		*/
		// title

		idp.setText(m.getIdp());
		
		// rating
		desc.setText(m.getDesc());
		
		// genre
		produto.setText(m.getProduto());
		
		// release year
		nnotas.setText(m.getNnotas());
		//tag
		data.setText(m.getData());

		return convertView;
	}




}