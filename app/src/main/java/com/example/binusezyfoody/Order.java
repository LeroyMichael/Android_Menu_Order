package com.example.binusezyfoody;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Order extends AppCompatActivity {
    int identifier;
    ArrayList<Cart> order = new ArrayList<Cart>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        //Get previous data
        Intent data = getIntent();
        //Assign data
        String price = data.getStringExtra("price");
        String item = data.getStringExtra("item");
        identifier = data.getIntExtra("identifier",1);


        TextView priceView = findViewById(R.id.price);
        priceView.setText(price);

        TextView itemView = findViewById(R.id.item);
        itemView.setText(item);

    }

    public String getQuantity(){
        EditText quantityView = findViewById(R.id.qty);
        return quantityView.getText().toString();
    }
    public String getPrice(){
        TextView priceView = findViewById(R.id.price);
        return priceView.getText().toString();
    }
    public String getItem(){
        TextView itemView = findViewById(R.id.item);
        return itemView.getText().toString();
    }

    private int addItem(){
        if(getQuantity().isEmpty()){
            return 0;
        }else {
            return 1;
        }
    }

// MyOrder Activity
    public void myOrder(View view) {

        int i = addItem();
        if(i==0) {
            Toast.makeText(getApplicationContext(),"Quantity cannot be empty",Toast.LENGTH_SHORT).show();
        }else{
            order.add(new Cart(getItem(), getPrice(), getQuantity()));

            Intent intent = new Intent(Order.this, MyOrder.class);

            intent.putExtra("order", order);

            startActivity(intent);


            Toast.makeText(getApplicationContext(), "Item added to the cart", Toast.LENGTH_SHORT).show();
        }

    }
//MainActivity
    public void order(View view) {
        int i = addItem();
        if(i==0){
            Toast.makeText(getApplicationContext(),"Quantity cannot be empty",Toast.LENGTH_SHORT).show();
        }else{
            order.add(new Cart(getItem(), getPrice(), getQuantity()));

            Intent intent = new Intent(Order.this, MainActivity.class);

            intent.putExtra("order", order);
            startActivity(intent);

            Toast.makeText(getApplicationContext(), "Item added to the cart", Toast.LENGTH_SHORT).show();
        }
    }
}