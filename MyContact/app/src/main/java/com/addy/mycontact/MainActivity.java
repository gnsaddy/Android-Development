package com.addy.mycontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> alist = new ArrayList<>();
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ContentResolver cr = getContentResolver();
        Cursor curs = cr.query(ContactsContract.Contacts.CONTENT_URI, null,
                ContactsContract.Contacts.HAS_PHONE_NUMBER + "=1", null, "UPPER(" + ContactsContract.Contacts.DISPLAY_NAME + ")ASC");

        if (curs.getCount() > 0) {
            while (curs.moveToNext()) {
                String id = curs.getString(curs.getColumnIndex(ContactsContract.Contacts._ID));
                String name = curs.getString(curs.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

                if (Integer.parseInt(curs.getString(curs.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {
                    Cursor pCur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                            ContactsContract.CommonDataKinds.Email.CONTACT_ID + "=?", new String[]{id}, null);
                    while (pCur.moveToNext()) {
                        String phnNo = pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        String email = pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA));
                        Log.e("Email", email);
                        alist.add("Name: " + name + "\nPhone No: " + phnNo + "\nEmail : " + email);
                    }
                    pCur.close();
                }
            }
        }
        lv = (ListView) findViewById(R.id.listview1);
        ArrayAdapter<String> adt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alist);
        lv.setAdapter(adt);
    }
}
