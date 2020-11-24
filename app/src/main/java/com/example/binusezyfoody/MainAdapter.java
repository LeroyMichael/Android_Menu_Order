package com.example.binusezyfoody;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class MainAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private int[] drinks_images;
    private  String[] drinks;
    private String[] price_view;
    private int total;
    public MainAdapter(Context c,String[] drinks,int[] drinks_images, String[] price_view){
        context = c;
        this.drinks_images = drinks_images;
        this.drinks = drinks;
        this.price_view = price_view;

    }
    @Override
    public int getCount() {
        return drinks.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }
        if(convertView == null){
            convertView = inflater.inflate(R.layout.row_item, null);
        }
        ImageView imageView = convertView.findViewById(R.id.image_view);
        TextView itemView = convertView.findViewById(R.id.text_view);
        TextView priceView = convertView.findViewById(R.id.price_view);
        imageView.setImageResource(drinks_images[position]);
        itemView.setText(drinks[position]);
        priceView.setText("Rp."+price_view[position]);




        return convertView;
    }
}
