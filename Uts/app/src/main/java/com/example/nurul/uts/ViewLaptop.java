package com.example.nurul.uts;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewLaptop extends AppCompatActivity {
    private MyDataHelper dbHelper;
    public TextView nama, tipe, berat, ram, harga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_laptop);

        Intent intent = getIntent();

        nama = findViewById(R.id.namalaptop);
        tipe = findViewById(R.id.tipe);
        berat = findViewById(R.id.berat);
        ram = findViewById(R.id.ram);
        harga = findViewById(R.id.harga);

        dbHelper = new MyDataHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        int id = Integer.parseInt(intent.getStringExtra("id"));
        Cursor cursor = db.rawQuery("SELECT * FROM laptop WHERE id="+id,null);
        if (cursor.getCount()>0){
            cursor.moveToPosition(0);
            // Set Variabel dengan Intent
            nama.setText(cursor.getString(1));
            tipe.setText(cursor.getString(2));
            berat.setText(cursor.getString(3));
            ram.setText(cursor.getString(4)+" GB");
            harga.setText(cursor.getString(5));
        }
    }
}
