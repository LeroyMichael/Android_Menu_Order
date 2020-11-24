package com.example.binusezyfoody;

import android.app.Application;

import java.io.Serializable;

public class Cart extends Application implements Serializable {
//    ArrayList<Cart> cart;
//    public ArrayList<Cart> getList(){
////        return cart;
////    }
////    public void setList(String itemName, String itemPrice, String qty) {
////        this.cart.add(new Cart(itemName,itemPrice,qty));
////        Toast.makeText(getApplicationContext(), itemName, Toast.LENGTH_SHORT);
////    }

    protected String itemName;
    protected String itemPrice;
    protected String qty;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public Cart(String itemName, String itemPrice, String qty) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.qty = qty;
    }
//    public Cart(Parcel source) {
//        itemName = source.readString();
//        itemPrice = source.readString();
//        qty = source.readString();
//    }
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeString(itemName);
//        dest.writeString(itemPrice);
//        dest.writeString(qty);
//    }
//    public static final Creator<Cart> CREATOR = new Creator<Cart>(){
//        @Override
//        public Cart createFromParcel(Parcel source) {
//            return new Cart(source);
//        }
//
//        @Override
//        public Cart[] newArray(int size) {
//            return new Cart[size];
//        }
//    };
    //
//    public static void setData(ArrayList<String> data) {
//        Cart.data = data;
//    }
//
//
//
//    public static void addItem(String item) {
//        data.add(item);
//    }
//
//    public static List<String> getData() {
//        return data;
//    }
}
