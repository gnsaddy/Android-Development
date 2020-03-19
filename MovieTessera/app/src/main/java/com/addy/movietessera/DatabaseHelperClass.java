package com.addy.movietessera;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelperClass extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "movie.db";
    public static final String TABLE_NAME = "movie_table";
    public static final String COL_ID = "mid";
    public static final String COL_NAME = "mname";
    public static final String COL_GENERE = "mgenere";
    public static final String COL_RELEASE = "rdate";
    public static final String COL_PRICE = "price";

    public DatabaseHelperClass(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME +
                "(mid varchar(30) primary key, mname text, mgenere text, rdate text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean InsertData(String mid, String mname, String mgenere, String rdate) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_ID, mid);
        cv.put(COL_NAME, mname);
        cv.put(COL_GENERE, mgenere);
        cv.put(COL_RELEASE, rdate);
        long inserted = db.insert(TABLE_NAME, null, cv);
        if (inserted == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean UpdateData(String mid, String mname, String mgenere, String rdate){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_ID,mid);
        contentValues.put(COL_NAME,mname);
        contentValues.put(COL_GENERE,mgenere);
        contentValues.put(COL_RELEASE,rdate);
        db.update(TABLE_NAME,contentValues," mid = ? ",new String[] { mid });
        return true;
    }

    public Cursor FetchData(){
        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cur = getWritableDatabase().rawQuery("SELECT * FROM " + TABLE_NAME, null);
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return cursor;
    }

    public Integer DeleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME," mid = ? ", new String[] { id });
    }

}
