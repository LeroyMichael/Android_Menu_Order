package com.example.binusezyfoody;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MyOrder extends AppCompatActivity {
    GridView gridView;
    ArrayList<Cart> order;

    ArrayList<Cart> pass;
    int[] images = { R.drawable.drink_1,R.drawable.drink_2,R.drawable.drink_3,R.drawable.drink_4,R.drawable.drink_5,
            R.drawable.food_1,R.drawable.food_2,R.drawable.food_3, R.drawable.food_4,R.drawable.food_5,
            R.drawable.snacks_1,R.drawable.snacks_2,R.drawable.snacks_3,R.drawable.snacks_4,R.drawable.snacks_5
    };
    String[] itemName = {
            "Air Mineral", "Jus Apel", "Jus Alpukat", "Jus Mangga","Jus Jeruk",
            "Salad", "Fried Shrimp","Rice Vege","Burger","Pizza",
            "Doughnut","Chips","French Fries","Ice Cream","Biscuit"
    };
    int total;
    public ArrayList<Cart> getOrder(){
        if(getIntent().getExtras() != null) {
            return (ArrayList<Cart>) getIntent().getSerializableExtra("order");
        }
        return order;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        gridView = findViewById(R.id.list_order);


        if(getIntent().getExtras() != null) {
            order = getOrder();
            String[] price = new String[order.size()];
            String[] name = new String[order.size()];
            String[] qty = new String[order.size()];
            int[] imageList = new int[order.size()];
            //getprice
            for(int i=0; i<order.size();i++){
                price[i]=order.get(i).getItemPrice();
            }
            //getname
            for(int i=0; i<order.size();i++){
                name[i]=order.get(i).getItemName();
            }
            //getqty
            for(int i=0; i<order.size();i++){
                qty[i]=order.get(i).getQty();
            }
            //image
            int[] match = new int[name.length];
            int flag=0;
            for(int i=0; i < name.length;i++){
                for(int j=0; j < itemName.length;j++){
                    if(name[i].equals(itemName[j])){
                        match[flag]=j;
                        flag++;
                    }
                }
            }
            for(int i = 0;i<match.length;i++){
                imageList[i] = images[match[i]];
            }

            //total
            total =0;
            TextView totalView = findViewById(R.id.total_sum);
            for (int i =0;i<price.length;i++){
                total += parseStringToInt(price[i])* Integer.parseInt(qty[i]);
            }
            totalView.setText("Rp."+String.valueOf(total));

            OrderAdapter order = new OrderAdapter(MyOrder.this,name,price,qty,imageList);

            gridView.setAdapter(order);


        }
    }

    public static int parseStringToInt(String s){
        s = s.replaceAll("Rp.", "");
        return (int)Math.round(Double.parseDouble(s));
    }

    public void payNow(View view) {
        if(getIntent().getExtras() != null) {
            order = getOrder();
            Intent intent = new Intent(MyOrder.this, order_complete.class);
            intent.putExtra("order", order);
            MyOrder.this.startActivity(intent);
        }
    }
}


