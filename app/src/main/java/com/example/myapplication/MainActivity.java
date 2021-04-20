package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





       final ListView listView = findViewById(R.id.my_list);

        final  List<Map<String,Object>> data = new ArrayList<>();

        HashMap<String,Object> b1 = new HashMap<>();
        b1.put("flag",R.drawable.dog);
        b1.put("name","פינוי גזם");
        data.add(b1);

        HashMap<String,Object> b2 = new HashMap<>();
        b2.put("flag",R.drawable.dog);
        b2.put("name","פינוי אשפה");
        data.add(b2);

        HashMap<String,Object> b3 = new HashMap<>();
        b3.put("flag",R.drawable.dog);
        b3.put("name","רחוב לא נקי");
        data.add(b3);

        HashMap<String,Object> b4 = new HashMap<>();
        b4.put("flag",R.drawable.dog);
        b4.put("name","צואת כלבים");
        data.add(b4);

        HashMap<String,Object> b5 = new HashMap<>();
        b5.put("flag",R.drawable.dog);
        b5.put("name","פארק מלוכלך");
        data.add(b5);

        HashMap<String,Object> b6 = new HashMap<>();
        b6.put("flag",R.drawable.dog);
        b6.put("name","הדברה/מכרסמים");
        data.add(b6);

        HashMap<String,Object> b7 = new HashMap<>();
        b7.put("flag",R.drawable.dog);
        b7.put("name","פנס רחוב ");
        data.add(b7);



        String[] from = {"flag","name"/*,"is_good"*/};
        int[] to = {R.id.country_flag,R.id.country_name/*,R.id.country_checkbox*/};

        SimpleAdapter simpleAdapter = new SimpleAdapter(MainActivity.this,data,R.layout.cell,from,to);
/*
       adapter to map static data to views defined in an XML file
*/
       listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);


                HashMap<String,Object> temp =   ( HashMap<String,Object>)adapterView.getItemAtPosition(i);
                 String str = temp.get("name").toString();

                intent.putExtra("title",str);

                startActivity(intent);


            }
        });

    }







}


