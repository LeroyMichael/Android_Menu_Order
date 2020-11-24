package com.example.binusezyfoody;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {
    GridView gridView;
    String[] drinks = {
            "Air Mineral", "Jus Apel", "Jus Alpukat", "Jus Mangga",
            "Jus Jeruk"
    };
    //drinks
   int[] drinks_images = {
            R.drawable.drink_1,R.drawable.drink_2,R.drawable.drink_3,
            R.drawable.drink_4,R.drawable.drink_5
    };
   String[] price_view ={
           "5000","15000","20000","25000","25000"
   };
   //foods
   String[] foods ={
           "Salad", "Fried Shrimp","Rice Vege","Burger","Pizza"
   };
   int[] foods_images = {
           R.drawable.food_1,R.drawable.food_2,R.drawable.food_3,
           R.drawable.food_4,R.drawable.food_5
   };
   String[] food_price = {
           "50000","40000","30000","25000","60000"
   };
   //snacks
   String[] snacks ={
           "Doughnut","Chips","French Fries","Ice Cream","Biscuit"
   };
    int[] snacks_images = {
            R.drawable.snacks_1,R.drawable.snacks_2,R.drawable.snacks_3,
            R.drawable.snacks_4,R.drawable.snacks_5
    };
    String[] snacks_price = {
            "10000","5000","10000","5000","5000"
    };

    int ident;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_drinks);
        //receive data from main
        Intent data = getIntent();
        int identifier = data.getIntExtra("identifier",1);
        gridView = findViewById(R.id.drinks_list);

        //Set View
        TextView header = findViewById(R.id.header_text);

        switch(identifier){
            case 1:
                MainAdapter setDrinks = new MainAdapter(Menu.this,drinks,drinks_images,price_view);
                gridView.setAdapter(setDrinks);
                header.setText("DRINKS");
                ident =1;
                break;
            case 2:
                MainAdapter setFoods = new MainAdapter(Menu.this,foods,foods_images,food_price);
                gridView.setAdapter(setFoods);
                header.setText("FOODS");
                ident =2;
                break;
            case 3:
                MainAdapter setSnacks = new MainAdapter(Menu.this,snacks,snacks_images,snacks_price);
                gridView.setAdapter(setSnacks);
                header.setText("SNACKS");
                ident =3;
                break;
            default:
                break;
        }

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView selectedPrice = (TextView) view.findViewById(R.id.price_view);
                String price = selectedPrice.getText().toString();

                TextView selectedItem = (TextView) view.findViewById(R.id.text_view);
                String item = selectedItem.getText().toString();

                Intent order = new Intent(Menu.this, Order.class);

                order.putExtra("price",price);
                order.putExtra("item",item);
                order.putExtra("identifier",ident);
                startActivity(order);


            }
        });
    }

    public void myOrder(View view) {
        Intent intent = new Intent(Menu.this, MyOrder.class);
        Menu.this.startActivity(intent);
    }
}