package com.example.binusezyfoody;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class OrderAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private  String[] item;
    private String[] price_view;
    private String[] qty;
    private int[] images_view;
    private int total = 0;
    public OrderAdapter(Context c,String[] item, String[] price_view,String[]qty,int[]images){
        context = c;
        this.item=item;
        this.price_view = price_view;
        this.qty=qty;
        this.images_view=images;
    }
    @Override
    public int getCount() {
        return item.length;
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
            convertView = inflater.inflate(R.layout.myorder_list, null);
        }
        TextView itemView = convertView.findViewById(R.id.itemName);
        TextView priceView = convertView.findViewById(R.id.itemPrice);
        TextView quantityView = convertView.findViewById(R.id.qty);
        ImageView imageView = convertView.findViewById(R.id.image_view);

        itemView.setText(item[position]);
        priceView.setText(price_view[position]);
        quantityView.setText(qty[position]);
        imageView.setImageResource(images_view[position]);

        return convertView;
    }
}

//package com.example.binusezyfoody;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//
////
//public class OrderAdapter{
//    private static final int ROW_ITEMS = 3;
//
//    private static final class GridAdapter extends BaseAdapter {
//
//        final ArrayList<String> mItems;
//        final int mCount;
//
//        /**
//         * Default constructor
//         * @param items to fill data to
//         */
//        private GridAdapter(final ArrayList<String> items) {
//
//            mCount = items.size() * ROW_ITEMS;
//            mItems = new ArrayList<String>(mCount);
//
//            // for small size of items it's ok to do it here, sync way
//            for (String item : items) {
//                // get separate string parts, divided by ,
//                final String[] parts = item.split(",");
//
//                // remove spaces from parts
//                for (String part : parts) {
//                    part.replace(" ", "");
//                    mItems.add(part);
//                }
//            }
//        }
//
//        @Override
//        public int getCount() {
//            return mCount;
//        }
//
//        @Override
//        public Object getItem(final int position) {
//            return mItems.get(position);
//        }
//
//        @Override
//        public long getItemId(final int position) {
//            return position;
//        }
//
//        @Override
//        public View getView(final int position, final View convertView, final ViewGroup parent) {
//
//            View view = convertView;
//
//            if (view == null) {
//                view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
//            }
//
//            final TextView text = (TextView) view.findViewById(android.R.id.text1);
//
//            text.setText(mItems.get(position));
//
//            return view;
//        }
//    }
////
////    private Context context;
////    private LayoutInflater inflater;
////    ArrayList<Cart> list;
////
////    public OrderAdapter(MyOrder myOrder, ArrayList<Cart> cart) {
////        context = myOrder;
////        this.list=cart;
////    }
////
////
////    @Override
////    public int getCount() {
////        return list.size();
////    }
////
////    @Override
////    public Object getItem(int position) {
////        return null;
////    }
////
////    @Override
////    public long getItemId(int position) {
////        return 0;
////    }
////
////    @Override
////    public View getView(int position, View convertView, ViewGroup parent) {
////        if (inflater == null) {
////            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
////
////        }
////        if (convertView == null) {
////            convertView = inflater.inflate(R.layout.myorder_list, null);
////        }
////        ImageView imageView = convertView.findViewById(R.id.image_view);
////        TextView itemView = convertView.findViewById(R.id.itemName);
////        TextView priceView = convertView.findViewById(R.id.itemPrice);
////        itemView.setText(list);
////        priceView.setText("Rp." + price_view[position]);
////
////
////        return convertView;
////    }
//}
