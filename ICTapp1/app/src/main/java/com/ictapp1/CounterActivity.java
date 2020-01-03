package com.ictapp1;

import android.app.Activity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class CounterActivity extends  Activity implements View.OnClickListener {
    Button inc, dec, reset;
    TextView tv;
    int count = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.counter_activity);
        inc=findViewById(R.id.inc);
        dec=findViewById(R.id.dec);
        reset=findViewById(R.id.res);
        tv=findViewById(R.id.textView2);
        inc.setOnClickListener(this);
        dec.setOnClickListener(this);
        reset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.inc:
                count++;
                tv.setText("Count: "+count);
                break;
            case R.id.dec:
                count--;
                tv.setText("Count: "+count);
                break;
            case R.id.res:
                count = 0;
                tv.setText("Count: "+count);
                break;
        }
    }
}
