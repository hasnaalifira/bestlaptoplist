package com.example.nurul.uts;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertLaptop extends AppCompatActivity {
    protected Cursor cursor;
    MyDataHelper MenuHelper;
    Button btn1, btn2;
    EditText nama, tipe, berat, ram, harga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_laptop);

        MenuHelper = new MyDataHelper(this);
        nama = (EditText) findViewById(R.id.editText1);
        tipe = (EditText) findViewById(R.id.editText2);
        berat = (EditText) findViewById(R.id.editText3);
        ram = (EditText) findViewById(R.id.editText4);
        harga = (EditText) findViewById(R.id.editText5);

        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = MenuHelper.getWritableDatabase();
                db.execSQL("INSERT INTO laptop(nama, tipe, berat, ram, harga) values('" +
                        nama.getText().toString() + "','" +
                        tipe.getText().toString() + "','" +
                        berat.getText().toString() + "','" +
                        ram.getText().toString() + "','" +
                        harga.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), " berhasil ditambahkan",
                        Toast.LENGTH_LONG).show();

                HomeActivity.layarutama.TampilData();
                finish();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });
    }
}
