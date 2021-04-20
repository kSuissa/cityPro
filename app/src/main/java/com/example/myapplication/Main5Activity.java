package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;

public class Main5Activity extends AppCompatActivity {

    TextView post, location;

    private DatabaseReference mDatabase;
// ...


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        post = findViewById(R.id.post);
        location = findViewById(R.id.location);
        Intent intent = getIntent();
        String address = intent.getStringExtra("addrees");
        location.setText(address);
        post.setText("");

        mDatabase = FirebaseDatabase.getInstance().getReference();

    }
}