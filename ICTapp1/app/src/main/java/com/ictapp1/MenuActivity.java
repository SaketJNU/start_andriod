package com.ictapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    String []ar={"ContactList", "DBTest","PreferenceActivity","CounterActivity", "MainActivity"};
    ArrayAdapter<String> ad;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        lv=findViewById(R.id.lv);
        ad=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,ar);
        lv.setAdapter(ad);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        try{
            String s = "com.ictapp1."+ar[position];        // find the relative position of the item into the package
            Class c = Class.forName(s);                    // Converting a string value into a class type
            Intent i = new Intent(this, c);  // Create a new intent
            startActivity(i);                              // Start the newly created intent
        }
        catch (Exception e)
        {
            Toast.makeText(this, "Error"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
