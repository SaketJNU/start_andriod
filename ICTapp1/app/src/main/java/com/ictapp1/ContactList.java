package com.ictapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ContactList extends AppCompatActivity {

    ListView lv;
    ArrayAdapter <String> ad;
    Cursor c;
    ArrayList<String> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        lv = findViewById(R.id.lv);
        c = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,
                null, null,
                null, ContactsContract.Contacts.DISPLAY_NAME);  // cursor object
        while (c.moveToNext())
        {
            int i = c.getColumnIndex(ContactsContract.Contacts.CONTACT_LAST_UPDATED_TIMESTAMP);
            int j = c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
            arrayList.add(c.getString(j)+ " " + c.getString(i));
        }
        ad = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        lv.setAdapter(ad);
    }
}
