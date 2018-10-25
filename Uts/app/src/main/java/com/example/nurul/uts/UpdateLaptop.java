package com.example.nurul.uts;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateLaptop extends AppCompatActivity{

    protected Cursor cursor;
    MyDataHelper dbHelper;
    Button btn1, btn2;
    EditText text6,text3,text4,text5,text2;
    String ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_laptop);

        //menempatkan var data ke masing2 id field
        dbHelper = new MyDataHelper(this);
        text2 = (EditText) findViewById(R.id.editText2);
        text3 = (EditText) findViewById(R.id.editText3);
        text4 = (EditText) findViewById(R.id.editText4);
        text5 = (EditText) findViewById(R.id.editText5);
        text6 = (EditText) findViewById(R.id.editText6);

        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);

        //inisialisasi db untuk dbhelper
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        //query untuk mengambil data untuk judul yang dipilih
        cursor = db.rawQuery("SELECT * FROM laptop WHERE id = " +
                getIntent().getStringExtra("id") + "", null);
        cursor.moveToFirst();

        //mendapatkan data
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            ID = cursor.getString(0);
            text2.setText(cursor.getString(1));
            text3.setText(cursor.getString(2));
            text4.setText(cursor.getString(3));
            text5.setText(cursor.getString(4));
            text6.setText(cursor.getString(5));
        }

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //inisialisasi db untuk menulis query
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                //query untuk update
                db.execSQL(" UPDATE laptop SET nama='" + text2.getText().toString() + "', tipe = '" +
                        text3.getText().toString() +
                        "', berat='" + text4.getText().toString() + "', ram = '" + text5.getText().toString() +
                        "', harga = '" + text6.getText().toString()
                        + "' WHERE id ='" + getIntent().getStringExtra("id") + "'");
                Toast.makeText(getApplicationContext(), "berhasil diubah", Toast.LENGTH_LONG).show();
                //kembali ke halaman utama atau listview
                HomeActivity.layarutama.TampilData();
                finish();

            }
        });

        //button kembali
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });

    }


}
