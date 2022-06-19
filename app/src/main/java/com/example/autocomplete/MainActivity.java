package com.example.autocomplete;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String[] wojewodztwa = {
            "dolnośląskie",
            "kujawsko-pomorskie",
            "lubelskie",
            "lubuskie",
            "łódzkie",
            "małopolskie",
            "mazowieckie",
            "podkarpackie",
            "podlaskie",
            "pomorskie"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(),
                android.R.layout.simple_dropdown_item_1line, wojewodztwa);

        AutoCompleteTextView textView1 = findViewById(R.id.textView1);
        textView1.setAdapter(adapter);

        MultiAutoCompleteTextView textView2 = findViewById(R.id.textView2);
        textView2.setAdapter(adapter);
        textView2.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        // ListView
        final ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getBaseContext(),
                android.R.layout.simple_list_item_1, wojewodztwa);

        ListView listView = findViewById(R.id.listView);
        // nagłówek
        TextView header = new TextView(this);
        header.setTextSize(25);
        header.setTextColor(Color.parseColor("#975A5A"));
        header.setText("Lista województw");

        listView.addHeaderView(header);
        listView.setAdapter(adapter1);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // klikniety obiekt
                Object listItem = adapterView.getItemAtPosition(i);

                if(listItem != null){
                    Toast.makeText(getBaseContext(), l + ". "+ listItem.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}