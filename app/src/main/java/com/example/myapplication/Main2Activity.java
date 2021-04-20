package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    EditText complain;
    TextView txt;
    Button next;
    String comlainStr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt = findViewById(R.id.txt);
        complain = findViewById(R.id.complain);
        if(complain.getText().toString().length()!=0)
         comlainStr = complain.getText().toString();

        Intent intent = getIntent();

        txt.setText(intent.getStringExtra("title"));

        next = findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Main2Activity.this,Main3Activity.class);

                startActivity(intent);
            }
        });


    }
}
