package com.example.nurul.uts;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDataHelper extends SQLiteOpenHelper {

    private static final  String NAMA_DB = "laptop.db";

    private static final String NAMA_TABEL = "laptop";

    private static final int VERSI_DB = 2;

    private static final String ID = "id";
    private static final String NAMA = "nama";
    private static final String TIPE = "tipe";
    private static final String  BERAT = "berat";
    private static final String RAM = "ram";
    private static final String HARGA = "harga";

    //membuat tabel
    private static final String CREATE_TABLE =
            "CREATE TABLE "
                    + NAMA_TABEL
                    + " ("
                    + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + NAMA + " VARCHAR(255), "
                    + TIPE + " VARCHAR(50), "
                    + BERAT + " VARCHAR (50), "
                    + RAM + " VARCHAR (50), "
                    + HARGA + " VARCHAR (50) "
                    + ");";

    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + NAMA_TABEL;

    public MyDataHelper(Context context) {
        super(context, NAMA_DB, null, VERSI_DB);
    }

    @Override
    //untuk menambahkan data
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);
    }

    //untuk mengedit data
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 2) {
            db.execSQL(DROP_TABLE);
            onCreate(db);

        }

    }
}
