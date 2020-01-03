package com.ictapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DBTest extends AppCompatActivity {

    EditText eid, ename, eaddress;
    Cursor c;                           // For SQLite database cursor
    SQLiteDatabase sd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbtest);
        eid = findViewById(R.id.eid);
        ename = findViewById(R.id.ename);
        eaddress = findViewById(R.id.eaddress);
        sd =openOrCreateDatabase("mydb",MODE_PRIVATE, null);  //  Database name is mydb
        sd.execSQL("create table if not exists employee (eid int primary key,"
                + "ename varchar ,"
                + "eaddress varchar)"
        );
        c = sd.rawQuery("select * from employee", null);
    }
    public void addRecord(View v)    {
    int id = Integer.parseInt(eid.getText().toString().trim());
    String name = ename.getText().toString();
    String add = eaddress.getText().toString();
        ContentValues cv = new ContentValues();
        cv.put("eid", id);
        cv.put("ename", name);
        cv.put("eaddress", add);
        long status = sd.insert("employee", null, cv);
        if (status > 0 )
        {
            Toast.makeText(this, "Data INSERTED SUCCESSFULLY", Toast.LENGTH_SHORT).show();
        }
    }
    public void nextRecord(View v)    {
    if (c.moveToNext())
    {
        eid.setText(""+c.getInt(0));
        ename.setText(c.getString(1));
        eaddress.setText(c.getString(2));
    }
    }
    public void previousRecord(View v)    {
        if (c.moveToPrevious())
        {
            eid.setText(""+c.getInt(0));
            ename.setText(c.getString(1));
            eaddress.setText(c.getString(2));
        }
    }

    public void firstRecord(View v)    {
        if (c.moveToFirst())
        {
            eid.setText(""+c.getInt(0));
            ename.setText(c.getString(1));
            eaddress.setText(c.getString(2));
        }
    }
    public void lastRecord(View v)
    {
        if (c.moveToLast())
        {
            eid.setText(""+c.getInt(0));
            ename.setText(c.getString(1));
            eaddress.setText(c.getString(2));
        }
    }
}
