package com.example.uasakbif_310119085;
//NIM : 10119085
//Nama : Arif Abdan Syakur
//Kelas : IF-3
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class MyDatabaseHelper extends SQLiteOpenHelper {

    public Context context;
    SQLiteDatabase db;
    public static final String DATABASE_NAME = "daily_note.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "list";
    public static final String COLOUM_ID = "id";
    public static final String COLOUM_DATE = "date";
    public static final String COLOUM_JUDUL = "judul";
    public static final String COLOUM_KATEGORI = "kategori";
    public static final String COLOUM_ISI = "isi";


    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                        " (" + COLOUM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLOUM_DATE + " TEXT, " +
                        COLOUM_JUDUL + " TEXT, " +
                        COLOUM_KATEGORI + " TEXT, " +
                        COLOUM_ISI + " TEXT);";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public void addData(String date, String judul, String kategori, String isi){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLOUM_DATE, date);
        cv.put(COLOUM_JUDUL, judul);
        cv.put(COLOUM_KATEGORI, kategori);
        cv.put(COLOUM_ISI, isi);

        long result = db.insert(TABLE_NAME, null, cv);
    }

    public Cursor readData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;


    }
    public void editdata(String row_id, String date, String judul, String kategori, String isi){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLOUM_DATE, date);
        cv.put(COLOUM_JUDUL, judul);
        cv.put(COLOUM_KATEGORI, kategori);
        cv.put(COLOUM_ISI, isi);

        long result = db.update(TABLE_NAME, cv, "id=?", new String[]{row_id});
    }

    void deleteOneRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "id=?", new String[]{row_id});
    }
}
