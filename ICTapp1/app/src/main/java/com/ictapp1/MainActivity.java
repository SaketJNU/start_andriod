package com.ictapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    Button next, b1;
    EditText ed;
    boolean flag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Hello World! Create Activity", Toast.LENGTH_SHORT).show();
        next=findViewById(R.id.button);
        next.setOnClickListener(this);
        b1=findViewById(R.id.buttona);
        ed=findViewById(R.id.ed);
    }

    @Override
    protected void onRestart()
    {
       super.onRestart();
       Toast.makeText(this, "Hello World! on Restart Activity ", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Hello World! Start Activity", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Hello World! Stop Activity", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Hello World! Pause activity", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Hello World! Resume activity", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Hello World! Click on Button", Toast.LENGTH_SHORT).show();
        Intent i=new Intent(MainActivity.this,CounterActivity.class);
        startActivity(i);
            if(flag) {
                flag = false;
                ed.setInputType( InputType.TYPE_CLASS_TEXT);
            }
            else
            {ed.setInputType(InputType.TYPE_NUMBER_VARIATION_PASSWORD);

            }

    }
}
