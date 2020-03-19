package com.addy.movietessera;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Calendar;

public class bookingActivity extends AppCompatActivity {
    public ProgressDialog pd;
    DatabaseHelperClass databaseHelperClass;
    ImageView addImg;
    EditText id, title, genre, date;
    Button upload,upd;
    int year, month, dayOfMonth;
    private ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        databaseHelperClass = new DatabaseHelperClass(bookingActivity.this);
        id = findViewById(R.id.movieId);
        addImg = findViewById(R.id.addImg);
        upload = findViewById(R.id.uploadButt);
        title = findViewById(R.id.movieTitle);
        date = findViewById(R.id.movieDate);
        genre = findViewById(R.id.movieGenre);
        upd = findViewById(R.id.update);
//        requestPermissions();
        AddToDb();
        UpdateToDb();

        final Calendar calendar = Calendar.getInstance();
        date.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(bookingActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                date.setText(day + "/" + (month + 1) + "/" + year);
                            }
                        }, year, month, dayOfMonth);
                datePickerDialog.show();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menuObj) {
        getMenuInflater().inflate(R.menu.menu, menuObj);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        LinearLayout linearLayout = findViewById(R.id.lout);
        switch (item.getItemId()) {
            case R.id.home:
                Toast.makeText(getApplicationContext(), "Switching to Home", Toast.LENGTH_LONG).show();
                Intent homeIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(homeIntent);
                return true;
            case R.id.contact:
                AlertDialog.Builder builder = new AlertDialog.Builder(bookingActivity.this);
                builder.setTitle("Contact US").setMessage("Email :- aditya.x510@gmail.com\nPhone :- +91 8271388851").show();
                return true;
            case R.id.viewData:
                Cursor cursor = databaseHelperClass.FetchData();
                StringBuffer stringBuffer = new StringBuffer();
                while (cursor.moveToNext()) {
                    stringBuffer.append("\n---------------------------------------\n");
                    stringBuffer.append("User ID : " + cursor.getString(0) + "\n");
                    stringBuffer.append("Movie Title : " + cursor.getString(1) + "\n");
                    stringBuffer.append("Movie Genere : " + cursor.getString(2) + "\n");
                    stringBuffer.append("Release Date : " + cursor.getString(3) + "\n");
                    stringBuffer.append("Price : " + 250 + "\n");
                    stringBuffer.append("\n---------------------------------------\n");
                }
                AlertDialog.Builder builder2 = new AlertDialog.Builder(bookingActivity.this);
                builder2.setTitle("Data's : ").setIcon(R.drawable.flame).setMessage(stringBuffer);
                builder2.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "Ok clicked", Toast.LENGTH_LONG).show();
                    }
                }).show();
                return true;
            case R.id.deleteTicket:
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                final EditText edittext = new EditText(this);
                alert.setMessage(id.getText().toString());
                alert.setTitle("Enter Your USER ID");
                alert.setView(edittext);
                alert.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        //What ever you want to do with the value
                        Editable YouEditTextValue = edittext.getText();
                        long deleted = databaseHelperClass.DeleteData(YouEditTextValue.toString());
                        if (deleted > 0) {
                            pd = new ProgressDialog(bookingActivity.this);
                            pd.setMessage("Deleting Data!!!!");
                            pd.setCancelable(false);
                            pd.show();
                            new Handler().postDelayed(new Runnable() {
                                public void run() {
                                    pd.dismiss();
                                }
                            }, 3000);
                            Toast.makeText(bookingActivity.this, "Data Deleted for user ID " + YouEditTextValue, Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(bookingActivity.this, "User ID { " + YouEditTextValue + " } not valid ", Toast.LENGTH_LONG).show();
                        }
                    }
                }).show();
                return true;
            default:
                super.onOptionsItemSelected(item);
        }
        return false;
    }

    public void AddToDb() {
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = databaseHelperClass.InsertData(
                        id.getText().toString(), title.getText().toString(), genre.getText().toString(), date.getText().toString()
                );
                if (isInserted) {
                    pd = new ProgressDialog(bookingActivity.this);
                    pd.setMessage("Adding Data!!!!");
                    pd.setCancelable(false);
                    pd.show();
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            pd.dismiss();
                        }
                    }, 3000);
                    Toast.makeText(bookingActivity.this, "Data Inserted !!!", Toast.LENGTH_LONG).show();
                    id.setText("");
                    title.setText("");
                    genre.setText("");
                    date.setText("");
                    id.setFocusable(true);
                } else {
                    Toast.makeText(bookingActivity.this, "Data Not Inserted !!!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void UpdateToDb() {
        upd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isUpdated = databaseHelperClass.UpdateData(
                        id.getText().toString(), title.getText().toString(), genre.getText().toString(), date.getText().toString()
                );
                if (isUpdated) {
                    Toast.makeText(bookingActivity.this, "Data Updated !!!", Toast.LENGTH_LONG).show();
                    id.setText("");
                    title.setText("");
                    genre.setText("");
                    date.setText("");
                    id.setFocusable(true);
                } else {
                    Toast.makeText(bookingActivity.this, "Data Not Updated !!!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
