package com.addy.mycontact;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> arrayList = new ArrayList<>();
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI,null,
                null,null,null);
        if(cursor.getCount()>0){
            while (cursor.moveToNext()){
                String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
//                add extra details if want
                if(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)))>0){
                    Cursor cursor1 = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID+"=",
                            new String[]{id},null);
                    while (cursor1.moveToNext()){
                        String phoneNo = cursor1.getString(cursor1.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        arrayList.add("Name: "+ name + "\nPhone no: "+ phoneNo );
                    }
                    cursor1.close();
                }
            }
        }
        lv =(ListView)findViewById(R.id.listview1);
        ArrayAdapter<String> adt = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayList);
        lv.setAdapter(adt);
    }
}
