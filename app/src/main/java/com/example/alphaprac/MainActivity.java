package com.example.alphaprac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.LauncherActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    ListView list;

    ArrayAdapter<String> adapter;//used to place data on list
    String[] alphabets={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P"
            ,"Q","R","S","T","U","V","W","X","Y","Z"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=(ListView) findViewById(R.id.alphaList);
        adapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_dropdown_item_1line,alphabets);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),secondPage.class);
                intent.putExtra("alphabet",alphabets[i]);
                startActivity(intent);
            }
        });
    }
}



