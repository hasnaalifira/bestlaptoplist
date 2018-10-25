package com.example.nurul.uts;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private MyDataHelper dbHelper;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static HomeActivity layarutama;
    private List<MenuModel> myMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        layarutama = this;
        dbHelper = new MyDataHelper(this);

        Button btn = findViewById(R.id.btn01);
        //aksi button untuk berpindah ke halaman insert
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(
                        HomeActivity.this, InsertLaptop.class);
                startActivity(myintent);
            }
        });

        mRecyclerView = findViewById(R.id.rec);

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        TampilData();

        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), mRecyclerView, new ClickListener() {
            @Override
            public void onClick(final View v, int position) {
                final MenuModel menu = myMenu.get(position);
                final CharSequence[] dialogitem = {"Lihat Menu","Edit Menu","Hapus Menu"};
                AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);

                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case 0:
                                Intent lihatMenu = new Intent(getApplicationContext(), ViewLaptop.class);
                                lihatMenu.putExtra("id", ""+menu.getId());
                                startActivity(lihatMenu);
                                break;
                            case 1:
                                Intent editMenu = new Intent(getApplicationContext(),UpdateLaptop.class);
                                editMenu.putExtra("id",""+menu.getId());
                                startActivity(editMenu);
                                break;
                            case 2:
                                SQLiteDatabase db = dbHelper.getWritableDatabase();
                                int id = menu.getId();
                                db.execSQL("DELETE FROM laptop WHERE id="+id+"");
                                TampilData();
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        }));
    }

    public void TampilData(){
        this.myMenu= new ArrayList<>();
        myMenu.addAll(getAll());
        mAdapter = new MenuAdapter(myMenu);
        mRecyclerView.setAdapter(mAdapter);
    }

    public List<MenuModel> getAll(){
        List<MenuModel> menuList = new ArrayList<>();
        String selectQuery = "SELECT * FROM laptop";

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()){
            do {
                MenuModel menu = new MenuModel(cursor.getInt(0),
                        cursor.getString(1),cursor.getString(2),
                        cursor.getString(3),cursor.getString(4),
                        cursor.getString(5));
                menuList.add(menu);
            } while (cursor.moveToNext());
        }
        return menuList;
    }
}
