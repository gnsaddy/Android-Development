package com.addy.vehicledatastorage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelperClass databaseHelperClass;
    Button add, update, delete, view, mail;
    EditText idText, nameText, ccText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelperClass = new DatabaseHelperClass(this);
        add = findViewById(R.id.addbtn);
        update = findViewById(R.id.updatebtn);
        delete = findViewById(R.id.deleteBtn);
        view = findViewById(R.id.viewBtn);
        mail = findViewById(R.id.mailbtn);

        idText = findViewById(R.id.evid);
        nameText = findViewById(R.id.evname);
        ccText = findViewById(R.id.evengine);

        AddToDb();
        UpdateToDb();
        DeleteFromDb();
        GetAllFromDb();

        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuffer sb = new StringBuffer();
                sb.append(idText.getText().toString());
                sb.append(nameText.getText().toString());
                sb.append(ccText.getText().toString());
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,sb.toString());
                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent,"Choose Mail App"));
            }
        });

    }

    public void AddToDb() {
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = databaseHelperClass.InsertData(
                        idText.getText().toString(), nameText.getText().toString(), ccText.getText().toString()
                );

                if (isInserted) {
                    Toast.makeText(MainActivity.this, "Data Inserted !!!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Data Not Inserted !!!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void UpdateToDb() {
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isUpdated = databaseHelperClass.UpdateData(
                        idText.getText().toString(), nameText.getText().toString(), ccText.getText().toString()
                );
                if (isUpdated) {
                    Toast.makeText(MainActivity.this, "Data Updated !!!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Data Not Updated !!!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void DeleteFromDb() {
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long deleted = databaseHelperClass.DeleteData(idText.getText().toString());
                if (deleted > 0) {
                    Toast.makeText(MainActivity.this, "Data Deleted !!!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Data Not Deleted !!!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void GetAllFromDb() {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = databaseHelperClass.FetchData();

                    StringBuffer stringBuffer = new StringBuffer();
                    while (cursor.moveToNext()) {
                        stringBuffer.append(cursor.getString(0) + "\n");
                        stringBuffer.append( cursor.getString(1) + "\n");
                        stringBuffer.append(cursor.getString(2) + "\n\n");
                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Data's : ").setMessage(stringBuffer).show();
                }

        });
    }

}
