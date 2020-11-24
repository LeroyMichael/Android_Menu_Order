package com.example.binusezyfoody;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TopUp extends AppCompatActivity {
    private String top_up;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);

    }

    public void topUp(View view) {
        EditText topUp = findViewById(R.id.topUp);
        top_up = topUp.getText().toString();
        TextView total_sum = findViewById(R.id.total_sum);
        total_sum.setText(top_up);
    }

    public void menu(View view) {
        Intent intent = new Intent(TopUp.this, MainActivity.class);
        TopUp.this.startActivity(intent);

    }
}