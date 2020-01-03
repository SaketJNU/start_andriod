package com.ictapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class PreferenceActivity extends AppCompatActivity {

    EditText ed;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);
        ed = findViewById(R.id.editText);
        sp=getSharedPreferences("mypref",MODE_PRIVATE);
        ed.setText(sp.getString("data",""));  // default value of key is an empty string
    }

    @Override
    protected void onStop() {
        super.onStop();
        String str=ed.getText().toString();
        SharedPreferences.Editor se = sp.edit();
        se.putString("data", str);
        se.commit();                                        // For Saving Data in Preferences, similar as commit in database
    }
}
