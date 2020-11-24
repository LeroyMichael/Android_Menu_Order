package com.example.binusezyfoody;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Cart> order= new ArrayList<Cart>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public ArrayList<Cart> getOrder(){
        if(getIntent().getExtras() != null) {
            return (ArrayList<Cart>) getIntent().getSerializableExtra("order");
        }
        return order;
    }
    public void myOrder(View view) {
        order = getOrder();
        Intent intent = new Intent(MainActivity.this, MyOrder.class);
        intent.putExtra("order", order);
        MainActivity.this.startActivity(intent);
    }

    public void orderDrinks(View view) {
        order = getOrder();
        Intent intent = new Intent(MainActivity.this, Menu.class);
        intent.putExtra("order", order);
        intent.putExtra("identifier",1);
        startActivity(intent);
    }

    public void orderSnacks(View view) {
        order = getOrder();
        Intent intent = new Intent(MainActivity.this, Menu.class);
        intent.putExtra("order", order);
        intent.putExtra("identifier",3);
        startActivity(intent);
    }

    public void orderFoods(View view) {
        order = getOrder();
        Intent intent = new Intent(MainActivity.this, Menu.class);
        intent.putExtra("order", order);
        intent.putExtra("identifier",2);
        startActivity(intent);
    }

    public void topUp(View view) {
        Intent intent = new Intent(MainActivity.this, TopUp.class);
        MainActivity.this.startActivity(intent);
    }
}